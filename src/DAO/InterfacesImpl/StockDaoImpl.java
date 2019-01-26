package DAO.InterfacesImpl;

import DAO.DAOFactory;
import DAO.Interfaces.StockDao;
import Models.Stock;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.SocketHandler;

public class StockDaoImpl implements StockDao {
    DAOFactory daoFactory;

    public StockDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public boolean insertStock(Stock stock) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            connection=daoFactory.getConnection();
            preparedStatement=connection.prepareStatement("insert into stock(id_groupeSang, id_centre, date_stock, quantite_stock) VALUES(?,?,?,?) ");
            preparedStatement.setInt(1,stock.getIdGroupeSang());
            preparedStatement.setInt(2,stock.getIdCentre());
            preparedStatement.setTimestamp(3,stock.getDateStock());
            preparedStatement.setInt(4,stock.getQuantiteStock());

            preparedStatement.executeUpdate();
            return true;

        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateStock(Stock stock) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            connection=daoFactory.getConnection();
            preparedStatement=connection.prepareStatement("UPDATE stock set quantite_stock=? WHERE id_groupeSang=? and id_centre=? and date_stock=?");
            preparedStatement.setInt(1,stock.getQuantiteStock());
            preparedStatement.setInt(2,stock.getIdGroupeSang());
            preparedStatement.setInt(3,stock.getIdCentre());
            preparedStatement.setTimestamp(4,stock.getDateStock());

            preparedStatement.executeUpdate();
            return true;

        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteStock(Stock stock) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            connection=daoFactory.getConnection();
            preparedStatement=connection.prepareStatement("delete from stock WHERE id_groupeSang=? and id_centre=? and date_stock=?");
            preparedStatement.setInt(1,stock.getIdGroupeSang());
            preparedStatement.setInt(2,stock.getIdCentre());
            preparedStatement.setTimestamp(3,stock.getDateStock());

            preparedStatement.executeUpdate();

            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Stock getStockById(int idGroupeSang, int idCentre) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        Stock stock=null;
        try{
            connection=daoFactory.getConnection();
            preparedStatement=connection.prepareStatement("select * from stock WHERE id_groupeSang=? and id_centre=?");
            preparedStatement.setInt(1,idGroupeSang);
            preparedStatement.setInt(2,idCentre);

            ResultSet rs=preparedStatement.executeQuery();
            if(rs.next()){
                stock=new Stock();
                stock.setDateStock(rs.getTimestamp("date_stock"));
                stock.setIdCentre(rs.getInt("id_centre"));
                stock.setIdGroupeSang(rs.getInt("id_groupeSang"));
                stock.setQuantiteStock(rs.getInt("quantite_stock"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return stock;
    }

    @Override
    public List<Stock> getStockByIdGroupeSang(int idGroupeSang) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        List<Stock> stocks=null;
        try{
            connection=daoFactory.getConnection();
            preparedStatement=connection.prepareStatement("select * from stock WHERE id_groupeSang=? ");
            preparedStatement.setInt(1,idGroupeSang);

            ResultSet rs=preparedStatement.executeQuery();
            stocks=new ArrayList<>();
            while (rs.next()){
                Stock stock=new Stock();
                stock.setDateStock(rs.getTimestamp("date_stock"));
                stock.setIdCentre(rs.getInt("id_centre"));
                stock.setIdGroupeSang(rs.getInt("id_groupeSang"));
                stock.setQuantiteStock(rs.getInt("quantite_stock"));
                stocks.add(stock);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return stocks;
    }

    @Override
    public List<Stock> getStockByIdCentre(int idCentre) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        List<Stock> stocks=null;
        try{
            connection=daoFactory.getConnection();
            preparedStatement=connection.prepareStatement("select * from stock WHERE id_centre=? ");
            preparedStatement.setInt(1,idCentre);

            ResultSet rs=preparedStatement.executeQuery();
            stocks=new ArrayList<>();
            while (rs.next()){
                Stock stock=new Stock();
                stock.setIdGroupeSang(rs.getInt("id_groupeSang"));
                stock.setIdCentre(rs.getInt("id_centre"));
                stock.setDateStock(rs.getTimestamp("date_stock"));
                stock.setQuantiteStock(rs.getInt("quantite_stock"));
                stocks.add(stock);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return stocks;
    }

    @Override
    public List<Stock> getAllStock() {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        List<Stock> stocks=null;
        try{
            connection=daoFactory.getConnection();
            preparedStatement=connection.prepareStatement("select * from stock ");
            ResultSet rs=preparedStatement.executeQuery();
            stocks=new ArrayList<>();

            while (rs.next()){
                Stock stock=new Stock();
                stock.setIdCentre(rs.getInt("id_centre"));
                stock.setIdGroupeSang(rs.getInt("id_groupeSang"));
                stock.setDateStock(rs.getTimestamp("date_stock"));
                stock.setQuantiteStock(rs.getInt("quantite_stock"));
                stocks.add(stock);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return stocks;
    }
}
