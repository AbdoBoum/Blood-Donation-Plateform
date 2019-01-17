package DAO;

import DAO.Interfaces.*;
import DAO.InterfacesImpl.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

    public StockDao getStockImpl(){ return new StockDaoImpl(this); }

    public EvenementDao getEvenementImpl(){ return new EvenementDaoImpl(this);   }

    public CentreDao getCentreDaoImpl(){ return new CentreDaoImpl(this);    }

    public AdminDao getAdminDaoImpl(){ return new AdminDaoImpl(this);  }

    public GroupSangDao getGroupSangDaoImpl(){
        return new GroupSangDaoImpl(this);
    }

    public DonnateurDao getDonnateurDaoImpl(){
        return new DonnateurDaoImpl(this);
    }

    public BlogDao getBlogDaoImpl(){
        return new BlogDaoImpl(this);
    }

    public NotificationDao getNotificationDaoImpl(){
        return new NotificationDaoImpl(this);
    }

    public VilleDao getVilleDaoImpl(){
        return new VilleDaoImpl(this);
    }
}
