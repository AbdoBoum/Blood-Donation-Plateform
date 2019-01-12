package DAO.InterfacesImpl;

import DAO.DAOFactory;
import DAO.Interfaces.ConcerneDemandeDao;
import Models.ConcerneDemande;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ConcerneDemandeDaoImpl implements ConcerneDemandeDao {

    private DAOFactory daoFactory;

    public ConcerneDemandeDaoImpl(DAOFactory daoFactory){
        this.daoFactory = daoFactory;
    }

    @Override
    public ConcerneDemande insertConcerneDemande(ConcerneDemande concerneDemande) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("INSERT into concerne_demande values (?, ?)");
            preparedStatement.setInt(1, concerneDemande.getIdDemande());
            preparedStatement.setInt(2, concerneDemande.getIdGroupeSang());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return concerneDemande;
    }

    @Override
    public ConcerneDemande getConcerneDemande(int idDemande, int idGroupeSang) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ConcerneDemande concerneDemande;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * from concerne_demande where id_demande = ? and id_groupeSang = ?");
            preparedStatement.setInt(1, idDemande);
            preparedStatement.setInt(2, idGroupeSang);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                concerneDemande = new ConcerneDemande();
                concerneDemande.setIdDemande(resultSet.getInt(1));
                concerneDemande.setIdGroupeSang(resultSet.getInt(2));
                preparedStatement.close();
                return concerneDemande;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ConcerneDemande> getAllConcerneDemande() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ConcerneDemande concerneDemande;
        List<ConcerneDemande> concerneDemandes = new ArrayList<ConcerneDemande>();

        try{
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * from concerne_demande");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                concerneDemande = new ConcerneDemande();
                concerneDemande.setIdDemande(resultSet.getInt(1));
                concerneDemande.setIdGroupeSang(resultSet.getInt(2));
                concerneDemandes.add(concerneDemande);
            }
            preparedStatement.close();
            return concerneDemandes;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
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
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
