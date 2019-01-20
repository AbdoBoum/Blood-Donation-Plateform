package Controllers;

import DAO.DAOFactory;
import DAO.Interfaces.BlogDao;
import DAO.Interfaces.DonnateurDao;
import Helper.Utile;
import Models.Blog;
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

    @Override
    public void init() throws ServletException {
        super.init();
        daoFactory = DAOFactory.getInstance();
        donnateurDao = daoFactory.getDonnateurDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        donnateur = donnateurDao.getDonnateur(email, Utile.stringToSha256(password));

        if(donnateur != null){
            HttpSession session = request.getSession();
            session.setAttribute("donnateur", donnateur);
            response.sendRedirect("/");
        } else {
            String msg = "Invalid informations";
            request.setAttribute("msg", msg);
            this.getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request, response);
    }
}
