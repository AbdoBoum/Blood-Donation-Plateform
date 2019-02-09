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
import java.util.List;

@WebServlet(name = "AddCentre")
public class AddCentre extends HttpServlet {
    private DAOFactory daoFactory;
    private VilleDao villeDao;
    private HttpSession session;
    private CentreDao centreDao;

    @Override
    public void init() throws ServletException {
        super.init();
        daoFactory=DAOFactory.getInstance();
        villeDao=daoFactory.getVilleDaoImpl();
        centreDao=daoFactory.getCentreDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session=request.getSession();
        if(session.getAttribute("admin")==null){
            response.sendRedirect("/admin");
        }else{
            String nomCentre=request.getParameter("nom");
            String emailCentre=request.getParameter("email");
            String passwordCentre=request.getParameter("password");
            String addresseCentre=request.getParameter("addresse");
            String strIdVille=request.getParameter("ville");
            String gsm=request.getParameter("tele");

            System.out.println(nomCentre+" "+emailCentre+" "+passwordCentre+" "+addresseCentre+" "+strIdVille+" "+gsm);
            // validaton des champs
            if(nomCentre.trim().isEmpty()||emailCentre.trim().isEmpty()||passwordCentre.trim().isEmpty()||addresseCentre.trim().isEmpty()
                    ||strIdVille.trim().isEmpty()||gsm.trim().isEmpty()){
                request.setAttribute("flashMessageFaild","Please complete all fields");
                returnFormulaire(request,response);
            }else{
                //validation pour chaque champs
                String errors="";
                errors+=validationField(emailCentre,"^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[a-z]{2,6}$","Email is invalid <br>");
                errors+=validationField(passwordCentre,"^.{6,30}$","Error must have beetwen 6 and 30 caracter<br>");
                errors+=validationField(gsm,"^(\\+212|0)[0-9]{9}$","Number gsm is invalid<br>");
                if(!errors.isEmpty()){
                    request.setAttribute("flashMessageFaild",errors);
                    returnFormulaire(request,response);
                }else{

                    Admin admin=(Admin) session.getAttribute("admin");
                    System.out.println(admin.getIdAdmin());
                    Centre centre=new Centre();
                    centre.setNameCentre(nomCentre);
                    centre.setEmailCentre(emailCentre);
                    centre.setPasswordCentre(Utile.stringToSha256(passwordCentre));
                    centre.setAdresseCentre(addresseCentre);
                    centre.setIdAdmin(admin.getIdAdmin());
                    centre.setIdVille(Integer.parseInt(strIdVille));
                    centre.setTeleCentre(gsm);
                    if(!centreDao.searchCentreByEmail(emailCentre.trim())){
                        if (centreDao.insertCentre(centre)){
                            request.setAttribute("flashMessageSuccess","Centre has been added");
                            response.sendRedirect("/dashboard");
                        }else{
                            request.setAttribute("flashMessageFaild", "Error adding Centre");
//                        this.getServletContext().getRequestDispatcher("/jsp/adminDashBoard.jsp").forward(request, response);
                            response.sendRedirect("/dashboard");
                        }

//                        this.getServletContext().getRequestDispatcher("/jsp/adminDashBoard.jsp").forward(request,response);
                    }else {
                        request.setAttribute("flashMessageFaild", "Mail is already exist");
//                        this.getServletContext().getRequestDispatcher("/jsp/adminDashBoard.jsp").forward(request, response);
                        response.sendRedirect("/dashboard");
                    }

                }
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // return formullaire centre
        session=request.getSession();
        if(session.getAttribute("admin")==null){
            response.sendRedirect("/admin");
        }else{
            List<Ville> villes=villeDao.getAllVille();
            request.setAttribute("villes",villes);
            this.getServletContext().getRequestDispatcher("/jsp/Centre/formulaireAddCentre.jsp").forward(request,response);
        }

    }
    private void returnFormulaire(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("oldNom",request.getParameter("nom"));
        request.setAttribute("oldEmail",request.getParameter("email"));
        request.setAttribute("oldAddresse",request.getParameter("addresse"));
        request.setAttribute("oldVille",request.getParameter("ville"));
        request.setAttribute("oldTele",request.getParameter("tele"));
        List<Ville> villes=villeDao.getAllVille();
        request.setAttribute("villes",villes);

        this.getServletContext().getRequestDispatcher("/jsp/Centre/formulaireAddCentre.jsp").forward(request,response);
    }

    private String validationField(String field,String pattern,String erreur){
        if(field.matches(pattern)){
            return "";
        }else{
            return erreur;
        }
    }
}
