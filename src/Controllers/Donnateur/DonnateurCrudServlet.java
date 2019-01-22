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
        if(!request.getParameterMap().containsKey("update")){
            VilleDao villeDao=daoFactory.getVilleDaoImpl();
            List<Ville> villes=villeDao.getAllVille();
            request.setAttribute("villes",villes);
            GroupSangDao groupSangDao=daoFactory.getGroupSangDaoImpl();
            List<GroupSang> groupeSangs=groupSangDao.getAllGroups();
            request.setAttribute("sangs", groupeSangs);

            this.getServletContext().getRequestDispatcher("/jsp/Donnateur/addDonnateur.jsp").forward(request,response);
        }else{
            String id_donnateur=request.getParameter("update");

            int id=Integer.parseInt(id_donnateur);
            Donnateur donnateur=donnateurDao.getDonnateur(id);
            if(donnateur!=null){
                request.setAttribute("donnateur", donnateur);
            }else{
                //todo
                //rediraction vers formulaire medification
            }
        }
    }
    private void updateDonnateur(HttpServletRequest request,HttpServletResponse response){
        int id=Integer.parseInt(request.getParameter("id"));
        Donnateur donnateur=donnateurDao.getDonnateur(id);
        donnateur.setNomDonnateur(request.getParameter("nom"));
        donnateur.setPrenomDonnateur(request.getParameter("prenom"));
        donnateur.setIdGroupeSangDonnateur(Integer.parseInt(request.getParameter("groupSang")));
        donnateur.setCinDonnateur(request.getParameter("cin"));
        donnateur.setEmailDonnateur(request.getParameter("email"));
        donnateur.setTeleDonnateur(request.getParameter("telephone"));
        donnateur.setIdVilleDonnateur(Integer.parseInt(request.getParameter("ville")));
        if(donnateurDao.updateDonnateur(donnateur)){

        }else{
            
        }

    }
    private void deleteDonnteur(HttpServletRequest request,HttpServletResponse response) throws IOException {

        String email=request.getParameter("email");
        if(donnateurDao.removeDonnateur(email)){
            response.sendRedirect("jsp/home.jsp");
        }else{
            response.sendRedirect("jsp/home.jsp");

        }

    }
    private void addDonnateur(HttpServletRequest request,HttpServletResponse response) throws IOException {

        Donnateur donnateur=new Donnateur();
        donnateur.setNomDonnateur(request.getParameter("nom"));
        donnateur.setPrenomDonnateur(request.getParameter("prenom"));
        donnateur.setCinDonnateur(request.getParameter("cin"));
        donnateur.setEmailDonnateur(request.getParameter("email"));
        donnateur.setPasswordDonnateur(Helper.Utile.stringToSha256(request.getParameter("password")));
        donnateur.setTeleDonnateur(request.getParameter("tele"));
        donnateur.setIdVilleDonnateur(Integer.parseInt(request.getParameter("ville").trim()));
        donnateur.setIdGroupeSangDonnateur(Integer.parseInt(request.getParameter("groupeSang").trim()));
        if(donnateurDao.addDonnateur(donnateur)){
            //response.sendRedirect("jsp/Donnateur/addDonnateur.jsp");
        }else{
            this.getServletContext().getRequestDispatcher("jsp/Donnateur/addDonnateur.jsp");
        }
    }
}
