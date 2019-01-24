package DAO.Interfaces;

import Models.Donnateur;

import java.util.List;

public interface DonnateurDao {
    boolean addDonnateur(Donnateur donnateur);

    Donnateur getDonnateur(String email, String password);
    Donnateur getDonnateur(int id);
    boolean findDonnateurByMail(String mail);
    boolean removeDonnateur(String email);
    List<Donnateur> getAllDonnateurs();
    List<Donnateur> getDonnateursByCity(int idVille);

    boolean updateDonnateur(Donnateur donnateur);
}
