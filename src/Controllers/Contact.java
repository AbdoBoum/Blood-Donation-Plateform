package Controllers;

import Helper.ContactForm;

import javax.mail.MessagingException;
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
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String subject = request.getParameter("subject");
        String msg = request.getParameter("message");
        String emailBody = "";

        ContactForm javaEmail;

        if (!name.trim().equals("") && !email.trim().equals("") && !subject.trim().equals("") && !msg.trim().equals("")) {

            javaEmail = new ContactForm();
            javaEmail.setMailServerProperties();
            emailBody = "Sender Name: " + name
                    + "<br>" + "Sender Email: " + email
                    + "<br>" + "Subject: " + subject
                    + "<br>" + "Message: " + msg
                    + "<br>";

            try {
                javaEmail.createEmailMessage(subject, emailBody);
                javaEmail.sendEmail();
                status = "success";
                message = "Email sent Successfully!";
            } catch (MessagingException me) {
                status = "error";
                message = "Error in Sending Email!";
            }
            request.setAttribute("status", status);
            request.setAttribute("message", message);
            this.getServletContext().getRequestDispatcher("/jsp/contactUs.jsp").forward(request, response);
        }else {
            status = "error";
            message = "Please complete all fields";
            request.setAttribute("status", status);
            request.setAttribute("message", message);
            this.getServletContext().getRequestDispatcher("/jsp/contactUs.jsp").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/jsp/contactUs.jsp").forward(request, response);
    }
}
