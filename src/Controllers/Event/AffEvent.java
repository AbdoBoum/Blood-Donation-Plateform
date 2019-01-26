package Controllers.Event;

import DAO.DAOFactory;
import DAO.Interfaces.CentreDao;
import DAO.Interfaces.EvenementDao;
import DAO.Interfaces.VilleDao;
import Helper.pagination;
import Models.Centre;
import Models.Evenement;
import Models.Ville;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AffEvent")
public class AffEvent extends HttpServlet {
    private DAOFactory daoFactory;
    private EvenementDao evenementDao;
    private VilleDao villeDao;
    private CentreDao centreDao;
    @Override
    public void init() throws ServletException{
        super.init();
        daoFactory=DAOFactory.getInstance();
        evenementDao=daoFactory.getEvenementImpl();
        villeDao=daoFactory.getVilleDaoImpl();
        centreDao=daoFactory.getCentreDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.sendRedirect("/");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int currentPage = (request.getParameter("page") != null) ? Integer.parseInt(request.getParameter("page")) : 1;

        List<Evenement> events=evenementDao.getEvenementByPagination((currentPage - 1)*6,6);
        List<Evenement> allEvents=evenementDao.getAllEvenement();
        List<Ville> villes=villeDao.getAllVille();
        List<Centre> centres=centreDao.getAllCentre();
        int nbrEvents=evenementDao.countEvents();
        if(nbrEvents==0){
            this.getServletContext().getRequestDispatcher("/jsp/AffEvent.jsp").forward(request,response);
        }else{

            request.setAttribute("villes",villes);
            request.setAttribute("events", events);
            request.setAttribute("centres", centres);
            pagination pn=new pagination(allEvents.size(),6,5,currentPage);
            String pag=pn.showPagination("/agenda");
            request.setAttribute("pg",pag);
            this.getServletContext().getRequestDispatcher("/jsp/AffEvent.jsp").forward(request,response);
        }
    }
}
