package Controllers.Demandes;

import DAO.DAOFactory;
import DAO.Interfaces.DemandeDao;
import DAO.Interfaces.GroupSangDao;
import DAO.Interfaces.VilleDao;
import Helper.RequestPagination;
import Helper.Utile;
import Helper.pagination;
import Models.Blog;
import Models.Demande;
import Models.GroupSang;
import Models.Ville;

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
    private GroupSangDao groupSangDao;
    private VilleDao villeDao;
    private List<Ville> villes;
    private List<GroupSang> groupSangList;
    private int villeFilter = -1;
    private int groupeFilter = -1;
    private int totalRequests;

    @Override
    public void init() throws ServletException {
        super.init();
        daoFactory = DAOFactory.getInstance();
        demandeDao = daoFactory.getDemandeDaoImpl();
        groupSangDao = daoFactory.getGroupSangDaoImpl();
        villeDao = daoFactory.getVilleDaoImpl();
        villes = villeDao.getAllVille();
        groupSangList = groupSangDao.getAllGroups();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ville = request.getParameter("citySelect");
        String groupe = request.getParameter("groupSangSelect");

        if(ville.equals("default"))
            villeFilter = -1;
        else{
            villeFilter = Utile.getVilleByName(villes,ville).getIdVille();
        }

        if(groupe.equals("default"))
            groupeFilter = -1;
        else{
            groupeFilter = Utile.getGroupeByName(groupSangList,groupe).getIdGroupe();
        }
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        totalRequests = demandeDao.countRequests(villeFilter,groupeFilter);
        int CurrentPage = (request.getParameter("page") != null) ? Integer.parseInt(request.getParameter("page")) : 1;
        List<Demande> demandes = demandeDao.getRequestsByPagination((CurrentPage - 1) * 5, 5,villeFilter,groupeFilter);
        demandes = demandes == null ? new ArrayList<>() : demandes ;
        List<RequestPagination> requests = new ArrayList<>();
        for(Demande demande : demandes){
            requests.add(Utile.createRequestClass(demande));
        }
        request.setAttribute("requests", requests);
        request.setAttribute("villes",villes);
        request.setAttribute("groupSangList",groupSangList);
        pagination pg = new pagination(totalRequests, 5, 5, CurrentPage);
        request.setAttribute("pg", pg);
        this.getServletContext().getRequestDispatcher("/jsp/Requests.jsp").forward(request, response);
    }
}
