package Controllers.Blog;

import DAO.DAOFactory;
import DAO.Interfaces.BlogDao;
import Helper.pagination;
import Models.Blog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BlogServlet")
public class BlogServlet extends HttpServlet {

    private BlogDao blog;
    private DAOFactory daoFactory;
    private int totalBlogs;

    @Override
    public void init() throws ServletException {
        super.init();
        daoFactory = DAOFactory.getInstance();
        blog = daoFactory.getBlogDaoImpl();
        totalBlogs = blog.CountBlogs();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int CurrentPage = (request.getParameter("page") != null) ? Integer.parseInt(request.getParameter("page")) : 1;
        List<Blog> blogs = blog.getBlogByPagination((CurrentPage - 1) * 6, 6);
        request.setAttribute("blogs", blogs);
        pagination pg = new pagination(totalBlogs, 6, 5, CurrentPage);
        request.setAttribute("pg", pg);
        this.getServletContext().getRequestDispatcher("/jsp/blog.jsp").forward(request, response);

    }
}
