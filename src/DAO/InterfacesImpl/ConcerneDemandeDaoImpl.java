package DAO.InterfacesImpl;

import DAO.DAOFactory;
import DAO.Interfaces.ConcerneDemandeDao;
import Models.ConcerneDemande;
import Models.Demande;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConcerneDemandeDaoImpl implements ConcerneDemandeDao {

    private DAOFactory daoFactory;

    public ConcerneDemandeDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public List<ConcerneDemande> getAllGroupesConcerned(int idDemande) {
        String concerne = "SELECT * FROM concerne_demande WHERE id_demande=?";
        try{
            Connection connection = daoFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(concerne);
            preparedStatement.setInt(1,idDemande);
            ResultSet result = preparedStatement.executeQuery();
            List<ConcerneDemande> concerneDemandeList = new ArrayList<>();
            while(result.next()){
                ConcerneDemande concerneDemande = new ConcerneDemande();
                concerneDemande.setIdDemande(idDemande);
                concerneDemande.setIdGroupeSang(result.getInt("id_groupeSang"));
                concerneDemandeList.add(concerneDemande);
            }
            return concerneDemandeList;
        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean setAllGroupsConcerned(Demande demande) {

        try {
            Connection connection = daoFactory.getConnection();
            String getsql = "SELECT id_demande FROM demande WHERE date_demande=?";
            PreparedStatement statement = connection.prepareStatement(getsql);
            statement.setTimestamp(1, demande.getDateDemande());
            ResultSet resultSet = statement.executeQuery();
            System.out.println("debug : " + resultSet.toString());
            if (resultSet.next()) {
                System.out.println("concerne demande");
                for (ConcerneDemande concerneDemande : demande.getSangGroups()) {
                    concerneDemande.setIdDemande(resultSet.getInt("id_demande"));
                    String query = "INSERT INTO concerne_demande(id_demande,id_groupeSang) VALUES(?,?);";
                    PreparedStatement prs = connection.prepareStatement(query);
                    prs.setInt(1, concerneDemande.getIdDemande());
                    prs.setInt(2, concerneDemande.getIdGroupeSang());
                    prs.execute();
                    prs.close();
                }
            }
            connection.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean deleteConcerneDemande(int idDemande, int idGroupeSang) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("delete FROM concerne_demande where id_demande = ? and id_groupeSang = ?");
            preparedStatement.setInt(1, idDemande);
            preparedStatement.setInt(2, idGroupeSang);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
