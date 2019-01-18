package DAO.InterfacesImpl;

import DAO.DAOFactory;
import DAO.Interfaces.DemandeDao;
import Models.ConcerneDemande;
import Models.Demande;

import java.sql.*;
import java.util.List;

public class DemandeDaoImpl implements DemandeDao {
    private DAOFactory daoFactory;

    public DemandeDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public boolean addDemande(Demande demande) {
        String query = "INSERT INTO Demande(date_demande,imagePath_demande,description_demande,isActive,is_urgent,id_centre) VALUES(?,?,?,?,?,?);";
        try {
            Connection connection = daoFactory.getConnection();
            PreparedStatement prs = connection.prepareStatement(query);
            prs.setTimestamp(1,demande.getDateDemande());
            prs.setString(2,demande.getPathImgDemande());
            prs.setString(3,demande.getDescriptionDemande());
            prs.setBoolean(4,demande.isActive());
            prs.setBoolean(5,demande.isUrgent());
            prs.setInt(6,demande.getIdCentre());

            prs.execute();
            prs.close();
            if(setAllGroupsConcerned(demande))
                return true;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Demande> getAllDemands() {
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
    public boolean editDemande(boolean etatDemande) {
        return false;
    }

    @Override
    public boolean deleteDemande(int idDemande) {
        return false;
    }

    @Override
    public List<ConcerneDemande> getAllGroupesConcerned(int idDemande) {
        return null;
    }

    @Override
    public boolean setAllGroupsConcerned(Demande demande) {

        try {
            Connection connection = daoFactory.getConnection();
            String getsql = "SELECT id_demande FROM demande WHERE date_demande=?";
            PreparedStatement statement = connection.prepareStatement(getsql);
            statement.setTimestamp(1,demande.getDateDemande());
            ResultSet resultSet = statement.executeQuery();
            System.out.println("debug : "+resultSet.toString());
            if(resultSet.next()){
                System.out.println("concerne demande");
                for(ConcerneDemande concerneDemande : demande.getSangGroups()){
                    concerneDemande.setIdDemande(resultSet.getInt("id_demande"));
                    String query = "INSERT INTO concerne_demande(id_demande,id_groupeSang) VALUES(?,?);";
                    PreparedStatement prs = connection.prepareStatement(query);
                    prs.setInt(1,concerneDemande.getIdDemande());
                    prs.setInt(2,concerneDemande.getIdGroupeSang());
                    prs.execute();
                    prs.close();
                }
            }
            connection.close();
            return true;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;

    }
}
