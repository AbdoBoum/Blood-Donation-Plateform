package Models;

import java.io.Serializable;

public class Ville implements Serializable {
    private int idVille;
    private String nomVille;

    public Ville(){
        super();
    }

    public Ville( String nomVille) {
        this.nomVille = nomVille;
    }

    public int getIdVille() {
        return idVille;
    }

    public void setIdVille(int idVille) {
        this.idVille = idVille;
    }

    public String getNomVille() {
        return nomVille;
    }

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    @Override
    public String toString() {
        return "Ville{" +
                "idVille=" + idVille +
                ", nomVille='" + nomVille + '\'' +
                '}';
    }
}
