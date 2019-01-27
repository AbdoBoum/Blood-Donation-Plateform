package DAO.InterfacesImpl;

import DAO.DAOFactory;
import DAO.Interfaces.AdminDao;
import Models.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl implements AdminDao {
    private DAOFactory daoFactory;

    public AdminDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void insertAdmin(Admin admin) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            connection=daoFactory.getConnection();
            preparedStatement=connection.prepareStatement("INSERT into admin(nom_admin,prenom_admin,email_admin,password_admin) values (?,?,?,?)");
            preparedStatement.setString(1,admin.getNomAdmin());
            preparedStatement.setString(2,admin.getPrenomAdmin());
            preparedStatement.setString(3,admin.getEmailAdmin());
            preparedStatement.setString(4,admin.getPasswordAdmin());
            preparedStatement.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateAdmin(Admin admin) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            connection=daoFactory.getConnection();
            preparedStatement=connection.prepareStatement("update admin set nom_admin=?,prenom_admin=?,email_admin=?,password_admin=? where id_admin=?");
            preparedStatement.setString(1,admin.getNomAdmin());
            preparedStatement.setString(2,admin.getPrenomAdmin());
            preparedStatement.setString(3,admin.getEmailAdmin());
            preparedStatement.setString(4,admin.getPasswordAdmin());
            preparedStatement.setInt(5,admin.getIdAdmin());
            preparedStatement.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }


    @Override
    public Admin getAdmin(String email, String password) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        Admin admin=null;
        try{
            connection=this.daoFactory.getConnection();
            preparedStatement=connection.prepareStatement("select * from admin where email_admin = ? and password_admin = ?");
            preparedStatement.setString(1,email);
            preparedStatement.setString(2, password);
            ResultSet rs=preparedStatement.executeQuery();
            if(rs.next()){
                admin=new Admin();
                admin.setIdAdmin(rs.getInt("id_admin"));
                admin.setNomAdmin(rs.getString("nom_admin"));
                admin.setPrenomAdmin(rs.getString("prenom_admin"));
                admin.setEmailAdmin(rs.getString("email_admin"));
                admin.setPasswordAdmin(rs.getString("password_admin"));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return admin;
    }

    @Override
    public void deleteAdmin(int idAdmin) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            connection=this.daoFactory.getConnection();
            preparedStatement=connection.prepareStatement("delete from admin where id_admin=?");
            preparedStatement.setInt(1,idAdmin);
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Admin> getAllAdmins() {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        List<Admin> admins=null;
        try{
            connection=this.daoFactory.getConnection();
            preparedStatement=connection.prepareStatement("select * from admin");
            ResultSet rs=preparedStatement.executeQuery();
            admins=new ArrayList<>();
            while (rs.next()){
                Admin admin=new Admin();
                admin.setIdAdmin(rs.getInt("id_admin"));
                admin.setNomAdmin(rs.getString("nom_admin"));
                admin.setPrenomAdmin(rs.getString("prenom_admin"));
                admin.setEmailAdmin(rs.getString("email_admin"));
                admin.setPasswordAdmin(rs.getNString("password_admin"));
                admins.add(admin);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return admins;
    }
}
