package DAO.Interfaces;

import Models.Centre;

import java.util.List;

public interface CentreDao {
    public Centre getCentre(int idCentre);
    public Centre getCentre(String email, String password);
    public boolean insertCentre(Centre centre);
    public boolean updateCentre(Centre centre);
    public boolean deleteCentreByEmail(String email);
    public boolean searchCentreByEmail(String email);
    public boolean deleteCentre(int idCentre);
    public List<Centre> getAllCentre();

}
