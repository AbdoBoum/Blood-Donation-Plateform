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

    boolean editDemande(Demande demande);

    boolean deleteDemande(int idDemande);

    boolean closeDemande(int idDemande);

    List<Demande> getRequestsByPagination(int start , int total , int villeFilter, int groupeFilter);

    int countRequests(int villeFilter, int groupeFilter);

    int countRequestsPerCenter(int idCentre);

    Demande getRequestById(int id);

}
