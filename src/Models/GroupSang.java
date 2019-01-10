package Models;

import java.io.Serializable;

public class GroupSang implements Serializable {
    private int idGroupe;
    private String nameGroupe;

    public int getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(int idGroupe) {
        this.idGroupe = idGroupe;
    }

    public String getNameGroupe() {
        return nameGroupe;
    }

    public void setNameGroupe(String nameGroupe) {
        this.nameGroupe = nameGroupe;
    }
}
