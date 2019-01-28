package DAO.Interfaces;

import Models.Evenement;

import java.util.List;

public interface EvenementDao {
    Evenement getEvenementById(int idEvenement);

    boolean insertEvenement(Evenement evenement);
    boolean updateEvenement(Evenement evenement);
    Evenement getEvenementByTitle(String title);
    boolean deleteEvenement(int idEvenement);
    List<Evenement> getAllEvenement();
    int countEvents();
    List<Evenement> getEvenementByPagination(int start, int total);
    int countEventsPerCity(int idVille);
}
