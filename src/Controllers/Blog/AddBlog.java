package Controllers.Blog;

import DAO.DAOFactory;
import DAO.Interfaces.BlogDao;
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
    //private Donnateur donnateur;

    private String isInserted;

    public static String SUCCESS_MSG = "succes";
    public static String FAILURE_MSG = "failure";
    public static String EMPTY_FIELD = "empty";

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

        String fileName = extractFileName(part);


        if (title.trim().isEmpty() || description.trim().isEmpty() || part.getSize() == 0) {
            isInserted = EMPTY_FIELD;
            request.setAttribute("isInserted", isInserted);
            this.getServletContext().getRequestDispatcher("/jsp/AddBlog.jsp").forward(request, response);
        } else {
            String savePath = "C:\\Users\\ABDERRAHIM\\IdeaProjects\\JEE2019_Groupe4-3\\web\\img\\" + File.separator + fileName;

            File fileSaveDirectory = new File(savePath);

            part.write(savePath + File.separator);

            _blog = new Blog(); //_blog.setIdDonateur(donnateur.getIdDonnateur());
            _blog.setIdDonateur((int) Math.random());
            _blog.setTitreBlog(title);
            _blog.setContenueBlog(description);
            _blog.setPathImgBlog(savePath);
            _blog.setDateBlog(new java.sql.Timestamp(new Date().getTime()));
            _blog.setIdDonateur((int) Math.random());

            if (blog.insertBlog(_blog) != null) {
                isInserted = SUCCESS_MSG;
                request.setAttribute("isInserted", isInserted);
                this.getServletContext().getRequestDispatcher("/jsp/AddBlog.jsp").forward(request, response);
            } else {
                isInserted = FAILURE_MSG;
                request.setAttribute("isInserted", isInserted);
                this.getServletContext().getRequestDispatcher("/jsp/AddBlog.jsp").forward(request, response);
            }

        }


        this.getServletContext().getRequestDispatcher("/jsp/blog.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //HttpSession session = request.getSession();
        //donnateur = (Donnateur) session.getAttribute("donnateur");

    }


    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");

        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

}
