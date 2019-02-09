package DAO.Interfaces;

import Models.ConcerneDemande;
import Models.Demande;

import java.util.List;

public interface ConcerneDemandeDao {

    boolean setAllGroupsConcerned(Demande demande);

    List<ConcerneDemande> getAllGroupesConcerned(int idDemande );

    /* delete ConcerneDemande */
    public boolean deleteConcerneDemande(int idDemande, int idGroupeSang);

}
