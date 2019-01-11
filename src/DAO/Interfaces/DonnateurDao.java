package DAO.Interfaces;

import Models.Donnateur;

public interface DonnateurDao {
    boolean addDonnateur(Donnateur donnateur);
    Donnateur getDonnateur(String email, String password);
    boolean removeDonnateur(String email);
    boolean updateDonnateurGroupSang(int idGroupSang);
}
