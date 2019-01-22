package Controllers;

import Helper.ContactForm;

//import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ContactUs")
public class Contact extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String message = null;
        String status = null;
        if (request.getParameter("submit") != null) {
            ContactForm javaEmail = new ContactForm();
          //  javaEmail.setMailServerProperties();
            String emailSubject = "";
            String emailBody = "";

            if (request.getParameter("name") != null) {
                emailBody = "Sender Name: " + request.getParameter("name")
                        + "<br>";
            }
            if (request.getParameter("email") != null) {
                emailBody = emailBody + "Sender Email: "
                        + request.getParameter("email") + "<br>";
            }
            if (request.getParameter("message") != null) {
                emailBody = emailBody + "Message: " + request.getParameter("message")
                        + "<br>";
            }

        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/jsp/contactUs.jsp").forward(request, response);
    }
}
