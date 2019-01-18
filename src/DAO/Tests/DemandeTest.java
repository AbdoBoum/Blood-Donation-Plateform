package DAO.Tests;

import DAO.DAOFactory;
import DAO.Interfaces.DemandeDao;
import DAO.Interfaces.DonnateurDao;
import DAO.InterfacesImpl.BlogDaoImpl;
import Helper.Utile;
import Models.Blog;
import Models.ConcerneDemande;
import Models.Demande;
import Models.Donnateur;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class DemandeTest {
    public static void main(String[] args){
        DAOFactory daoFactory = DAOFactory.getInstance();
        DemandeDao demandeDao = daoFactory.getDemandeDaoImpl();
        Demande demande = new Demande();
        demande.setActive(true);
        demande.setDateDemande(new Timestamp(System.currentTimeMillis()));
        demande.setDescriptionDemande("first demande test");
        demande.setPathImgDemande("path//test");
        demande.setUrgent(false);
        demande.setIdCentre(1);
        ConcerneDemande concerneDemande = new ConcerneDemande();
        concerneDemande.setIdGroupeSang(1);
        demande.addGroupeSang(concerneDemande);
        System.err.println(demandeDao.addDemande(demande));


    }
}
