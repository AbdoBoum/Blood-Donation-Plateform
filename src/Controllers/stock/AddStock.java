package Controllers.stock;

import DAO.DAOFactory;
import DAO.Interfaces.GroupSangDao;
import DAO.Interfaces.StockDao;
import Models.Centre;
import Models.GroupSang;
import Models.Stock;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet(name = "AddStock")
public class AddStock extends HttpServlet {

    private DAOFactory daoFactory;
    private GroupSangDao groupSangDao;
    private StockDao stockDao;
    private Centre centre;

    HttpSession session;

    Stock stock;

    private String flashMessageFaild="";
    private String flashMessageSuccess="";

    private int idCentre;

    @Override
    public void init() throws ServletException {
        super.init();
        daoFactory = DAOFactory.getInstance();
        groupSangDao = daoFactory.getGroupSangDaoImpl();
        stockDao = daoFactory.getStockImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int quantity = !request.getParameter("quantity").isEmpty() ? Integer.parseInt(request.getParameter("quantity")) : 0;
        quantity = (quantity >= 0) ? quantity : 0;
        String[] groupSang = request.getParameterValues("groupSang");
        int idgroupSang;

        if (quantity == 0 ) {
            if (groupSang[0].isEmpty()) {
                flashMessageFaild = "Please complete all fields";
                request.setAttribute("flashMessageFaild", flashMessageFaild);
                this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }else {
                flashMessageFaild = "Quantity must be positive";
                request.setAttribute("flashMessageFaild" , flashMessageFaild);
                this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }
        } else {
            idgroupSang = Integer.parseInt(groupSang[0]);
            stock = stockDao.getStockById(idgroupSang, idCentre);
            if (stock == null){
                stock = new Stock();
                stock.setQuantiteStock(quantity);
                stock.setIdCentre(idCentre);
                stock.setIdGroupeSang(idgroupSang);
                stock.setDateStock(new Timestamp(System.currentTimeMillis()));
                if (stockDao.insertStock(stock)){
                    flashMessageSuccess = "Quantity added";
                    request.setAttribute("flashMessageSuccess", flashMessageSuccess);
                    this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                } else {
                    flashMessageFaild = "Something goes wrong.";
                    request.setAttribute("flashMessageFaild", flashMessageFaild);
                    this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                }
            } else {
                stock.setQuantiteStock(stock.getQuantiteStock() + quantity);
                if (stockDao.updateStock(stock)){
                    flashMessageSuccess = "Quantity added";
                    request.setAttribute("flashMessageSuccess", flashMessageSuccess);
                    this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                } else {
                    flashMessageFaild = "Something goes wrong.";
                    request.setAttribute("flashMessageFaild", flashMessageFaild);
                    this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                }
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        centre = (Centre) session.getAttribute("centre");
        idCentre = centre.getIdCentre();
        this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
