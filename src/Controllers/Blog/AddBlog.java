package Controllers.Blog;

import DAO.DAOFactory;
import DAO.Interfaces.BlogDao;
import Helper.Utile;
import Models.Blog;
import Models.Donnateur;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "AddBlog")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)
public class AddBlog extends HttpServlet {

    private BlogDao blog;
    private DAOFactory daoFactory;
    private Blog _blog;
    private Donnateur donnateur;

    private String flashMessageFaild="";
    private String flashMessageSuccess="";

    @Override
    public void init() throws ServletException {
        super.init();
        daoFactory = DAOFactory.getInstance();
        blog = daoFactory.getBlogDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("title");
        String description = request.getParameter("description");

        Part part = request.getPart("imgInput");

        String fileName = Utile.extractFileName(part);


        if (title.trim().isEmpty() || description.trim().isEmpty() || part.getSize() == 0) {
            flashMessageFaild = "Please complete all fields";
            request.setAttribute("flashMessageFaild", flashMessageFaild);
        } else {
            String savePath = "F:\\JEE2019_Groupe4-3\\web\\img" + File.separator + fileName;

            File fileSaveDirectory = new File(savePath);

            part.write(savePath + File.separator);

            _blog = new Blog(); _blog.setIdDonateur(donnateur.getIdDonnateur());
            _blog.setTitreBlog(title); _blog.setContenueBlog(description);
            _blog.setPathImgBlog(savePath);
            _blog.setDateBlog(new java.sql.Timestamp(new Date().getTime()));

            if (blog.insertBlog(_blog) != null) {
                flashMessageSuccess = "Blog inserted";
                request.setAttribute("flashMessageSuccess", flashMessageSuccess);
            } else {
                flashMessageFaild = "Something goes wrong";
                request.setAttribute("flashMessageFaild", flashMessageFaild);
            }
        }
        this.getServletContext().getRequestDispatcher("/jsp/AddBlog.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/jsp/AddBlog.jsp").forward(request, response);
        HttpSession session = request.getSession();
        donnateur = (Donnateur) session.getAttribute("donnateur");

    }




}
