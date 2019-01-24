package Helper;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class ContactForm implements Runnable {

    private String name;
    private String subject;
    private String email;
    private String msg;

    public ContactForm(String name, String subject, String email, String msg) {
        this.name = name;
        this.subject = subject;
        this.email = email;
        this.msg = msg;
    }

    public void send() {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("boum.abderrahim", "boum@hdi98");
                    }
                });

        try {

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("boum.abderrahim@gmail.com"));
            message.setSubject(subject);

            message.setText("From: " + name + "<br>" + "Email: " + email + "<br>" + msg,"utf-8", "html");

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        send();
    }
}