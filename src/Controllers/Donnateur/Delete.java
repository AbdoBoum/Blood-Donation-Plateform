package Controllers.Donnateur;

import DAO.DAOFactory;
import DAO.Interfaces.DonnateurDao;
import Helper.Utile;
import Models.Donnateur;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteProfile")
public class Delete extends HttpServlet {

    private DonnateurDao donnateurDao;
    private DAOFactory daoFactory;

    private Donnateur donnateur;

    private String flashMessageFaild = "";
    private String flashMessageSuccess = "";


    @Override
    public void init() throws ServletException {
        super.init();
        daoFactory = DAOFactory.getInstance();
        donnateurDao = daoFactory.getDonnateurDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        donnateur = (Donnateur) request.getSession().getAttribute("donnateur");
        String expassword = request.getParameter("expassword");
        String password = donnateurDao.getDonnateur(donnateur.getIdDonnateur()).getPasswordDonnateur();
        System.out.println("expassword :"+Utile.stringToSha256(expassword)+";");
        System.out.println("password :"+password+";");
        if (Utile.stringToSha256(expassword).equals(password)){
            if (donnateurDao.removeDonnateur(donnateur.getEmailDonnateur())){
                request.getSession().invalidate();
                response.sendRedirect("/");
            } else {
                flashMessageFaild = "Something goes wrong";
                request.setAttribute("flashMessageFaild", flashMessageFaild);
                this.getServletContext().getRequestDispatcher("/jsp/profile.jsp").forward(request, response);
            }
        } else {
            flashMessageFaild = "Wrong password";
            request.setAttribute("flashMessageFaild", flashMessageFaild);
            doGet(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/jsp/profile.jsp").forward(request, response);
    }
}
