package Models;

import java.io.Serializable;

public class Donnateur implements Serializable {
    private int idDonnateur;
    private String cinDonnateur;
    private String nomDonnateur;
    private String prenomDonnateur;
    private String emailDonnateur;
    private String passwordDonnateur;
    private String teleDonnateur;
    private int idVilleDonnateur;
    private int idGroupeSangDonnateur;

    public int getIdDonnateur() {
        return idDonnateur;
    }

    public void setIdDonnateur(int idDonnateur) {
        this.idDonnateur = idDonnateur;
    }

    public String getCinDonnateur() {
        return cinDonnateur;
    }

    public void setCinDonnateur(String cinDonnateur) {
        this.cinDonnateur = cinDonnateur;
    }

    public String getNomDonnateur() {
        return nomDonnateur;
    }

    public void setNomDonnateur(String nomDonnateur) {
        this.nomDonnateur = nomDonnateur;
    }

    public String getPrenomDonnateur() {
        return prenomDonnateur;
    }

    public void setPrenomDonnateur(String prenomDonnateur) {
        this.prenomDonnateur = prenomDonnateur;
    }

    public String getEmailDonnateur() {
        return emailDonnateur;
    }

    public void setEmailDonnateur(String emailDonnateur) {
        this.emailDonnateur = emailDonnateur;
    }

    public String getPasswordDonnateur() {
        return passwordDonnateur;
    }

    public void setPasswordDonnateur(String passwordDonnateur) {
        this.passwordDonnateur = passwordDonnateur;
    }

    public String getTeleDonnateur() {
        return teleDonnateur;
    }

    public void setTeleDonnateur(String teleDonnateur) {
        this.teleDonnateur = teleDonnateur;
    }

    public int getIdVilleDonnateur() {
        return idVilleDonnateur;
    }

    public void setIdVilleDonnateur(int idVilleDonnateur) {
        this.idVilleDonnateur = idVilleDonnateur;
    }

    public int getIdGroupeSangDonnateur() {
        return idGroupeSangDonnateur;
    }

    public void setIdGroupeSangDonnateur(int idGroupeSangDonnateur) {
        this.idGroupeSangDonnateur = idGroupeSangDonnateur;
    }
}
