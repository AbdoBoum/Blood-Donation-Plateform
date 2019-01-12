package DAO.Interfaces;

import Models.ConcerneDemande;
import java.util.List;

public interface ConcerneDemandeDao {

    /* insert ConcerneDemande*/
    public ConcerneDemande insertConcerneDemande(ConcerneDemande concerneDemande);

    /* fetch ConcerneDemande by id*/
    public ConcerneDemande getConcerneDemande(int idDemande, int idGroupeSang);

    /* get all ConcerneDemande: will return all cities*/
    public List<ConcerneDemande> getAllConcerneDemande();

    /* delete ConcerneDemande */
    public boolean deleteConcerneDemande(int idDemande, int idGroupeSang);

}
