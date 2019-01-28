package Controllers.Donnateur;

import DAO.DAOFactory;
import DAO.Interfaces.DonnateurDao;
import DAO.Interfaces.GroupSangDao;
import DAO.Interfaces.VilleDao;
import Models.Donnateur;
import Models.GroupSang;
import Models.Ville;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddDonnateur")
public class AddDonnateur extends HttpServlet {
    private DAOFactory daoFactory;
    private DonnateurDao donnateurDao;

    @Override
    public void init() throws ServletException {
        super.init();
        daoFactory = DAOFactory.getInstance();
        donnateurDao = daoFactory.getDonnateurDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("centre") != null) {
            String jspLink = "/index.jsp";
            addDonnateur(jspLink, request, response);
        } else {
            String jspLink = "/jsp/login.jsp";
            addDonnateur(jspLink, request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("donnateur") == null) {
            VilleDao villeDao = daoFactory.getVilleDaoImpl();
            List<Ville> villes = villeDao.getAllVille();
            request.setAttribute("villes", villes);
            GroupSangDao groupSangDao = daoFactory.getGroupSangDaoImpl();
            List<GroupSang> groupeSangs = groupSangDao.getAllGroups();
            request.setAttribute("sangs", groupeSangs);
            this.getServletContext().getRequestDispatcher("/jsp/Donnateur/addDonnateur.jsp").forward(request, response);
        } else {
            response.sendRedirect("/");

        }
    }


    private void addDonnateur(String jspLink, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // verification si les champs sont remplis

        if (request.getParameter("groupSang").trim().isEmpty() || request.getParameter("nom").trim().isEmpty()
                || request.getParameter("prenom").trim().isEmpty() || request.getParameter("cin").trim().isEmpty()
                || request.getParameter("email").trim().isEmpty() || request.getParameter("password").trim().isEmpty()
                || request.getParameter("tele").trim().isEmpty() || request.getParameter("ville").trim().isEmpty()) {
            String error = "Please complete all fields";
            request.setAttribute("flashMessageFaild", error);
            returnAddFormulaire(request, response);
        } else {
            // verification de contenue des champs
            String errorsFields = "";
            errorsFields += validationChamp(request.getParameter("nom"), "^[a-zA-ZàâéèêôùûçÀÂÉÈÔÙÛÇ' ]{1,30}$", "Firstname is not valid<br>");
            errorsFields += validationChamp(request.getParameter("prenom"), "^[a-zA-ZàâéèêôùûçÀÂÉÈÔÙÛÇ' ]{1,30}$", "Lastname is not valid<br>");
            errorsFields += validationChamp(request.getParameter("cin"), "^[A-Z]{1,2}[0-9]{3,10}$", "Cin is not valid !!<br>");
            errorsFields += validationChamp(request.getParameter("tele"), "^(\\+212|0)[0-9]{9}$", "Phone number is not valid !!<br>");
            errorsFields += validationChamp(request.getParameter("email"), "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[a-z]{2,6}$", "Email is not valid<br>");
            errorsFields += validationChamp(request.getParameter("password"), "^.{6,30}$", "Password must has between 6 and 30 caracter<br>");
            if (!errorsFields.equals("")) {
                request.setAttribute("flashMessageFaild", errorsFields);
                returnAddFormulaire(request, response);
            } else {

                Donnateur donnateur = new Donnateur();
                donnateur.setNomDonnateur(request.getParameter("nom"));
                donnateur.setPrenomDonnateur(request.getParameter("prenom"));
                donnateur.setCinDonnateur(request.getParameter("cin"));
                donnateur.setEmailDonnateur(request.getParameter("email"));
                donnateur.setPasswordDonnateur(Helper.Utile.stringToSha256(request.getParameter("password")));
                donnateur.setTeleDonnateur(request.getParameter("tele"));
                donnateur.setIdVilleDonnateur(Integer.parseInt(request.getParameter("ville").trim()));
                donnateur.setIdGroupeSangDonnateur(Integer.parseInt(request.getParameter("groupSang").trim()));

                if (donnateurDao.addDonnateur(donnateur)) {
                    System.out.println("Donor has been added ");
                    request.setAttribute("flashMessageSuccess", "Donor has been added");
                    response.sendRedirect("/login");
                } else {
                    request.setAttribute("flashMessageFaild", "Error adding Donor (the email is already in use)");
                    returnAddFormulaire(request, response);
                }
            }
        }
    }

    private String validationChamp(String field, String pattern, String erreur) {
        if (!field.matches(pattern)) {
            return erreur;
        }
        return "";
    }


    private void returnAddFormulaire(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        VilleDao villeDao = daoFactory.getVilleDaoImpl();
        List<Ville> villes = villeDao.getAllVille();
        request.setAttribute("villes", villes);
        GroupSangDao groupSangDao = daoFactory.getGroupSangDaoImpl();
        List<GroupSang> groupeSangs = groupSangDao.getAllGroups();
        request.setAttribute("sangs", groupeSangs);

        request.setAttribute("oldPrenom", request.getParameter("prenom"));
        request.setAttribute("oldNom", request.getParameter("nom"));
        request.setAttribute("oldTele", request.getParameter("tele"));
        request.setAttribute("oldCin", request.getParameter("cin"));
        request.setAttribute("oldEmail", request.getParameter("email"));
        request.setAttribute("oldGroupe", request.getParameter("groupSang"));
        request.setAttribute("oldVille", request.getParameter("ville"));


        this.getServletContext().getRequestDispatcher("/jsp/Donnateur/addDonnateur.jsp").forward(request, response);
    }
}
