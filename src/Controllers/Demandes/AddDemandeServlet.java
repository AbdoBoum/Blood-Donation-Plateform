package Controllers.Demandes;

import Controllers.Blog.AddBlog;
import DAO.DAOFactory;
import DAO.Interfaces.CentreDao;
import DAO.Interfaces.DemandeDao;
import DAO.Interfaces.GroupSangDao;
import DAO.Interfaces.VilleDao;
import Helper.Utile;
import Models.*;

import javax.rmi.CORBA.Util;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)
public class AddDemandeServlet extends HttpServlet {
    private DemandeDao demandeDao;
    private CentreDao centreDao;
    private VilleDao villeDao;
    private GroupSangDao groupSangDao;
    private DAOFactory daoFactory;
    private List<Ville> villes;
    private List<GroupSang> groupSangList;
    private String isInserted;

    @Override
    public void init() throws ServletException {
        super.init();
        daoFactory = DAOFactory.getInstance();
        demandeDao = daoFactory.getDemandeDaoImpl();
        villeDao = daoFactory.getVilleDaoImpl();
        groupSangDao = daoFactory.getGroupSangDaoImpl();
        centreDao = daoFactory.getCentreDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("titleInput");
        String description = request.getParameter("description");
        Ville ville = Utile.getVilleByName(villes,request.getParameter("villeSelect"));
        String isUrgent = request.getParameter("urgentSelect");
        String[] grps = request.getParameterValues("groupSangSelect");


        Part part = request.getPart("inputFile");

        System.out.println(grps[0]+" grps "+grps[1]);
        System.out.println(part.getSize()+" part");
        System.out.println(title+" title");

        if(title.isEmpty() || description.isEmpty() || part.getSize()==0 || grps ==null || grps.length == 0){
            isInserted = Utile.EMPTY_FIELD;
        }else{
            Demande demande = new Demande();
            Centre centre = (Centre)request.getSession().getAttribute("centre");
            demande.setIdCentre(centre.getIdCentre());
            demande.setDateDemande(new Timestamp(System.currentTimeMillis()));
            demande.setDescriptionDemande(description);
            demande.setActive(true);
            demande.setUrgent(isUrgent.equals("No") ? false : true);
            List<ConcerneDemande> concerneDemandeList = new ArrayList<>();
            for(String concerneD : grps){
                ConcerneDemande concerneDemande = new ConcerneDemande();
                concerneDemande.setIdGroupeSang(Utile.getGroupeByName(groupSangList,concerneD).getIdGroupe());
                concerneDemandeList.add(concerneDemande);
            }
            demande.setSangGroups(concerneDemandeList);
            String fileName = Utile.extractFileName(part);
            String savePath = "F:\\JEE2019_Groupe4-3\\web\\img\\" + File.separator + fileName;

            File fileSaveDirectory = new File(savePath);

            part.write(savePath + File.separator);
            demande.setPathImgDemande(savePath);

            if(demandeDao.addDemande(demande)){
                isInserted = Utile.SUCCESS_MSG;
            }else{
                isInserted = Utile.FAILURE_MSG;
            }

        }
        request.setAttribute("isInserted", isInserted);
        request.setAttribute("villes",villes);
        request.setAttribute("groupSangList",groupSangList);
        this.getServletContext().getRequestDispatcher("/jsp/addDemande.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Centre centre = centreDao.getCentre(1);
        villes = villeDao.getAllVille();
        groupSangList = groupSangDao.getAllGroups();
        if(centre != null) {
            HttpSession session = request.getSession();
            session.setAttribute("centre", centre);
        }
        request.setAttribute("villes",villes);
        request.setAttribute("groupSangList",groupSangList);
        this.getServletContext().getRequestDispatcher("/jsp/addDemande.jsp").forward(request, response);
    }
}
