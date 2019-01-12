package DAO.Interfaces;

import Models.Stock;

import java.sql.Timestamp;
import java.util.List;

public interface StockDao {
    // updates
    public void insertStock(Stock stock);
    public void updateStock(Stock stock);
    public void deleteStock(Stock stock);
    // selections
    public Stock getStockById(int idGroupSang, int idCentre, Timestamp date);
    public List<Stock> getStockByIdGroupeSang(int idGroupeSang);
    public List<Stock> getStockByIdCentre(int idCentre);
    public List<Stock> getAllStock();

}
