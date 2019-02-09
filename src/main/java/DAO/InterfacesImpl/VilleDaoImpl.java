package DAO.InterfacesImpl;

import DAO.DAOFactory;
import DAO.Interfaces.VilleDao;
import Models.Ville;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VilleDaoImpl implements VilleDao {

    private DAOFactory daoFactory;

    public VilleDaoImpl(DAOFactory daoFactory){
        this.daoFactory = daoFactory;
    }

    @Override
    public Ville insertVille(Ville ville) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement2 = null;
        ResultSet resultSet = null;

        try {
            /* etablish the connection and execute the query to add a city*/
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO Ville (nom_ville) VALUES (?)");
            preparedStatement.setString(1, ville.getNomVille());
            preparedStatement.executeUpdate();

            /* the id is auto_increment so we have to take it from the data base and it will be the last id inserted(max)*/
            preparedStatement2 = connection.prepareStatement("SELECT max(id_ville) AS MAXID FROM Ville");
            resultSet = preparedStatement2.executeQuery();
            if(resultSet.next()){
                ville.setIdVille(resultSet.getInt("MAXID"));
            }

            /* close the prepared statements */
            preparedStatement.close();
            preparedStatement2.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return ville;
    }

    @Override
    public List<Ville> getVilleByName(String NomVille) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Ville ville;
        List<Ville> villes = new ArrayList<Ville>();

        try {
            /* Select all cities with that name */
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("SELECT  * FROM Ville WHERE nom_ville LIKE ?");
            preparedStatement.setString(1, "%" + NomVille + "%");
            resultSet = preparedStatement.executeQuery();
            exctractInfos(villes, resultSet);
            preparedStatement.close();
            return villes;
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Ville getVilleById(int idVille) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Ville ville;

        try{
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("SELECT  * from Ville where id_ville = ?");
            preparedStatement.setInt(1, idVille);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                ville = new Ville();
                ville.setIdVille(resultSet.getInt(1));
                ville.setNomVille(resultSet.getString(2));
                preparedStatement.close();
                return ville;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Ville> getAllVille() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Ville ville;
        List<Ville> villes = new ArrayList<Ville>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("select  * from  Ville");
            resultSet = preparedStatement.executeQuery();
            exctractInfos(villes, resultSet);
            preparedStatement.close();
            return villes;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteVille(int idVille) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("delete FROM Ville where id_ville = ?");
            preparedStatement.setInt(1, idVille);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;

    }

    /* method to extract information from Blog table and put theme into a list*/
    public void exctractInfos(List<Ville> villes, ResultSet resultSet) throws SQLException {
        while (resultSet.next()){
            Ville ville = new Ville();
            ville.setIdVille(resultSet.getInt(1));
            ville.setNomVille(resultSet.getString(2));
            villes.add(ville);
        }
    }

}
