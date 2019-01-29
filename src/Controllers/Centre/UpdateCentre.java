package Controllers.Centre;

import DAO.DAOFactory;
import DAO.Interfaces.CentreDao;
import DAO.Interfaces.VilleDao;
import Helper.Utile;
import Models.Admin;
import Models.Centre;
import Models.Ville;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "UpdateCentre")
public class UpdateCentre extends HttpServlet {
    private DAOFactory daoFactory;
    private HttpSession session;
    private CentreDao centreDao;
    private VilleDao villeDao;
    private Boolean isCentre;

    @Override
    public void init() throws ServletException {
        super.init();
        daoFactory = DAOFactory.getInstance();
        centreDao = daoFactory.getCentreDaoImpl();
        villeDao = daoFactory.getVilleDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        if (session.getAttribute("admin") == null && session.getAttribute("centre") == null) {
            response.sendRedirect("/login");
        } else {
            isCentre = session.getAttribute("centre") == null ? false : true;
            String idCentre = request.getParameter("id");
            Centre centre = centreDao.getCentre(Integer.parseInt(idCentre));
            if (centre == null) {
                if (!isCentre)
                    request.setAttribute("flashMessageFaild", "Wrong Identifiant");

                this.getServletContext().getRequestDispatcher(isCentre ? "/index.jsp" : "/jsp/adminDashBoard.jsp").forward(request, response);
            } else {
                if (isCentre) {
                    Centre centreConnecter = (Centre) session.getAttribute("centre");
                    if (centreConnecter.getIdCentre() != centre.getIdCentre()) {
                        this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                        return;
                    }
                }
//            Admin admin=(Admin) session.getAttribute("admin");
                String nomCentre = request.getParameter("nom");
                String emailCentre = request.getParameter("email");
                //juste pour passer les validation de password si admin est connecter
                String passwordCentre = "passwordCentre";
                if (isCentre) {
                    passwordCentre = request.getParameter("password");
                }
                String addresseCentre = request.getParameter("addresse");
                String strIdVille = request.getParameter("ville");
                String gsm = request.getParameter("tele");
                // validaton des champs
                System.out.println(idCentre + " " + nomCentre + " " + emailCentre + " " + passwordCentre + " " + addresseCentre + " " + strIdVille + " " + gsm);
                if (nomCentre.trim().isEmpty() || emailCentre.trim().isEmpty() || addresseCentre.trim().isEmpty()
                        || strIdVille.trim().isEmpty() || gsm.trim().isEmpty()) {
                    request.setAttribute("centre", centre);
                    request.setAttribute("flashMessageFaild", "Please complete the required fields");
                    returnFormulaire(request, response);
                } else {
                    //validation pour chaque champs
                    String errors = "";
                    errors += validationField(emailCentre, "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[a-z]{2,6}$", "Email is invalid <br>");
                    if (isCentre && !passwordCentre.trim().isEmpty()) {
                        errors += validationField(passwordCentre, "^.{6,30}$", "Error must have beetwen 6 and 30 caracter<br>");
                    }
                    errors += validationField(gsm, "^(\\+212|0)[0-9]{9}$", "Number gsm is invalid<br>");
                    if (!errors.isEmpty()) {
                        request.setAttribute("flashMessageFaild", errors);
                        request.setAttribute("centre", centre);
                        returnFormulaire(request, response);
                    } else {

                        centre.setNameCentre(nomCentre);
                        centre.setEmailCentre(emailCentre);
                        if (isCentre && !passwordCentre.trim().isEmpty()) {
                            centre.setPasswordCentre(Utile.stringToSha256(passwordCentre));
                        }
                        centre.setAdresseCentre(addresseCentre);
//                    centre.setIdAdmin(admin.getIdAdmin());

                    centre.setIdVille(Integer.parseInt(strIdVille));
                    centre.setTeleCentre(gsm);

                    if(centreDao.updateCentre(centre)){
                        request.setAttribute("flashMessageSuccess","Centre has been updated");
                        if(isCentre){
                            centre=centreDao.getCentre(Integer.parseInt(idCentre));
                            session.setAttribute("centre", centre);
                            this.getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
                        }
                       response.sendRedirect("/dashboard");
                    }else {
                        request.setAttribute("flashMessageFaild", "Error updating centre");
                        if(isCentre){
                            centre=centreDao.getCentre(Integer.parseInt(idCentre));
                            session.setAttribute("centre", centre);
                            this.getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
                        }
                        response.sendRedirect("/dashboard");
//                        this.getServletContext().getRequestDispatcher(isCentre?"/index.jsp":"/jsp/adminDashBoard.jsp").forward(request, response);
                    }


                    }
                }
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // return formullaire centre
        session = request.getSession();

        if (session.getAttribute("admin") == null && session.getAttribute("centre") == null) {
            response.sendRedirect("/login");
        } else {
            Boolean isCentre = session.getAttribute("centre") == null ? false : true;
            List<Centre> centres = centreDao.getAllCentre();
            request.setAttribute("centres", centres);

            if (!request.getParameterMap().containsKey("update")) {
                request.setAttribute("flashMessageFaild", "Erreur link !");
                this.getServletContext().getRequestDispatcher(isCentre ? "/index.jsp" : "/jsp/adminDashBoard.jsp").forward(request, response);


            } else {


                String strIdCentre = request.getParameter("update").trim();
                String error = "";
                error += validationField(strIdCentre, "^\\d+$", "Identifiant must be numerique");

                if (!error.equals("")) {
                    request.setAttribute("flashMessageFaild", "Identifiant must be number");
                    this.getServletContext().getRequestDispatcher(isCentre ? "/index.jsp" : "/jsp/adminDashBoard.jsp").forward(request, response);
                } else {
                    int idCentre = Integer.parseInt(strIdCentre);
                    Centre centre = centreDao.getCentre(idCentre);
                    if (isCentre) {
                        Centre centreConnecter = (Centre) session.getAttribute("centre");
                        if (centreConnecter.getIdCentre() != centre.getIdCentre()) {
                            response.sendRedirect("/");
                            return;
                        }
                    }
                    if (centre == null) {
                        request.setAttribute("flashMessageFaild", "Wrong Identifiant");
                        this.getServletContext().getRequestDispatcher(isCentre ? "/index.jsp" : "/jsp/adminDashBoard.jsp").forward(request, response);
                    } else {
                        request.setAttribute("centre", centre);
                        List<Ville> villes = villeDao.getAllVille();
                        request.setAttribute("villes", villes);
                        this.getServletContext().getRequestDispatcher("/jsp/Centre/formulaireUpdateCentre.jsp").forward(request, response);
                    }
                }
            }
        }
    }

    private void returnFormulaire(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!isCentre) {
            List<Ville> villes = villeDao.getAllVille();
            request.setAttribute("villes", villes);
        }
        this.getServletContext().getRequestDispatcher("/jsp/Centre/formulaireUpdateCentre.jsp").forward(request, response);
    }

    private String validationField(String field, String pattern, String erreur) {
        if (field.matches(pattern)) {
            return "";
        } else {
            return erreur;
        }
    }
}
