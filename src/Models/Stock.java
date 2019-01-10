package Models;

import java.io.Serializable;
import java.sql.Date;

public class Stock implements Serializable {

    private int idGroupeSang;
    private int idCentre;
    private Date dateStock;
    private int quantiteStock;

    public int getIdGroupeSang() {
        return idGroupeSang;
    }

    public int getIdCentre() {
        return idCentre;
    }

    public Date getDateStock() {
        return dateStock;
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

    public void setDateStock(Date dateStock) {
        this.dateStock = dateStock;
    }

    public void setQuantiteStock(int quantiteStock) {
        this.quantiteStock = quantiteStock;
    }
}