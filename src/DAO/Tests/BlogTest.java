package DAO.Tests;

import DAO.DAOFactory;
import DAO.Interfaces.EvenementDao;
import DAO.InterfacesImpl.BlogDaoImpl;
import Models.Blog;
import Models.Evenement;

import java.util.Date;
import java.util.List;

public class BlogTest {
    public static void main(String[] args){
//        BlogDaoImpl dao = new BlogDaoImpl(DAOFactory.getInstance());
//        Blog b1 = dao.insertBlog(new Blog("Slider", "Slider is a noob man", "https", 5, new java.sql.Timestamp(new Date().getTime())));
//        Blog b2 = dao.insertBlog(new Blog("Bodle", "Bodle is a riche man", "httpds", 5, new java.sql.Timestamp(new Date().getTime())));
//        Blog b3 = dao.insertBlog(new Blog("xx", "Bodle is a riche man", "httpds", 5, new java.sql.Timestamp(new Date().getTime())));
//        b1.setPathImgBlog("zhwani");
//        dao.updateBlog(b1);
//        List<Blog> blogs = dao.FetchBlogByTitle("l");
//        for(Blog b: blogs){
//            System.out.println(b.toString());
//        }

//
//        DAOFactory daoFactory=DAOFactory.getInstance();
//        EvenementDao eventDao =daoFactory.getEvenementImpl();
//
//        Evenement evenement = eventDao.getEvenementById(1);
//        evenement.setTitreEvenement("abralsakjdf");
//        System.out.println(evenement.getIdEvenement()+" "+evenement.getTitreEvenement()+" "+evenement.getDateEvenement());
//        eventDao.updateEvenement(evenement);
//
//        Evenement ert = eventDao.getEvenementById(1);
//        System.out.println(ert.getTitreEvenement()+" "+ert.getDateEvenement());
//        eventDao.insertEvenement(evenement);


//
//        Evenement event=eventDao.getEvenementByTitle("hello world");
//
//        System.out.println(event.getTitreEvenement()+" "+event.getDateEvenement());
//
//        List<Evenement> evs=eventDao.getAllEvenement();
//
//        for (Evenement ev: evs
//             ) {
//            System.out.println(ev.getTitreEvenement()+" "+ev.getDateEvenement());
//        }

//        Admin admin=adminDao.getAdmin(1);
//        System.out.println(admin.getIdAdmin()+" "+admin.getNomAdmin()+" "+admin.getPrenomAdmin());
//        admin.setPrenomAdmin("prenomToto");
//        adminDao.updateAdmin(admin);
//        admin=adminDao.getAdmin(1);
//        System.out.println(admin.getIdAdmin()+" "+admin.getNomAdmin()+" "+admin.getPrenomAdmin());
//
//        admin.setPrenomAdmin("asdf");
//        admin.setNomAdmin("test test");
//        adminDao.setAdmin(admin);

//        List<Admin> admins=adminDao.getAllAdmins();
//
//        for (Admin admino:admins) {
//            System.out.println(admino.getIdAdmin()+" "+admino.getNomAdmin()+" "+admino.getPrenomAdmin());
//        }


//        CentreDao centreDao =daoFactory.getCentreDaoImp();
//        Centre centre=new Centre();
//        centre.setNameCentre("testNameCentre");
//        centre.setIdVille(1);
//        centre.setTeleCentre("006060606");
//        centre.setEmailCentre("gmail@gmail.com");
//        centre.setIdAdmin(1);
//        centre.setPasswordCentre("password");
//        centreDao.setCentre(centre);
//        Centre cent=centreDao.getCentre(1);
//        cent.setNameCentre("helloWorld");
//        centreDao.updateCentre(cent);
//        System.out.println(cent.getIdCentre()+" "+cent.getIdAdmin()+" "+cent.getNameCentre());
//        List<Centre> centres=centreDao.getAllCentre();
//        for (Centre cnt: centres) {
//            System.out.println(cnt.getIdCentre()+" "+cnt.getIdAdmin()+" "+cnt.getNameCentre());
//        }

    }

}
