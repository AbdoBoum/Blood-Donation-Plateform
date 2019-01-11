package DAO.Interfaces;

import Models.Admin;

import java.util.List;

public interface AdminDao {
    public void insertAdmin(Admin admin);
    public void updateAdmin(Admin admin);
    public Admin getAdmin(int idAdmin);
    public void deleteAdmin(int idAdmin);
    public List<Admin> getAllAdmins();
}
