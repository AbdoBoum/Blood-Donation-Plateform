package Models;

import java.io.Serializable;

public class Notification implements Serializable {
    private int idDonnateur;
    private int idDemande;
    private String descriptionNotification;
    private boolean isViewed;

    public int getIdDonnateur() {
        return idDonnateur;
    }

    public int getIdDemande() {
        return idDemande;
    }

    public String getDescriptionNotification() {
        return descriptionNotification;
    }

    public boolean isViewed() {
        return isViewed;
    }

    public void setIdDonnateur(int idDonnateur) {
        this.idDonnateur = idDonnateur;
    }

    public void setIdDemande(int idDemande) {
        this.idDemande = idDemande;
    }

    public void setDescriptionNotification(String descriptionNotification) {
        this.descriptionNotification = descriptionNotification;
    }

    public void setViewed(boolean viewed) {
        isViewed = viewed;
    }
}
