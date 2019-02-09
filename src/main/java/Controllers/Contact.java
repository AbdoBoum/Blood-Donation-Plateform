package Controllers;

import Helper.ContactForm;
import Helper.Utile;

//import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ContactUs")
public class Contact extends HttpServlet {

    String isInserted;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String message = request.getParameter("message");
        String subject = request.getParameter("subject");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        if (!message.isEmpty() && !subject.isEmpty() && !name.isEmpty() && !email.isEmpty()){
            Runnable contact = new ContactForm(name, subject, email, message);
            Thread thread = new Thread(contact);
            thread.start();
            isInserted = Utile.SUCCESS_MSG;
            request.setAttribute("isInserted", isInserted);
            this.getServletContext().getRequestDispatcher("/jsp/contactUs.jsp").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/jsp/contactUs.jsp").forward(request, response);
    }
}
