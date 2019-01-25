package Controllers.Event;

import DAO.DAOFactory;
import DAO.Interfaces.EvenementDao;
import Helper.Utile;
import Models.Centre;
import Models.Evenement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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
    public static final int TAILLE_TAMPON = 1024 * 1024 * 10;

    @Override
    public void init() throws ServletException {
        super.init();
        daoFactory = DAOFactory.getInstance();
        evenementDao = daoFactory.getEvenementImpl();

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("centre") == null) {
            response.sendRedirect("/login.jsp");
        } else {


            // verification si les camps si sont vide

            String titreEvent = request.getParameter("title");

            String descEvent = request.getParameter("description");

            String dateString = request.getParameter("date");

            Part part = request.getPart("imgInput");

            String fileName = Utile.extractFileName(part);

            if (titreEvent.trim().isEmpty() || descEvent.trim().isEmpty() || dateString.trim().isEmpty() || fileName.trim().isEmpty() || fileName == null) {
                request.setAttribute("flashMessageFaild", "Please complete all fields.");
                returnFormulaireAddEvent(request, response);
            } else {
                System.out.println(fileName);
                String error = "";
                error = validationChamp(fileName, "[^\\s]+(\\.(?i)(jpg|png|gif|bmp))$", "Please choose file with (.png, .jpg, .gif, .bmp) extension.");

                if (error != "") {
                    request.setAttribute("flashMessageFaild", error);
                } else {

                    if (!fileName.isEmpty() && fileName != null) {
                        ecrireFichier(part, fileName, "C:\\Users\\ABDERRAHIM\\IdeaProjects\\JEE2019_Groupe4-3\\web\\img");
                    }


                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                    Date date = null;

                    try {
                        date = sdf.parse(dateString);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    Timestamp tm = new Timestamp(date.getTime());


                    if (titreEvent.trim().isEmpty() || descEvent.trim().isEmpty()) {
                        this.getServletContext().getRequestDispatcher("/jsp/agenda.jsp").forward(request, response);
                    } else {
                        Evenement event = new Evenement();
                        event.setTitreEvenement(titreEvent);
                        event.setDateEvenement(tm);
                        event.setDesciptionEvenement(descEvent);
                        event.setImagePathEvenement("\\img\\" + fileName);
                        Centre centre = (Centre) session.getAttribute("centre");
                        event.setIdCentre(centre.getIdCentre());
                        event.setIdVille(centre.getIdVille());

                        if (evenementDao.insertEvenement(event) == true) {
                            boolean isInserted = true;
                            request.setAttribute("flashMessageSuccess", "Event has been added.");
                            this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                        } else {
                            boolean isInserted = false;
                            request.setAttribute("flashMessageFaild", "Error adding event.");
                            this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                        }

                    }

                }


            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("centre") == null) {
            response.sendRedirect("/login");
        } else {

            this.getServletContext().getRequestDispatcher("/jsp/agenda.jsp").forward(request, response);
        }

    }

    private void ecrireFichier(Part part, String nomFichier, String chemin) throws IOException {

        /* Prépare les flux. */

        BufferedInputStream entree = null;

        BufferedOutputStream sortie = null;

        try {

            /* Ouvre les flux. */

            entree = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON);

            sortie = new BufferedOutputStream(new FileOutputStream(new File(chemin + "\\" + nomFichier)),

                    TAILLE_TAMPON);

            byte[] tampon = new byte[TAILLE_TAMPON];

            int longueur;

            while ((longueur = entree.read(tampon)) > 0) {

                sortie.write(tampon, 0, longueur);

            }

        } finally {

            try {

                sortie.close();

            } catch (IOException ignore) {

            }

            try {

                entree.close();

            } catch (IOException ignore) {

            }

        }

    }


    private String validationChamp(String field, String pattern, String erreur) {
        if (!field.matches(pattern)) {
            return erreur;
        }
        return "";
    }

    private void returnFormulaireAddEvent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String oldTitle = request.getParameter("title");
        request.setAttribute("oldTitle", oldTitle);
        String oldDescription = request.getParameter("description");
        request.setAttribute("oldDescription", oldDescription);
        String oldDate = request.getParameter("date");
        request.setAttribute("oldDate", oldDate);

        this.getServletContext().getRequestDispatcher("/jsp/agenda.jsp").forward(request, response);
    }
}
