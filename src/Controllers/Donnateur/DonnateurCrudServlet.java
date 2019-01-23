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
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DonnateurCrudServlet")
public class DonnateurCrudServlet extends HttpServlet {
    private DAOFactory daoFactory;
    private DonnateurDao donnateurDao;
    private final String managementLink="/managementDonnateur";

    @Override
    public void init() throws ServletException {
        super.init();
        daoFactory=DAOFactory.getInstance();
        donnateurDao=daoFactory.getDonnateurDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameterMap().containsKey("update")){
            updateDonnateur(request,response);
        }else if(request.getParameterMap().containsKey("delete")){
            deleteDonnteur(request,response);
        }else{
            addDonnateur(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(managementLink.equals(request.getServletPath())){
            this.getServletContext().getRequestDispatcher("/jsp/Donnateur/managementDonnateur.jsp").forward(request,response);
        }else{

        VilleDao villeDao=daoFactory.getVilleDaoImpl();
        List<Ville> villes=villeDao.getAllVille();

        request.setAttribute("villes",villes);
        GroupSangDao groupSangDao=daoFactory.getGroupSangDaoImpl();
        List<GroupSang> groupeSangs=groupSangDao.getAllGroups();

        request.setAttribute("sangs", groupeSangs);

        if(!request.getParameterMap().containsKey("update")){

            this.getServletContext().getRequestDispatcher("/jsp/signUpDonnateur.jsp").forward(request,response);

        }else{

            String idDonnateur=request.getParameter("update");
            int id=Integer.parseInt(idDonnateur);
            Donnateur donnateur=donnateurDao.getDonnateur(id);
            if(donnateur!=null){
                request.setAttribute("donnateur", donnateur);
                this.getServletContext().getRequestDispatcher("/jsp/Donnateur/updateDonnateur.jsp").forward(request,response);

            }else{
                //todo
                //rediraction vers formulaire modification
                System.out.println("else is executed");
            }
        }
        }
    }
    private void updateDonnateur(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        int id=Integer.parseInt(request.getParameter("id").trim());
        Donnateur donnateur=donnateurDao.getDonnateur(id);
        donnateur.setEmailDonnateur(request.getParameter("email"));
        donnateur.setTeleDonnateur(request.getParameter("tele"));
        donnateur.setIdVilleDonnateur(Integer.parseInt(request.getParameter("ville").trim()));
        donnateur.setIdGroupeSangDonnateur(Integer.parseInt(request.getParameter("groupSang").trim()));

        System.out.println(donnateur.getIdDonnateur()+"  "+donnateur.getIdVilleDonnateur()+"  "+donnateur.getIdGroupeSangDonnateur());
        System.out.println(donnateur.getEmailDonnateur()+"  "+donnateur.getPasswordDonnateur()+"  "+donnateur.getTeleDonnateur());

        boolean update=donnateurDao.updateDonnateur(donnateur);

        if(update){
            String msg="The donnateur has been updated !!";
            request.setAttribute("flashMessageSuccess", msg);
            this.getServletContext().getRequestDispatcher("/jsp/Donnateur/managementDonnateur.jsp").forward(request,response);
        }else{
            String msg="The donnateur has been updated !!";
            request.setAttribute("flashMessageFaild", msg);
            this.getServletContext().getRequestDispatcher("/jsp/Donnateur/managementDonnateur.jsp").forward(request,response);
        }

    }
    private void deleteDonnteur(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {

        String email=request.getParameter("email");

        System.out.println("in delete Donnateur");
        if(donnateurDao.removeDonnateur(email)){
            System.out.println("in success deleting");
            request.setAttribute("flashMessageSuccess", "The donnateur has been deleted !!");
            this.getServletContext().getRequestDispatcher("/jsp/Donnateur/managementDonnateur.jsp").forward(request,response);
        }else{
            System.out.println("echec deleting");
            request.setAttribute("flashMessageFaild", "Erreur of deleting donnateur !!");
            this.getServletContext().getRequestDispatcher("/jsp/Donnateur/managementDonnateur.jsp").forward(request,response);
        }

    }
    private void addDonnateur(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {

        Donnateur donnateur=new Donnateur();
        donnateur.setNomDonnateur(request.getParameter("nom"));
        donnateur.setPrenomDonnateur(request.getParameter("prenom"));
        donnateur.setCinDonnateur(request.getParameter("cin"));
        donnateur.setEmailDonnateur(request.getParameter("email"));
        donnateur.setPasswordDonnateur(Helper.Utile.stringToSha256(request.getParameter("password")));
        donnateur.setTeleDonnateur(request.getParameter("tele"));
        donnateur.setIdVilleDonnateur(Integer.parseInt(request.getParameter("ville").trim()));
        donnateur.setIdGroupeSangDonnateur(Integer.parseInt(request.getParameter("groupSang").trim()));
        if(donnateurDao.addDonnateur(donnateur)){
            System.out.println("donateur has been added");
            request.setAttribute("flashMessageSuccess", "Donnateur has been added!!");
            this.getServletContext().getRequestDispatcher("/jsp/Donnateur/managementDonnateur.jsp").forward(request,response);
        }else{
            request.setAttribute("flashMessageFaild", "Error adding Donnateur!!");
            this.getServletContext().getRequestDispatcher("/jsp/Donnateur/managementDonnateur.jsp").forward(request,response);
        }
    }
}
