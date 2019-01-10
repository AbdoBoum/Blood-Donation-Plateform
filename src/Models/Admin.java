package Models;

public class Admin {
    private int idAdmin;
    private String nomAdmin;
    private String prenomAdmin;
    private String emailAdmin;
    private String passwordAdmin;

    public int getIdAdmin() {
        return idAdmin;
    }

    public String getNomAdmin() {
        return nomAdmin;
    }

    public String getPrenomAdmin() {
        return prenomAdmin;
    }

    public String getEmailAdmin() {
        return emailAdmin;
    }

    public String getPasswordAdmin() {
        return passwordAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public void setNomAdmin(String nomAdmin) {
        this.nomAdmin = nomAdmin;
    }

    public void setPrenomAdmin(String prenomAdmin) {
        this.prenomAdmin = prenomAdmin;
    }

    public void setEmailAdmin(String emailAdmin) {
        this.emailAdmin = emailAdmin;
    }

    public void setPasswordAdmin(String passwordAdmin) {
        this.passwordAdmin = passwordAdmin;
    }
}
