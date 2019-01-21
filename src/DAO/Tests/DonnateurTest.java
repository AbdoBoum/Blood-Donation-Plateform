package DAO.Tests;

import DAO.DAOFactory;
import DAO.Interfaces.DonnateurDao;
import DAO.InterfacesImpl.BlogDaoImpl;
import Helper.Utile;
import Models.Blog;
import Models.Donnateur;

import java.util.Date;
import java.util.List;

public class DonnateurTest {
    public static void main(String[] args){
        DAOFactory daoFactory = DAOFactory.getInstance();
        DonnateurDao donnateurDao = daoFactory.getDonnateurDaoImpl();
        Donnateur donnateur = new Donnateur();
        donnateur.setTeleDonnateur("078898899");
        donnateur.setCinDonnateur("Z559024");
        donnateur.setIdGroupeSangDonnateur(1);
        donnateur.setIdVilleDonnateur(1);
        donnateur.setPrenomDonnateur("Anass");
        donnateur.setNomDonnateur("EL GHAOUI");
        donnateur.setEmailDonnateur("anas@gmail.com");
        donnateur.setPasswordDonnateur(Utile.stringToSha256("anas"));
        System.out.println("add donnateur : "+donnateurDao.addDonnateur(donnateur));
        System.out.println("get donnateur : "+donnateurDao.getDonnateur(donnateur.getEmailDonnateur(),donnateur.getPasswordDonnateur()).getCinDonnateur());
        donnateur.setIdGroupeSangDonnateur(5);
        System.out.println("update donnateur : "+donnateurDao.updateDonnateurGroupSang(donnateur));
       // System.out.println("remove donnateur : "+donnateurDao.removeDonnateur(donnateur.getEmailDonnateur()));

    }
}
