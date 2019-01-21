package Controllers;

import DAO.DAOFactory;
import DAO.Interfaces.EvenementDao;
import Models.Evenement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet(name = "AddEvent")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)
public class AddEvent extends HttpServlet {

    private DAOFactory daoFactory;
    private EvenementDao evenementDao;
    public static final int TAILLE_TAMPON=1024*1024*10;

    @Override
    public void init()throws ServletException{
        super.init();
        daoFactory=DAOFactory.getInstance();
        evenementDao=daoFactory.getEvenementImpl();

    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String titreEvent = request.getParameter("title");

        String descEvent = request.getParameter("description");

        String dateString = request.getParameter("date");

        System.out.println(titreEvent+"  "+dateString+"  "+descEvent);

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

        Date date= null;

        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Timestamp tm=new Timestamp(date.getTime());

        Part part = request.getPart("imgInput");
        String fileName = extractFileName(part);

        System.out.println(fileName);
        if(!fileName.isEmpty() && fileName!=null){
            ecrireFichier(part,fileName,"F:\\Projet\\Blood_Donation\\web\\img");
        }


        if (titreEvent.trim().isEmpty() || descEvent.trim().isEmpty() ) {
            this.getServletContext().getRequestDispatcher("/jsp/AddEvent.jsp").forward(request, response);
        }
        else {
            Evenement event=new Evenement();
            event.setTitreEvenement(titreEvent);
            event.setDateEvenement(tm);
            event.setDesciptionEvenement(descEvent);
            event.setImagePathEvenement("\\img\\"+fileName);
            event.setIdCentre(1);
            event.setIdVille(1);

            if (evenementDao.insertEvenement(event)== true) {
                boolean isInserted = true;
                request.setAttribute("isInserted", isInserted);
//                this.getServletContext().getRequestDispatcher("/jsp/AffEvent.jsp").forward(request, response);
                response.sendRedirect("affEvent");
            }
            else {
                boolean isInserted = false;
                request.setAttribute("isInserted", isInserted);
                this.getServletContext().getRequestDispatcher("/jsp/AddEvent.jsp").forward(request, response);
            }

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/jsp/AddEvent.jsp").forward(request,response);

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

    private void ecrireFichier( Part part, String nomFichier, String chemin ) throws IOException {

        /* Prépare les flux. */

        BufferedInputStream entree = null;

        BufferedOutputStream sortie = null;

        try {

            /* Ouvre les flux. */

            entree = new BufferedInputStream( part.getInputStream(), TAILLE_TAMPON );

            sortie = new BufferedOutputStream( new FileOutputStream( new File( chemin +"\\"+ nomFichier ) ),

                    TAILLE_TAMPON );

            byte[] tampon = new byte[TAILLE_TAMPON];

            int longueur;

            while ( ( longueur = entree.read( tampon ) ) > 0 ) {

                sortie.write( tampon, 0, longueur );

            }

        } finally {

            try {

                sortie.close();

            } catch ( IOException ignore ) {

            }

            try {

                entree.close();

            } catch ( IOException ignore ) {

            }

        }

    }
}
