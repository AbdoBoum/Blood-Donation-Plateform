package DAO.InterfacesImpl;

import DAO.DAOFactory;
import DAO.Interfaces.EvenementDao;
import Models.Evenement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EvenementDaoImpl implements EvenementDao {

    DAOFactory daoFactory = null;

    public EvenementDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Evenement getEvenementById(int idEvenement) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        Evenement evenement=null;
        try{
            connection=daoFactory.getConnection();
            preparedStatement=connection.prepareStatement("SELECT * from evenement WHERE id_evenement=?");
            preparedStatement.setInt(1,idEvenement);
            ResultSet rs=preparedStatement.executeQuery();
            if(rs.next()){
                evenement=new Evenement();
                evenement.setIdEvenement(rs.getInt("id_evenement"));
                evenement.setTitreEvenement(rs.getString("titre_evenement"));
                evenement.setDesciptionEvenement(rs.getString("description_evenement"));
                evenement.setDateEvenement(rs.getTimestamp("date_evenement"));
                evenement.setImagePathEvenement(rs.getString("imagePath_evenement"));
                evenement.setIdVille(rs.getInt("id_ville"));
                evenement.setIdCentre(rs.getInt("id_centre"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return evenement;
    }

    @Override
    public boolean insertEvenement(Evenement evenement) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            connection=daoFactory.getConnection();
            preparedStatement=connection.prepareStatement("insert into evenement(titre_evenement,description_evenement,date_evenement,imagePath_evenement,id_ville,id_centre) values (?,?,?,?,?,?)");
            preparedStatement.setString(1,evenement.getTitreEvenement());
            preparedStatement.setString(2,evenement.getDesciptionEvenement());
            preparedStatement.setTimestamp(3,evenement.getDateEvenement());
            preparedStatement.setString(4,evenement.getImagePathEvenement());
            preparedStatement.setInt(5,evenement.getIdVille());
            preparedStatement.setInt(6,evenement.getIdCentre());
            preparedStatement.executeUpdate();
            return true;

        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean updateEvenement(Evenement evenement) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            connection=daoFactory.getConnection();
            preparedStatement=connection.prepareStatement("update evenement set titre_evenement=?,description_evenement=?,date_evenement=?,imagePath_evenement=?,id_ville=?,id_centre=? where id_evenement=?");
            preparedStatement.setString(1,evenement.getTitreEvenement());
            preparedStatement.setString(2,evenement.getDesciptionEvenement());
            preparedStatement.setTimestamp(3,evenement.getDateEvenement());
            preparedStatement.setString(4,evenement.getImagePathEvenement());
            preparedStatement.setInt(5,evenement.getIdVille());
            preparedStatement.setInt(6,evenement.getIdCentre());
            preparedStatement.setInt(7,evenement.getIdEvenement());

            preparedStatement.executeUpdate();
            return true;

        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Evenement getEvenementByTitle(String title){
            Connection connection=null;
            PreparedStatement preparedStatement=null;
            Evenement evenement=null;
            try{
                connection=daoFactory.getConnection();
                preparedStatement=connection.prepareStatement("SELECT * from evenement WHERE titre_evenement=?");
                preparedStatement.setString(1,title);
                ResultSet rs=preparedStatement.executeQuery();
                if(rs.next()){
                    evenement=new Evenement();
                    evenement.setTitreEvenement(rs.getString("titre_evenement"));
                    evenement.setDesciptionEvenement(rs.getString("description_evenement"));
                    evenement.setDateEvenement(rs.getTimestamp("date_evenement"));
                    evenement.setImagePathEvenement(rs.getString("imagePath_evenement"));
                    evenement.setIdVille(rs.getInt("id_ville"));
                    evenement.setIdCentre(rs.getInt("id_centre"));
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
            return evenement;
    }

    @Override
    public boolean deleteEvenement(int idEvenement) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            connection=daoFactory.getConnection();
            preparedStatement=connection.prepareStatement("DELETE from evenement WHERE id_evenement=?");
            preparedStatement.setInt(1,idEvenement);
            preparedStatement.executeUpdate();
            return true;

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public List<Evenement> getAllEvenement() {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        List<Evenement> evenements=null;
        try{
            connection=daoFactory.getConnection();
            preparedStatement=connection.prepareStatement("SELECT * from evenement ORDER by date_evenement DESC");
            ResultSet rs=preparedStatement.executeQuery();
            if(rs.next()){

                evenements=new ArrayList<>();
            }
            while(rs.next()){
                Evenement evenement=new Evenement();
                evenement.setIdEvenement(rs.getInt("id_evenement"));
                evenement.setTitreEvenement(rs.getString("titre_evenement"));
                evenement.setDesciptionEvenement(rs.getString("description_evenement"));
                evenement.setDateEvenement(rs.getTimestamp("date_evenement"));
                evenement.setImagePathEvenement(rs.getString("imagePath_evenement"));
                evenement.setIdVille(rs.getInt("id_ville"));
                evenement.setIdCentre(rs.getInt("id_centre"));
                evenements.add(evenement);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return evenements;
    }

    @Override
    public int countEvents(){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            connection=daoFactory.getConnection();
            preparedStatement=connection.prepareStatement("SELECT count(id_evenement) as count from evenement ");
            ResultSet rs=preparedStatement.executeQuery();
            if(rs.next()){
                return rs.getInt("count");
            }
        }catch(SQLException e){
            e.printStackTrace();
            return 0;
        }
        return 0;
    }

    @Override
    public List<Evenement> getEvenementByPagination(int start, int total) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        List<Evenement> evenements=null;
        try{
            connection=daoFactory.getConnection();
            preparedStatement=connection.prepareStatement("SELECT * from evenement ORDER by date_evenement DESC limit ?,?");
            preparedStatement.setInt(1,start);
            preparedStatement.setInt(2,total);
            ResultSet rs=preparedStatement.executeQuery();

            evenements=new ArrayList<>();
            while(rs.next()){
                Evenement evenement=new Evenement();
                evenement.setIdEvenement(rs.getInt("id_evenement"));
                evenement.setTitreEvenement(rs.getString("titre_evenement"));
                evenement.setDesciptionEvenement(rs.getString("description_evenement"));
                evenement.setDateEvenement(rs.getTimestamp("date_evenement"));
                evenement.setImagePathEvenement(rs.getString("imagePath_evenement"));
                evenement.setIdVille(rs.getInt("id_ville"));
                evenement.setIdCentre(rs.getInt("id_centre"));
                evenements.add(evenement);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return evenements;
    }

    @Override
    public int countEventsPerCity(int idVille) {
        int eventsCount = 0;
        try {
            Connection connection = daoFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT count(id_evenement) AS nbrEvents FROM evenement WHERE id_ville="+idVille);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                eventsCount = Integer.parseInt(resultSet.getString("nbrRequests"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eventsCount;
    }
}
