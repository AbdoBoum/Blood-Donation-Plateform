package Models;

import java.io.Serializable;
import java.sql.Timestamp;

public class Stock implements Serializable {

    private int idGroupeSang;
    private int idCentre;
    private int quantiteStock;

    public int getIdGroupeSang() {
        return idGroupeSang;
    }

    public Stock() {
        super();
    }

    public Stock(int idGroupeSang, int idCentre, int quantiteStock) {
        this.idGroupeSang = idGroupeSang;
        this.idCentre = idCentre;
        this.quantiteStock = quantiteStock;
    }

    public int getIdCentre() {
        return idCentre;
    }

    public int getQuantiteStock() {
        return quantiteStock;
    }

    public void setIdGroupeSang(int idGroupeSang) {
        this.idGroupeSang = idGroupeSang;
    }

    public void setIdCentre(int idCentre) {
        this.idCentre = idCentre;
    }

    public void setQuantiteStock(int quantiteStock) {
        this.quantiteStock = quantiteStock;
    }
}