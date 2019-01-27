package Controllers.Demandes;

import DAO.DAOFactory;
import DAO.Interfaces.DemandeDao;
import Models.Centre;
import Models.Demande;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CloseRequest")
public class CloseRequest extends HttpServlet {
    private DAOFactory daoFactory;
    private DemandeDao demandeDao;

    @Override
    public void init() throws ServletException {
        super.init();
        daoFactory = DAOFactory.getInstance();
        demandeDao = daoFactory.getDemandeDaoImpl();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idRequest = (request.getParameter("id") != null) ? Integer.parseInt(request.getParameter("id")) : -1;
        if(idRequest != -1){
            Demande demande = demandeDao.getRequestById(idRequest);
            if(demande != null){
                HttpSession session = request.getSession();
                Centre centre = (Centre)session.getAttribute("centre");
                if(centre != null && centre.getIdCentre() == demande.getIdCentre()){
                    demandeDao.closeDemande(idRequest);
                }
            }
        }
        response.sendRedirect("requests");
    }
}
