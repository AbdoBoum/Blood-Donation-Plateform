package Models;

import java.io.Serializable;

public class Centre implements Serializable {
    private int idCentre;
    private String emailCentre;
    private String passwordCentre;
    private String nameCentre;
    private String teleCentre;
    private String adresseCentre;
    private int idVille;
    private int idAdmin;

    public int getIdCentre() {
        return idCentre;
    }

    public void setIdCentre(int idCentre) {
        this.idCentre = idCentre;
    }

    public String getEmailCentre() {
        return emailCentre;
    }

    public void setEmailCentre(String emailCentre) {
        this.emailCentre = emailCentre;
    }

    public String getPasswordCentre() {
        return passwordCentre;
    }

    public void setPasswordCentre(String passwordCentre) {
        this.passwordCentre = passwordCentre;
    }

    public String getNameCentre() {
        return nameCentre;
    }

    public void setNameCentre(String nameCentre) {
        this.nameCentre = nameCentre;
    }

    public String getTeleCentre() {
        return teleCentre;
    }

    public void setTeleCentre(String teleCentre) {
        this.teleCentre = teleCentre;
    }

    public String getAdresseCentre() {
        return adresseCentre;
    }

    public void setAdresseCentre(String adresseCentre) {
        this.adresseCentre = adresseCentre;
    }

    public int getIdVille() {
        return idVille;
    }

    public void setIdVille(int idVille) {
        this.idVille = idVille;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }
}
