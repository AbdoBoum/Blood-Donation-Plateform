package Models;

import java.io.Serializable;

public class Ville implements Serializable {
    private int idVille;
    private String nomVille;

    public Ville(int idVille, String nomVille) {
        this.idVille = idVille;
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
}
