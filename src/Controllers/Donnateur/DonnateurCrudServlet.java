package Controllers.Donnateur;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DonnateurCrudServlet")
public class DonnateurCrudServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();

        if(session.getAttribute("centre")!=null) {

            this.getServletContext().getRequestDispatcher("/jsp/Donnateur/managementDonnateur.jsp").forward(request,response);

        }else{
            response.sendRedirect("/login");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        if(session.getAttribute("centre")!=null){

            this.getServletContext().getRequestDispatcher("/jsp/Donnateur/managementDonnateur.jsp").forward(request,response);

        }else{
                response.sendRedirect("/login");
            }
        }
}
