package DAO.InterfacesImpl;

import DAO.DAOFactory;
import DAO.Interfaces.ConcerneDemandeDao;
import DAO.Interfaces.DemandeDao;
import Models.ConcerneDemande;
import Models.Demande;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DemandeDaoImpl implements DemandeDao {
    private DAOFactory daoFactory;
    private ConcerneDemandeDao concerneDemandeDao;

    public DemandeDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
        concerneDemandeDao = daoFactory.getConcerneDemandeDao();
    }

    @Override
    public boolean addDemande(Demande demande) {
        String query = "INSERT INTO Demande(date_demande,imagePath_demande,description_demande,isActive,is_urgent,id_centre,titre_demande,id_ville) VALUES(?,?,?,?,?,?,?,?);";
        try {
            Connection connection = daoFactory.getConnection();
            PreparedStatement prs = connection.prepareStatement(query);
            prs.setTimestamp(1, demande.getDateDemande());
            prs.setString(2, demande.getPathImgDemande());
            prs.setString(3, demande.getDescriptionDemande());
            prs.setBoolean(4, demande.isActive());
            prs.setBoolean(5, demande.isUrgent());
            prs.setInt(6, demande.getIdCentre());
            prs.setString(7,demande.getTitleDemande());
            prs.setInt(8,demande.getIdVilleDemande());

            prs.execute();
            prs.close();
            if (concerneDemandeDao.setAllGroupsConcerned(demande))
                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Demande> getAllDemands() {
        String query = "SELECT * FROM demande WHERE isActive=? ORDER BY date_demande DESC";
        try {
            Connection connection = daoFactory.getConnection();
            PreparedStatement prs = connection.prepareStatement(query);
            prs.setBoolean(1,true);
            ResultSet resultSet = prs.executeQuery();
            List<Demande> demandeList = exctractInfos(resultSet);
            return demandeList;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Demande> getDemandsFiltred(boolean etatDemande, boolean isUrgent, int idGroupSang, Date date, String idVille) {
        return null;
    }

    @Override
    public List<Demande> getAllDemandsOfCenter(int idCentre) {
        return null;
    }

    @Override
    public boolean editDemande(Demande demande) {
        String editQuery = "UPDATE demande SET date_demande=?, imagePath_demande=?, description_demande=?, isActive=?, is_urgent=?, titre_demande=?, id_ville=? WHERE id_demande=?;";
        try {
            Connection connection = daoFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(editQuery);
            preparedStatement.setTimestamp(1,demande.getDateDemande());
            preparedStatement.setString(2,demande.getPathImgDemande());
            preparedStatement.setString(3,demande.getDescriptionDemande());
            preparedStatement.setBoolean(4,demande.isActive());
            preparedStatement.setBoolean(5,demande.isUrgent());
            preparedStatement.setString(6,demande.getTitleDemande());
            preparedStatement.setInt(7,demande.getIdVilleDemande());
            preparedStatement.setInt(8,demande.getIdDemande());
            preparedStatement.execute();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteDemande(int idDemande) {
        String query = "DELETE FROM demande WHERE id_demande=?";
        try {
            Connection connection = daoFactory.getConnection();
            PreparedStatement prs = connection.prepareStatement(query);
            prs.setInt(1,idDemande);
            prs.execute();
            if(getRequestById(idDemande)==null){
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Demande> getRequestsByPagination(int start, int total , int villeFilter, int groupeFilter) {

        String query = "SELECT  * FROM demande WHERE isActive=1 order by date_demande DESC limit " + start  + "," + total;

        if(groupeFilter == -1 && villeFilter != -1){
            query = "SELECT  * FROM demande WHERE isActive=1 AND id_ville='"+villeFilter+"' order by date_demande DESC limit " + start  + "," + total;
        }else if(villeFilter==-1 && groupeFilter != -1){
            query = "SELECT * FROM demande AS D WHERE isActive=1 AND "+groupeFilter+" IN (SELECT id_groupeSang FROM concerne_demande AS C WHERE C.id_demande=D.id_demande) order by date_demande DESC limit " + start  + "," + total;
        } else if(villeFilter !=-1 && groupeFilter !=-1){
            query = "SELECT * FROM demande AS D WHERE isActive=1 AND id_ville='"+villeFilter+"' AND "+groupeFilter+" IN (SELECT id_groupeSang FROM concerne_demande AS C WHERE C.id_demande=D.id_demande) order by date_demande DESC limit " + start  + "," + total;
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Demande> requests = new ArrayList<>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            requests = exctractInfos(resultSet);
        }catch (Exception e){
            e.printStackTrace();
        }

        return requests;
    }

    private List<Demande> exctractInfos(ResultSet resultSet) throws SQLException{
        List<Demande> demandeList = new ArrayList<>();
        while (resultSet.next()){
            Demande demande = new Demande();
            demande.setIdDemande(resultSet.getInt("id_demande"));
            demande.setIdVilleDemande(resultSet.getInt("id_ville"));
            demande.setTitleDemande(resultSet.getString("titre_demande"));
            demande.setDescriptionDemande(resultSet.getString("description_demande"));
            demande.setUrgent(resultSet.getBoolean("is_urgent"));
            demande.setPathImgDemande(resultSet.getString("imagePath_demande"));
            demande.setActive(true);
            demande.setIdCentre(resultSet.getInt("id_centre"));
            demande.setDateDemande(resultSet.getTimestamp("date_demande"));
            demande.setSangGroups(concerneDemandeDao.getAllGroupesConcerned(demande.getIdDemande()));
            demandeList.add(demande);

        }
        return demandeList;

    }

    @Override
    public int countRequests() {
        int requestsCount = 0;
        try {
            Connection connection = daoFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT  count(id_demande) AS nbrRequests FROM demande");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                requestsCount = Integer.parseInt(resultSet.getString("nbrRequests"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return requestsCount;
    }

    @Override
    public Demande getRequestById(int id) {
        String query = "SELECT * FROM demande WHERE id_demande="+id;
        try {
            Connection connection = daoFactory.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<Demande> demandeList = exctractInfos(resultSet);
            if(demandeList != null && demandeList.size()!=0)
                return demandeList.get(0);

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


}
