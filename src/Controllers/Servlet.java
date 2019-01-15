package Controllers;

import DAO.DAOFactory;
import DAO.Interfaces.GroupSangDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        //PrintWriter writer = response.getWriter();
        //writer.println("test a wld kayna");
        //DAOFactory daoFactory = DAOFactory.getInstance();
        //GroupSangDao groupSangDao = daoFactory.getGroupSangDaoImpl();
        //System.out.println(groupSangDao.getGroupSang(1).getNameGroupe());
    }
}
