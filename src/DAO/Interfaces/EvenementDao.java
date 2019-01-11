package DAO.Interfaces;

import Models.Evenement;

import java.util.List;

public interface EvenementDao {
    public Evenement getEvenementById(int idEvenement);
    public void setEvenement(Evenement evenement);
    public void updateEvenement(Evenement evenement);
    public Evenement getEvenementByTitle(String title);
    public void deleteEvenement(int idEvenement);
    public List<Evenement> getAllEvenement();
}
