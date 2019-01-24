package Controllers.Demandes;

import DAO.DAOFactory;
import DAO.Interfaces.DemandeDao;
import Helper.RequestPagination;
import Helper.Utile;
import Helper.pagination;
import Models.Blog;
import Models.Demande;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "RequestsServlet")
public class RequestsServlet extends HttpServlet {
    private DAOFactory daoFactory;
    private DemandeDao demandeDao;
    private int totalRequests;

    @Override
    public void init() throws ServletException {
        super.init();
        daoFactory = DAOFactory.getInstance();
        demandeDao = daoFactory.getDemandeDaoImpl();
        totalRequests = demandeDao.countRequests();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // for filtering requests

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int CurrentPage = (request.getParameter("page") != null) ? Integer.parseInt(request.getParameter("page")) : 1;
        List<Demande> demandes = demandeDao.getRequestsByPagination((CurrentPage - 1) * 5, 5);
        List<RequestPagination> requests = new ArrayList<>();
        for(Demande demande : demandes){
            requests.add(Utile.createRequestClass(demande));
        }
        request.setAttribute("requests", requests);
        pagination pg = new pagination(totalRequests, 5, 5, CurrentPage);
        request.setAttribute("pg", pg);
        this.getServletContext().getRequestDispatcher("/jsp/Requests.jsp").forward(request, response);
    }
}
