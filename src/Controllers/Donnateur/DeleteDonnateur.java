package Controllers.Donnateur;

import DAO.DAOFactory;
import DAO.Interfaces.DonnateurDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DeleteDonnateur")
public class DeleteDonnateur extends HttpServlet {
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
                deleteDonnateur(request, response);
        }else{
            response.sendRedirect("/login");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/");
    }

    private void deleteDonnateur(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        HttpSession session=request.getSession();
        if (session.getAttribute("centre")!=null){

            String email=request.getParameter("email");
            if(!email.trim().isEmpty()){

                System.out.println("in delete Donnateur");
                if(!donnateurDao.findDonnateurByMail(email)){
                    request.setAttribute("flashMessageFaild", "Wrong email !!");
                    this.getServletContext().getRequestDispatcher("/jsp/index.jsp").forward(request, response);
                }else {

                    if (donnateurDao.removeDonnateur(email)) {
                        System.out.println("in success deleting");
                        request.setAttribute("flashMessageSuccess", "The donnateur has been deleted !!");
                        this.getServletContext().getRequestDispatcher("/jsp/index.jsp").forward(request, response);
                    } else {
                        System.out.println("echec deleting");
                        request.setAttribute("flashMessageFaild", "Erreur of deleting donnateur !!");
                        this.getServletContext().getRequestDispatcher("/jsp/index.jsp").forward(request, response);
                    }
                }

            }else{
                request.setAttribute("flashMessageFaild", "Email field must be complete!!");
                this.getServletContext().getRequestDispatcher("/jsp/index.jsp").forward(request, response);
            }

        }else{
            response.sendRedirect("/login");
        }

    }
}
