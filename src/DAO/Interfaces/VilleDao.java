package DAO.Interfaces;

import Models.Ville;

import java.util.List;

public interface VilleDao {

    /* insert city*/
    public Ville insertVille(Ville ville);

    /* fetch city by name*/
    public List<Ville> getVilleByName(String NomVille);

    /* fetch city by id*/
    public Ville getVilleById(int idVille);

    /* get all cities*/
    public List<Ville> getAllVille();

    /* delete city*/
    public void deleteVille(int id_ville);

    /* update city*/
    public Ville updateVille(Ville ville);
}
