package Controllers.Blog;

import DAO.DAOFactory;
import DAO.Interfaces.BlogDao;
import Models.Blog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "BlogServlet")
public class BlogServlet extends HttpServlet {

    private BlogDao blog;
    private DAOFactory daoFactory;

    @Override
    public void init() throws ServletException {
        super.init();
        daoFactory = DAOFactory.getInstance();
        blog = daoFactory.getBlogDaoImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Blog> blogs = blog.getBlogByPagination(1, 6);
        request.setAttribute("blogs", blogs);
        this.getServletContext().getRequestDispatcher("/jsp/blog.jsp").forward(request, response);

    }
}
