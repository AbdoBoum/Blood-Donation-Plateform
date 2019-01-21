package Helper;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class ContactForm {

    Properties emailProperties;
    Session mailSession;
    MimeMessage emailMessage;

    String emailHost = "smtp.gmail.com";
    String emailPort = "587"; // SMTP port
    String fromUser = "gmail email here"; // your gmail id
    String fromUserEmailPassword = "password here";
    String[] toEmails = { "abderrahim_boumahdi@hotmail.com" };

    public void setMailServerProperties() {
        emailProperties = System.getProperties();
        emailProperties.put("mail.smtp.port", emailPort);
        emailProperties.put("mail.smtp.auth", "true");
        emailProperties.put("mail.smtp.starttls.enable", "true");
    }

    public void createEmailMessage(String emailSubject, String emailBody)
            throws AddressException, MessagingException {
        mailSession = Session.getDefaultInstance(emailProperties, null);
        emailMessage = new MimeMessage(mailSession);
        for (int i = 0; i < toEmails.length; i++) {
            emailMessage.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(toEmails[i]));
        }
        emailMessage.setSubject(emailSubject);
        emailMessage.setContent(emailBody, "text/html");// for a html email
        // emailMessage.setText(emailBody);// for a text email

    }

    public void sendEmail() throws AddressException, MessagingException {
        Transport transport = mailSession.getTransport("smtp");
        transport.connect(emailHost, fromUser, fromUserEmailPassword);
        transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
        transport.close();
    }


}
