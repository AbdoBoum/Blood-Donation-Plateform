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
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UpdateDonnateur")
public class UpdateDonnateur extends HttpServlet {

    private DAOFactory daoFactory;
    private DonnateurDao donnateurDao;

    @Override
    public void init() throws ServletException {
        super.init();
        daoFactory=DAOFactory.getInstance();
        donnateurDao=daoFactory.getDonnateurDaoImpl();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        if(session.getAttribute("centre")!=null) {

                updateDonnateur(request, response);

        }else{
            response.sendRedirect("/login");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        if (session.getAttribute("centre") != null) {

            VilleDao villeDao = daoFactory.getVilleDaoImpl();
            List<Ville> villes = villeDao.getAllVille();
            request.setAttribute("villes", villes);

            GroupSangDao groupSangDao = daoFactory.getGroupSangDaoImpl();
            List<GroupSang> groupeSangs = groupSangDao.getAllGroups();
            request.setAttribute("sangs", groupeSangs);

            if (!request.getParameterMap().containsKey("id")) {
                request.setAttribute("flashMessageFaild", "Link Error !!");
                this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

            } else {


                if(request.getParameter("id").trim().isEmpty()){
                    request.setAttribute("flashMessageFaild", "Choose identifier.");
                    this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                }else{

                    String idDonnateur = request.getParameter("id");
                    String erreur="";
                    erreur=validationChamp(idDonnateur,"^\\d+$","Identifier must be number.");
                    if(erreur!=""){
                        request.setAttribute("flashMessageFaild", erreur);
                        this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                    }else{
                        int id = Integer.parseInt(idDonnateur);

                        Donnateur donnateur = donnateurDao.getDonnateur(id);

                        if (donnateur != null) {

                            request.setAttribute("donnateur", donnateur);
                            this.getServletContext().getRequestDispatcher("/jsp/Donnateur/updateDonnateur.jsp").forward(request, response);

                        } else {
                            request.setAttribute("flashMessageFaild", "Wrong Identifier.");
                            this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

                        }
                    }
                }
            }
        } else {
            response.sendRedirect("/login");
        }
    }


    private void updateDonnateur(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        int id=Integer.parseInt(request.getParameter("id").trim());
        Donnateur donnateur=donnateurDao.getDonnateur(id);
        request.setAttribute("donnateur", donnateur);

        // verification si les champs sont remplis
        if(request.getParameter("groupSang").trim().isEmpty()||request.getParameter("email").trim().isEmpty()
                ||request.getParameter("tele").trim().isEmpty()||request.getParameter("ville").trim().isEmpty()){

            request.setAttribute("flashMessageFaild","Please complete all fields");
            returnUpdateFormulaire(request,response);
        }else {
        // verification de contenue des champs
        String errorsFields="";
        errorsFields+=validationChamp(request.getParameter("tele"),"^(\\+212|0)[0-9]{9}$","Phone number is not valid !!<br> ");
        errorsFields+=validationChamp(request.getParameter("email"),"^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[a-z]{2,6}$","Email is not valid!!<br>");

        if (!errorsFields.equals("")){
            request.setAttribute("flashMessageFaild",errorsFields);
            returnUpdateFormulaire(request,response);
        }else{


        donnateur.setEmailDonnateur(request.getParameter("email"));
        donnateur.setTeleDonnateur(request.getParameter("tele"));
        donnateur.setIdVilleDonnateur(Integer.parseInt(request.getParameter("ville").trim()));
        donnateur.setIdGroupeSangDonnateur(Integer.parseInt(request.getParameter("groupSang").trim()));

        System.out.println(donnateur.getIdDonnateur()+"  "+donnateur.getIdVilleDonnateur()+"  "+donnateur.getIdGroupeSangDonnateur());
        System.out.println(donnateur.getEmailDonnateur()+"  "+donnateur.getPasswordDonnateur()+"  "+donnateur.getTeleDonnateur());

        boolean update=donnateurDao.updateDonnateur(donnateur);

        if(update){
            String msg="Donor has been updated.";
            request.setAttribute("flashMessageSuccess", msg);
            this.getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
        }else{
            String msg="Donor updating failure.";
            request.setAttribute("flashMessageFaild", msg);
            this.getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
        }
        }
        }
    }

    private String validationChamp(String field, String pattern,String erreur){
        if(!field.matches(pattern)){
            return erreur;
        }
        return "";
    }

    private void returnUpdateFormulaire(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

        VilleDao villeDao=daoFactory.getVilleDaoImpl();
        List<Ville> villes=villeDao.getAllVille();
        request.setAttribute("villes",villes);
        GroupSangDao groupSangDao=daoFactory.getGroupSangDaoImpl();
        List<GroupSang> groupeSangs=groupSangDao.getAllGroups();
        request.setAttribute("sangs", groupeSangs);

        this.getServletContext().getRequestDispatcher("/jsp/Donnateur/updateDonnateur.jsp").forward(request,response);
    }
}
