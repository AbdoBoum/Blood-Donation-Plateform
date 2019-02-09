package Helper;

public class StockStatistics {
    private String nameGrp;
    private double quantity;

    public StockStatistics(String nameGrp, double quantity) {
        this.nameGrp = nameGrp;
        this.quantity = quantity;
    }

    public String getNameGrp() {
        return nameGrp;
    }

    public void setNameGrp(String nameGrp) {
        this.nameGrp = nameGrp;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
