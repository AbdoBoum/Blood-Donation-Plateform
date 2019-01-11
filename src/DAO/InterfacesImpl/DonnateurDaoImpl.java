package DAO.InterfacesImpl;

import DAO.DAOFactory;
import DAO.Interfaces.DonnateurDao;
import Helper.Utile;
import Models.Donnateur;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DonnateurDaoImpl implements DonnateurDao {
    private DAOFactory daoFactory ;

    public DonnateurDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public boolean addDonnateur(Donnateur donnateur) {
        boolean result = false;
        try {
            Connection connection = daoFactory.getConnection();
            Statement exist=connection.createStatement();
            ResultSet existResult =exist.executeQuery("SELECT EXISTS( SELECT * FROM donnateur WHERE email_donnateur='"+donnateur.getEmailDonnateur()+"' ) AS user_exist;");
            existResult.next();
            //checking if the user already exist before inserting him
            if(!existResult.getBoolean("user_exist")){

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Donnateur getDonnateur(String email, String password) {
        try {
            Connection connection = daoFactory.getConnection();
            Statement statement=connection.createStatement();
            ResultSet result =statement.executeQuery("SELECT * FROM donnateur WHERE email_donnateur='"+email+"' AND password_donnateur='"+ Utile.stringToSha256(password) +"';");
            if(result.next()){
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
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean removeDonnateur(String email) {
        return false;
    }

    @Override
    public boolean updateDonnateurGroupSang(int idGroupSang) {
        return false;
    }
}
