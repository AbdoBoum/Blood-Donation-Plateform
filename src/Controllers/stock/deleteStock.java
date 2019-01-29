package Controllers.stock;

import DAO.DAOFactory;
import DAO.Interfaces.GroupSangDao;
import DAO.Interfaces.StockDao;
import Models.Centre;
import Models.Stock;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet(name = "DeleteStock")
public class deleteStock extends HttpServlet {

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
        int idgroupSang;
        session = request.getSession();
        centre = (Centre) session.getAttribute("centre");
        idCentre = centre.getIdCentre();
        String[] groupSang = request.getParameterValues("groupSang");


        if (quantity == 0 ) {
            if (groupSang[0].isEmpty()) {
                flashMessageFaild = "Please complete all fields.";
                request.setAttribute("flashMessageFaild", flashMessageFaild);
                this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }else {
                flashMessageFaild = "Quantity to delete must be positive";
                request.setAttribute("flashMessageFaild" , flashMessageFaild);
                this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }
        } else {
            idgroupSang = Integer.parseInt(groupSang[0]);
            stock = stockDao.getStockById(idgroupSang, idCentre);
            if (stock == null){
                    flashMessageFaild = "Blood Type not available.";
                    request.setAttribute("flashMessageFaild", flashMessageFaild);
                    this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            } else {
                if (stock.getQuantiteStock() >= quantity) {
                    stock.setQuantiteStock(stock.getQuantiteStock() - quantity);
                    if (stockDao.updateStock(stock)) {
                        flashMessageSuccess = "Quantity deleted";
                        request.setAttribute("flashMessageSuccess", flashMessageSuccess);
                        this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                    } else {
                        flashMessageFaild = "Something goes wrong.";
                        request.setAttribute("flashMessageFaild", flashMessageFaild);
                        this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                    }
                }else {
                    flashMessageFaild = "Quantity to deleted is greater than quantity available.";
                    request.setAttribute("flashMessageFaild", flashMessageFaild);
                    this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                }
            }

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.sendRedirect("/");
    }
}
