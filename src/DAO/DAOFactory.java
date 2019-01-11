package DAO;

import DAO.Interfaces.AdminDao;
import DAO.Interfaces.CentreDao;
import DAO.Interfaces.DonnateurDao;
import DAO.Interfaces.GroupSangDao;
import DAO.InterfacesImpl.AdminDaoImpl;
import DAO.InterfacesImpl.CentreDaoImpl;
import DAO.InterfacesImpl.DonnateurDaoImpl;
import DAO.InterfacesImpl.GroupSangDaoImpl;
import Models.Admin;
import Models.Centre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class DAOFactory {
    private String url;
    private String username;
    private String password;

    public DAOFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static DAOFactory getInstance(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return new DAOFactory("jdbc:mysql://localhost:3306/blood_donation","root","");
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

    public CentreDao getCentreDaoImpl(){ return new CentreDaoImpl(this);    }

    public AdminDao getAdminDaoImpl(){ return new AdminDaoImpl(this);  }

    public GroupSangDao getGroupSangDaoImpl(){
        return new GroupSangDaoImpl(this);
    }

    public DonnateurDao getDonnateurDaoImpl(){
        return new DonnateurDaoImpl(this);
    }

//
//    public static void main(String[] args) {
//
//
//        DAOFactory daoFactory=DAOFactory.getInstance();
//        AdminDao adminDao=daoFactory.getAdminDaoImpl();



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
