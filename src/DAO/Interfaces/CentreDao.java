package DAO.Interfaces;

import Models.Centre;

import java.util.List;

public interface CentreDao {
    public Centre getCentre(int idCentre);
    public void insertCentre(Centre centre);
    public void updateCentre(Centre centre);
    public void deleteCentre(int idCentre);
    public List<Centre> getAllCentre();

}