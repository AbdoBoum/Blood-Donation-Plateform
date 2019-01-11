package DAO.Tests;

import DAO.DAOFactory;
import DAO.InterfacesImpl.BlogDaoImpl;
import DAO.InterfacesImpl.VilleDaoImpl;
import Models.Blog;
import Models.Ville;

import java.util.Date;
import java.util.List;

public class BlogTest {
    public static void main(String[] args){
        VilleDaoImpl dao = new VilleDaoImpl(DAOFactory.getInstance());
        dao.deleteVille(1);
        List<Ville> villes = dao.getAllVille();
        for (Ville v: villes){
            System.out.println(v.toString());
        }
    }
}
