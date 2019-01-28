package Controllers.Donnateur;

import DAO.DAOFactory;
import DAO.Interfaces.*;
import Helper.Utile;
import Models.Donnateur;
import Models.GroupSang;
import Models.Ville;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProfileServlet")
public class ProfileServlet extends HttpServlet {

    private VilleDao villeDao;
    private GroupSangDao groupSangDao;
    private DonnateurDao donnateurDao;
    private DAOFactory daoFactory;
    private List<Ville> villes;
    private List<GroupSang> groupSangList;

    private String flashMessageFaild="";
    private String flashMessageSuccess="";

    Donnateur donnateur;


    @Override
    public void init() throws ServletException {
        super.init();
        daoFactory = DAOFactory.getInstance();
        villeDao = daoFactory.getVilleDaoImpl();
        groupSangDao = daoFactory.getGroupSangDaoImpl();
        donnateurDao = daoFactory.getDonnateurDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");
        String cin = request.getParameter("cin");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String city = request.getParameter("villeSelect");
        String blood = request.getParameter("groupSangSelect");

        if (prenom.isEmpty() || nom.isEmpty() || cin.isEmpty() || email.isEmpty() ||
                password.isEmpty() || phone.isEmpty() || city.isEmpty() || blood.isEmpty()){

            flashMessageFaild = "Please complete all fields";
            request.setAttribute("flashMessageFaild", flashMessageFaild);
            doGet(request, response);
        } else {
            donnateur.setIdDonnateur(donnateur.getIdDonnateur());
            donnateur.setNomDonnateur(nom); donnateur.setPrenomDonnateur(prenom); donnateur.setCinDonnateur(cin);
            donnateur.setEmailDonnateur(email); donnateur.setPasswordDonnateur(donnateur.getPasswordDonnateur());donnateur.setTeleDonnateur(phone);
            donnateur.setIdGroupeSangDonnateur(Integer.parseInt(blood)); donnateur.setIdVilleDonnateur(Integer.parseInt(city));
            if (donnateurDao.updateDonnateur(donnateur)){
                flashMessageSuccess = "Profile Updated";
                request.setAttribute("flashMessageSuccess", flashMessageSuccess);
                doGet(request, response);
            } else {
                flashMessageFaild = "Something goes wrong";
                request.setAttribute("flashMessageFaild", flashMessageFaild);
                doGet(request, response);
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        donnateur = (Donnateur) request.getSession().getAttribute("donnateur");

        if (villes == null){
            villes = villeDao.getAllVille();
        }
        if (groupSangList == null) {
            groupSangList = groupSangDao.getAllGroups();
        }
        request.setAttribute("villes",villes);
        request.setAttribute("groupSangList",groupSangList);
        this.getServletContext().getRequestDispatcher("/jsp/profile.jsp").forward(request, response);
    }
}
