package Controllers.Event;

import DAO.DAOFactory;
import DAO.Interfaces.EvenementDao;
import Models.Evenement;

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
    @Override
    public void init() throws ServletException{
        super.init();
        daoFactory=DAOFactory.getInstance();
        evenementDao=daoFactory.getEvenementImpl();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Evenement> Events=evenementDao.getAllEvenement();
        request.setAttribute("events", Events);
        this.getServletContext().getRequestDispatcher("/jsp/AffEvent.jsp").forward(request,response);
    }
}
