package Controllers.Login;

import DAO.DAOFactory;
import DAO.Interfaces.BlogDao;
import DAO.Interfaces.CentreDao;
import DAO.Interfaces.DonnateurDao;
import Helper.Utile;
import Models.Admin;
import Models.Blog;
import Models.Centre;
import Models.Donnateur;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    private DonnateurDao donnateurDao;
    private Donnateur donnateur;
    private DAOFactory daoFactory;
    private CentreDao centreDao;
    private Centre centre;

    @Override
    public void init() throws ServletException {
        super.init();
        daoFactory = DAOFactory.getInstance();
        donnateurDao = daoFactory.getDonnateurDaoImpl();
        centreDao = daoFactory.getCentreDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        donnateur = donnateurDao.getDonnateur(email, Utile.stringToSha256(password));
        centre = centreDao.getCentre(email, Utile.stringToSha256(password));

        if(donnateur == null && centre == null){
            String msg = "Invalid informations";
            request.setAttribute("msg", msg);
            this.getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request, response);

        } else {
            if(donnateur != null){
                HttpSession session = request.getSession();
                session.setAttribute("donnateur", donnateur);
                response.sendRedirect("/");
            }else {
                HttpSession session = request.getSession();
                session.setAttribute("centre", centre);
                response.sendRedirect("/");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if((Admin)session.getAttribute("admin") == null && (Centre)session.getAttribute("centre") == null && (Donnateur)session.getAttribute("donnateur") == null)
            this.getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        else if((Admin)session.getAttribute("admin") != null){
            response.sendRedirect("/dashboard");
        }
        else{
            response.sendRedirect("/");
        }
    }
}
