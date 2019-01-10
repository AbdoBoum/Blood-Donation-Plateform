package Models;

import java.io.Serializable;
import java.sql.Date;

public class Message implements Serializable {
    private int idEmetteur;
    private int idRecepteur;
    private Date dateMessage;
    private boolean isViewed;
    private String contenueMessage;

    public int getIdEmetteur() {
        return idEmetteur;
    }

    public int getIdRecepteur() {
        return idRecepteur;
    }

    public Date getDateMessage() {
        return dateMessage;
    }

    public boolean isViewed() {
        return isViewed;
    }

    public String getContenueMessage() {
        return contenueMessage;
    }

    public void setIdEmetteur(int idEmetteur) {
        this.idEmetteur = idEmetteur;
    }

    public void setIdRecepteur(int idRecepteur) {
        this.idRecepteur = idRecepteur;
    }

    public void setDateMessage(Date dateMessage) {
        this.dateMessage = dateMessage;
    }

    public void setViewed(boolean viewed) {
        isViewed = viewed;
    }

    public void setContenueMessage(String contenueMessage) {
        this.contenueMessage = contenueMessage;
    }
}
