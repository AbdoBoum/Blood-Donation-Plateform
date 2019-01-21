package DAO.InterfacesImpl;

import DAO.DAOFactory;
import DAO.Interfaces.DonnateurDao;
import Helper.Utile;
import Models.Donnateur;

import java.sql.*;

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
    public boolean removeDonnateur(String email) {
        String query = "DELETE FROM donnateur WHERE email_donnateur=? ;";
        boolean result = false;
        try {
            Connection connection = daoFactory.getConnection();
            PreparedStatement prs = connection.prepareStatement(query);
            prs.setString(1, email);
            prs.executeUpdate();
            //testing if delete operation done successfully
            Statement exist = connection.createStatement();
            ResultSet existResult = exist.executeQuery("SELECT EXISTS( SELECT * FROM donnateur WHERE email_donnateur='" + email + "' ) AS user_exist;");
            existResult.next();
            result = existResult.getBoolean("user_exist") ? false : true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateDonnateur(Donnateur donnateur) {
        String query = "UPDATE donnateur SET email_donnateur = ?, password_donnateur = ?, id_ville = ?, " +
                    "tele_donnateur = ?, id_groupeSang = ? WHERE id_donnateur=? ;";
        boolean result = false;
        try {
            Connection connection = daoFactory.getConnection();
            PreparedStatement prs = connection.prepareStatement(query);
            prs.setString(1, donnateur.getEmailDonnateur());
            prs.setString(2, donnateur.getPasswordDonnateur());
            prs.setInt(3, donnateur.getIdVilleDonnateur());
            prs.setString(4, donnateur.getTeleDonnateur());
            prs.setInt(5, donnateur.getIdGroupeSangDonnateur());
            prs.setInt(6, donnateur.getIdDonnateur());
            prs.executeUpdate();
            result = true;
        } catch (SQLException e) {
            return false;
        }
        return result;
    }
}
