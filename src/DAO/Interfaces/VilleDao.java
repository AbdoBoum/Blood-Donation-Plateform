package DAO.Interfaces;

import Models.Ville;

import java.util.List;

public interface VilleDao {

    /* insert city*/
    public Ville insertVille(Ville ville);

    /* fetch city by name: we will use Like operator %NomVille% may return multiple cities*/
    public List<Ville> getVilleByName(String NomVille);

    /* fetch city by id: will return a unique city*/
    public Ville getVilleById(int idVille);

    /* get all cities: will return all cities*/
    public List<Ville> getAllVille();

    /* delete city*/
    public void deleteVille(int idVille);

}
