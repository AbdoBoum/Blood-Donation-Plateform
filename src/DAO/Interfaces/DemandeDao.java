package DAO.Interfaces;

import Models.ConcerneDemande;
import Models.Demande;

import java.sql.Date;
import java.util.List;

public interface DemandeDao {
    boolean addDemande(Demande demande);

    List<Demande> getAllDemands();

    List<Demande> getDemandsFiltred(boolean etatDemande, boolean isUrgent, int idGroupSang, Date date, String idVille);

    List<Demande> getAllDemandsOfCenter(int idCentre);

    boolean editDemande(boolean etatDemande);

    boolean deleteDemande(int idDemande);

    List<ConcerneDemande> getAllGroupesConcerned(int idDemande);

    boolean setAllGroupsConcerned(Demande demande);
}
