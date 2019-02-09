package Models;

import java.io.Serializable;
import java.sql.Timestamp;

public class Evenement implements Serializable {
    private int idEvenement;
    private String titreEvenement;
    private String desciptionEvenement;
    private Timestamp dateEvenement;
    private String imagePathEvenement;
    private int idVille;
    private int idCentre;

    public int getIdEvenement() {
        return idEvenement;
    }

    public String getTitreEvenement() {
        return titreEvenement;
    }

    public String getDesciptionEvenement() {
        return desciptionEvenement;
    }

    public Timestamp getDateEvenement() {
        return dateEvenement;
    }

    public String getImagePathEvenement() {
        return imagePathEvenement;
    }

    public int getIdVille() {
        return idVille;
    }

    public int getIdCentre() {
        return idCentre;
    }

    public void setIdEvenement(int idEvenement) {
        this.idEvenement = idEvenement;
    }

    public void setTitreEvenement(String titreEvenement) {
        this.titreEvenement = titreEvenement;
    }

    public void setDesciptionEvenement(String desciptionEvenement) {
        this.desciptionEvenement = desciptionEvenement;
    }

    public void setDateEvenement(Timestamp dateEvenement) {
        this.dateEvenement = dateEvenement;
    }

    public void setImagePathEvenement(String imagePathEvenement) {
        this.imagePathEvenement = imagePathEvenement;
    }

    public void setIdVille(int idVille) {
        this.idVille = idVille;
    }

    public void setIdCentre(int idCentre) {
        this.idCentre = idCentre;
    }
}
