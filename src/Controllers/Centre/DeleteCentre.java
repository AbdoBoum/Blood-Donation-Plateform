package Controllers.Centre;

import DAO.DAOFactory;
import DAO.Interfaces.AdminDao;
import DAO.Interfaces.CentreDao;
import Helper.Utile;
import Models.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DeleteCentre")
public class DeleteCentre extends HttpServlet {
    private HttpSession session;
    private DAOFactory daoFactory;
    private CentreDao centreDao;
    private Admin admin;
    private AdminDao adminDao;

    @Override
    public void init() throws ServletException {
        super.init();
        daoFactory = DAOFactory.getInstance();
        centreDao = daoFactory.getCentreDaoImpl();
        adminDao = daoFactory.getAdminDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        admin = (Admin) session.getAttribute("admin");
        if (session.getAttribute("admin") == null) {
            response.sendRedirect("/login");
        } else {
            //varification email
            String email = request.getParameter("email");
            System.out.println(admin.getPasswordAdmin());
            String expassword = Utile.stringToSha256(request.getParameter("expassword"));
            if (email.trim().isEmpty() || expassword.isEmpty()) {
                request.setAttribute("flashMessageFaild", "please complete email field.");
                response.sendRedirect("/dashboard");
//                this.getServletContext().getRequestDispatcher(isCenter?"/index.jsp":"/jsp/adminDashBoard.jsp").forward(request,response);

            } else {
                //validation email
                String error = "";
                error += validationField(email, "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[a-z]{2,6}$", "email is invalid");

                if (!error.equals("")) {

                    request.setAttribute("flashMessageFaild", error);
                    response.sendRedirect("/dashboard");
//                    this.getServletContext().getRequestDispatcher(isCenter?"/index.jsp":"/jsp/adminDashBoard.jsp").forward(request,response);
                } else {
                    System.out.println("no error");
                    if (!centreDao.searchCentreByEmail(email)) {

                        request.setAttribute("flashMessageFaild", "Error deleting centre, Wrong mail.");
//                        request.setAttribute("flashMessageFaild", "Error updating centre");
                        System.out.println("wrong mail");
                        response.sendRedirect("/dashboard");

//                        this.getServletContext().getRequestDispatcher(isCenter?"/index.jsp":"/jsp/adminDashBoard.jsp").forward(request,response);
                    } else {
                        if (admin.getPasswordAdmin().equals(expassword)) {
                            centreDao.deleteCentreByEmail(email);
                            request.setAttribute("flashMessageSuccess", "Centre id deleted.");
                            response.sendRedirect("/dashboard");
//                       this.getServletContext().getRequestDispatcher(isCenter?"/index.jsp":"/jsp/adminDashBoard.jsp").forward(request,response);
                        }
                    }
                }
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/dashboard");
    }

    private String validationField(String field, String pattern, String erreur) {
        if (field.matches(pattern)) {
            return "";
        } else {
            return erreur;
        }
    }
}
