package Controllers.Admin;

import DAO.DAOFactory;
import DAO.Interfaces.CentreDao;
import Models.Admin;
import Models.Centre;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DashBoardAdmin")
public class DashBoardAdmin extends HttpServlet {
    private HttpSession session;



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session=request.getSession();
        Admin admin=(Admin)session.getAttribute("admin");
        if(admin==null){
            response.sendRedirect("/admin");
        }else{
            DAOFactory daoFactory=DAOFactory.getInstance();
            CentreDao centreDao=daoFactory.getCentreDaoImpl();
            List<Centre> centres=centreDao.getAllCentre();
            request.setAttribute("centres",centres);
            request.getServletContext().getRequestDispatcher("/jsp/adminDashBoard.jsp").forward(request,response);
        }
    }
}
