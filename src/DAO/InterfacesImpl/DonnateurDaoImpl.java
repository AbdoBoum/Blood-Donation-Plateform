package DAO.InterfacesImpl;

import DAO.DAOFactory;
import DAO.Interfaces.DonnateurDao;
import Helper.Utile;
import Models.Donnateur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DonnateurDaoImpl implements DonnateurDao {
    private DAOFactory daoFactory;

    public DonnateurDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public boolean addDonnateur(Donnateur donnateur) {
        boolean result = false;
        try {
            Connection connection = daoFactory.getConnection();
            Statement exist = connection.createStatement();
            ResultSet existResult = exist.executeQuery("SELECT EXISTS( SELECT * FROM donnateur WHERE email_donnateur='" + donnateur.getEmailDonnateur() + "' ) AS user_exist;");
            existResult.next();
            //checking if the user already exist before inserting him
            if (!existResult.getBoolean("user_exist")) {
                String insertQuery = "INSERT INTO donnateur(cin_donnateur,email_donnateur,id_groupeSang,id_ville,nom_donnateur,password_donnateur,prenom_donnateur,tele_donnateur) VALUES(?,?,?,?,?,?,?,?);";
                PreparedStatement prs = connection.prepareStatement(insertQuery);
                prs.setString(1, donnateur.getCinDonnateur());
                prs.setString(2, donnateur.getEmailDonnateur());
                prs.setInt(3, donnateur.getIdGroupeSangDonnateur());
                prs.setInt(4, donnateur.getIdVilleDonnateur());
                prs.setString(5, donnateur.getNomDonnateur());
                prs.setString(6, donnateur.getPasswordDonnateur());
                prs.setString(7, donnateur.getPrenomDonnateur());
                prs.setString(8, donnateur.getTeleDonnateur());

                prs.executeUpdate();
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Donnateur getDonnateur(String email, String password) {
        try {
            Connection connection = daoFactory.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM donnateur WHERE email_donnateur='" + email + "' AND password_donnateur='" + password + "';");
            if (result.next()) {
                Donnateur donnateur = new Donnateur();
                donnateur.setIdDonnateur(result.getInt("id_donnateur"));
                donnateur.setCinDonnateur(result.getString("cin_donnateur"));
                donnateur.setEmailDonnateur(email);
                donnateur.setNomDonnateur(result.getString("nom_donnateur"));
                donnateur.setPrenomDonnateur(result.getString("prenom_donnateur"));
                donnateur.setIdVilleDonnateur(result.getInt("id_ville"));
                donnateur.setIdGroupeSangDonnateur(result.getInt("id_groupeSang"));
                donnateur.setTeleDonnateur(result.getString("tele_donnateur"));
                return donnateur;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Donnateur getDonnateur(int id){
        try {
            Connection connection = daoFactory.getConnection();
            Statement statement=connection.createStatement();
            ResultSet result =statement.executeQuery("SELECT * FROM donnateur WHERE id_donnateur='"+id+"';");
            if(result.next()){
                Donnateur donnateur = new Donnateur();
                donnateur.setIdDonnateur(result.getInt("id_donnateur"));
                donnateur.setCinDonnateur(result.getString("cin_donnateur"));
                donnateur.setNomDonnateur(result.getString("nom_donnateur"));
                donnateur.setPrenomDonnateur(result.getString("prenom_donnateur"));
                donnateur.setEmailDonnateur(result.getString("email_donnateur"));
                donnateur.setPasswordDonnateur(result.getString("password_donnateur"));
                donnateur.setTeleDonnateur(result.getString("tele_donnateur"));
                donnateur.setIdVilleDonnateur(result.getInt("id_ville"));
                donnateur.setIdGroupeSangDonnateur(result.getInt("id_groupeSang"));
                return donnateur;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean findDonnateurByMail(String mail) {
        try {
            Connection connection = daoFactory.getConnection();
            Statement statement=connection.createStatement();
            ResultSet result =statement.executeQuery("SELECT * FROM donnateur WHERE email_donnateur='"+mail+"';");
            if(result.next()){
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return false;
    }

    @Override
    public boolean removeDonnateur(String email) {
        String query = "DELETE FROM donnateur WHERE email_donnateur=? ;";
        try {
            Connection connection = daoFactory.getConnection();
            PreparedStatement prs = connection.prepareStatement(query);
            prs.setString(1, email);
            prs.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Donnateur> getAllDonnateurs() {
        try {
            Connection connection = daoFactory.getConnection();
            Statement statement=connection.createStatement();
            ResultSet result =statement.executeQuery("SELECT * FROM donnateur;");
            List<Donnateur> donnateurList = new ArrayList<>();
            while(result.next()){
                Donnateur donnateur = new Donnateur();
                donnateur.setIdDonnateur(result.getInt("id_donnateur"));
                donnateur.setCinDonnateur(result.getString("cin_donnateur"));
                donnateur.setEmailDonnateur(result.getString("email_donnateur"));
                donnateur.setNomDonnateur(result.getString("nom_donnateur"));
                donnateur.setPrenomDonnateur(result.getString("prenom_donnateur"));
                donnateur.setIdVilleDonnateur(result.getInt("id_ville"));
                donnateur.setIdGroupeSangDonnateur(result.getInt("id_groupeSang"));
                donnateur.setTeleDonnateur(result.getString("tele_donnateur"));
                donnateurList.add(donnateur);
            }
            return donnateurList;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Donnateur> getDonnateursByCity(int idVille) {
        try {
            Connection connection = daoFactory.getConnection();
            Statement statement=connection.createStatement();
            ResultSet result =statement.executeQuery("SELECT * FROM donnateur WHERE id_ville='"+idVille+"';");
            List<Donnateur> donnateurList = new ArrayList<>();
            while(result.next()){
                Donnateur donnateur = new Donnateur();
                donnateur.setIdDonnateur(result.getInt("id_donnateur"));
                donnateur.setCinDonnateur(result.getString("cin_donnateur"));
                donnateur.setEmailDonnateur(result.getString("email_donnateur"));
                donnateur.setNomDonnateur(result.getString("nom_donnateur"));
                donnateur.setPrenomDonnateur(result.getString("prenom_donnateur"));
                donnateur.setIdVilleDonnateur(result.getInt("id_ville"));
                donnateur.setIdGroupeSangDonnateur(result.getInt("id_groupeSang"));
                donnateur.setTeleDonnateur(result.getString("tele_donnateur"));
                donnateurList.add(donnateur);
            }
            return donnateurList;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateDonnateur(Donnateur donnateur) {
        try {
            Connection connection=daoFactory.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("UPDATE donnateur SET email_donnateur=?, password_donnateur=?, tele_donnateur=?, id_ville=?, " +
                    "id_groupeSang=?, cin_donnateur=?, nom_donnateur=?, prenom_donnateur=? WHERE id_donnateur=?");
            preparedStatement.setString(1,donnateur.getEmailDonnateur());
            preparedStatement.setString(2,donnateur.getPasswordDonnateur());
            preparedStatement.setString(3,donnateur.getTeleDonnateur());
            preparedStatement.setInt(4,donnateur.getIdVilleDonnateur());
            preparedStatement.setInt(5,donnateur.getIdGroupeSangDonnateur());
            preparedStatement.setString(6, donnateur.getCinDonnateur());
            preparedStatement.setString(7, donnateur.getNomDonnateur());
            preparedStatement.setString(8, donnateur.getPrenomDonnateur());
            preparedStatement.setInt(9,donnateur.getIdDonnateur());
            preparedStatement.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int CountDonorsPerCity( int idVille) {
        int countDonors = 0;

        try {
            Connection connection = daoFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT  count(id_donnateur) AS nbDonors FROM donnateur WHERE id_ville='"+idVille+"'");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                countDonors = Integer.parseInt(resultSet.getString("nbDonors"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return countDonors;
    }

}
