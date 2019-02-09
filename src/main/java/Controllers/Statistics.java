package Controllers;

import DAO.DAOFactory;
import DAO.Interfaces.*;
import Helper.StockStatistics;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Statistics")
public class Statistics extends HttpServlet {
    private DAOFactory daoFactory;
    private StockDao stockDao;
    private GroupSangDao groupSangDao;
    private BlogDao blogDao;
    private DonnateurDao donnateurDao;
    private DemandeDao demandeDao;
    private EvenementDao evenementDao;

    @Override
    public void init() throws ServletException {
        super.init();
        daoFactory = DAOFactory.getInstance();
        stockDao = daoFactory.getStockImpl();
        groupSangDao = daoFactory.getGroupSangDaoImpl();
        blogDao = daoFactory.getBlogDaoImpl();
        donnateurDao = daoFactory.getDonnateurDaoImpl();
        demandeDao = daoFactory.getDemandeDaoImpl();
        evenementDao = daoFactory.getEvenementImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Centre centre = (Centre) session.getAttribute("centre");
        List<StockStatistics> stockList = new ArrayList<>();
        List<GroupSang> groupSangList = groupSangDao.getAllGroups();
        int totalRequests = -1;
        int totalDonors = -1;
        int totalEvents = -1;
        if(centre != null ){
            List<Stock> stocks = stockDao.getStockByIdCentre(centre.getIdCentre());
            for(GroupSang groupSang : groupSangList){
                double quantity = 0;
                for(Stock stock : stocks){
                    if(stock.getIdGroupeSang() == groupSang.getIdGroupe())
                        quantity = stock.getQuantiteStock() * 0.5;
                }
                stockList.add(new StockStatistics(groupSang.getNameGroupe(),quantity));
            }
            totalDonors = donnateurDao.CountDonorsPerCity(centre.getIdVille());
            totalRequests = demandeDao.countRequestsPerCenter(centre.getIdCentre());
            totalEvents = evenementDao.countEventsPerCity(centre.getIdVille());
        }
        int totalBlogs = blogDao.CountBlogs();

        request.setAttribute("totalBlogs",totalBlogs);
        request.setAttribute("totalRequests",totalRequests);
        request.setAttribute("totalEvents",totalEvents);
        request.setAttribute("totalDonors",totalDonors);
        request.setAttribute("stockList",stockList);
        this.getServletContext().getRequestDispatcher("/jsp/statistics.jsp").forward(request,response);
    }
}
