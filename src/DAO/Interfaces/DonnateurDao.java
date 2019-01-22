package DAO.Interfaces;

import Models.Donnateur;

public interface DonnateurDao {
    boolean addDonnateur(Donnateur donnateur);
    Donnateur getDonnateur(String email, String password);
    Donnateur getDonnateur(int id);
    boolean removeDonnateur(String email);
    boolean updateDonnateurGroupSang(Donnateur donnateur);
}
