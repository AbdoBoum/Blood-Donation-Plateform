package Models;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Demande implements Serializable {
    private int idDemande;
    private int idCentre;
    private Date dateDemande;
    private String descriptionDemande;
    private String pathImgDemande;
    private boolean isUrgent;
    private List<ConcerneDemande> sangGroups = new ArrayList<>();

    public int getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(int idDemande) {
        this.idDemande = idDemande;
    }

    public int getIdCentre() {
        return idCentre;
    }

    public void setIdCentre(int idCentre) {
        this.idCentre = idCentre;
    }

    public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }

    public String getDescriptionDemande() {
        return descriptionDemande;
    }

    public void setDescriptionDemande(String descriptionDemande) {
        this.descriptionDemande = descriptionDemande;
    }

    public String getPathImgDemande() {
        return pathImgDemande;
    }

    public void setPathImgDemande(String pathImgDemande) {
        this.pathImgDemande = pathImgDemande;
    }

    public boolean isUrgent() {
        return isUrgent;
    }

    public void setUrgent(boolean urgent) {
        isUrgent = urgent;
    }

    public void addGroupeSang(ConcerneDemande concerneDemande){
        this.sangGroups.add(concerneDemande);
    }

    public List<ConcerneDemande> getSangGroups() {
        return sangGroups;
    }
}
