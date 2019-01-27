package DAO.Interfaces;

import Models.Admin;

import java.util.List;

public interface AdminDao {
    public void insertAdmin(Admin admin);
    public void updateAdmin(Admin admin);
    public Admin getAdmin(String email, String password);
    public void deleteAdmin(int idAdmin);
    public List<Admin> getAllAdmins();
}
