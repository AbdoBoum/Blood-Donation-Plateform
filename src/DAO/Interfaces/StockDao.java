package DAO.Interfaces;

import Models.Stock;

import java.sql.Timestamp;
import java.util.List;

public interface StockDao {
    // updates
    public boolean insertStock(Stock stock);
    public boolean updateStock(Stock stock);
    public boolean deleteStock(Stock stock);
    // selections
    public Stock getStockById(int idGroupSang, int idCentre);
    public List<Stock> getStockByIdGroupeSang(int idGroupeSang);
    public List<Stock> getStockByIdCentre(int idCentre);
    public List<Stock> getAllStock();

}
