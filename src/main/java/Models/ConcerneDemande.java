package Models;

import java.io.Serializable;

public class ConcerneDemande implements Serializable {
    private int idDemande;
    private int idGroupeSang;

    public ConcerneDemande(){
        super();
    }

    public ConcerneDemande(int idDemande, int idGroupeSang) {
        this.idDemande = idDemande;
        this.idGroupeSang = idGroupeSang;
    }

    public int getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(int idDemande) {
        this.idDemande = idDemande;
    }

    public int getIdGroupeSang() {
        return idGroupeSang;
    }

    public void setIdGroupeSang(int idGroupeSang) {
        this.idGroupeSang = idGroupeSang;
    }

    @Override
    public String toString() {
        return "ConcerneDemande{" +
                "idDemande=" + idDemande +
                ", idGroupeSang=" + idGroupeSang +
                '}';
    }
}
