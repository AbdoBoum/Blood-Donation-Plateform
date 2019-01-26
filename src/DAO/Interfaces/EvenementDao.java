package DAO.Interfaces;

import Models.Evenement;

import java.util.List;

public interface EvenementDao {
    public Evenement getEvenementById(int idEvenement);

    public boolean insertEvenement(Evenement evenement);
    public boolean updateEvenement(Evenement evenement);
    public Evenement getEvenementByTitle(String title);
    public boolean deleteEvenement(int idEvenement);
    public List<Evenement> getAllEvenement();
    public List<Evenement> getEvenementByPagination(int start, int total);
}
