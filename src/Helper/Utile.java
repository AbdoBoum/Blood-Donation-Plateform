package Helper;

import DAO.DAOFactory;
import DAO.Interfaces.CentreDao;
import DAO.Interfaces.GroupSangDao;
import DAO.Interfaces.VilleDao;
import Models.*;

import javax.servlet.http.Part;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

public class Utile {

    public static final String SUCCESS_MSG = "succes";
    public static final String FAILURE_MSG = "failure";
    public static final String EMPTY_FIELD = "empty.";
    public static final String[] bloodDonationQuotes = {"Don’t let mosquitoes get your blood first.",
            "Blood is a life, pass it on!", "The blood is red gold in time of saving a life.",
            "Heroes come in all types and sizes.", "Be a blood donor, be a Hero – A real one.",
            "There is no great joy than saving a soul.", "A bottle of blood saved my life, was it yours.",
            "Blood can circulate forever if you keep donating it."};


    public static String stringToSha256(String base) {
        try{
            base = "@lorem!^$" + base + "@ipsum77";
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            //System.out.println("Hash : " + hexString.toString());
            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
    public static Ville getVilleByName(List<Ville> list, String vil){
        for (Ville ville : list){
            if(ville.getNomVille().equals(vil))
                return ville;
        }
        return null;
    }

    public static GroupSang getGroupeByName(List<GroupSang> list, String grp){
        for (GroupSang groupe : list){
            if(groupe.getNameGroupe().equals(grp))
                return groupe;
        }
        return null;
    }

    public static String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");

        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

    public static String createMessageFromDemand(Demande demande){
        String message = "New blood request have been added, ";
        if(demande.isUrgent()){
            message+="and it's urgent, ";
        }
        DAOFactory daoFactory = DAOFactory.getInstance();
        CentreDao centreDao = daoFactory.getCentreDaoImpl();
        GroupSangDao groupSangDao = daoFactory.getGroupSangDaoImpl();
        Centre centre = centreDao.getCentre(demande.getIdCentre());
        message+="centre : "+centre.getNameCentre()+", Address : "+centre.getAdresseCentre();
        message+=", blood groups : ";
        for(ConcerneDemande concerneDemande : demande.getSangGroups()){
            message+=""+groupSangDao.getGroupSang(concerneDemande.getIdGroupeSang()).getNameGroupe()+";";
        }
        message = message.substring(0,message.length()-1)+".";
        return message;
    }

    public static RequestPagination createRequestClass(Demande demande){
        DAOFactory daoFactory = DAOFactory.getInstance();
        GroupSangDao groupSangDao = daoFactory.getGroupSangDaoImpl();
        VilleDao villeDao = daoFactory.getVilleDaoImpl();
        CentreDao centreDao = daoFactory.getCentreDaoImpl();

        RequestPagination requestPagination = new RequestPagination();
        requestPagination.setTitleRequest(demande.getTitleDemande());
        requestPagination.setDateRequest(demande.getDateDemande());
        requestPagination.setPathImgRequest(demande.getPathImgDemande());
        requestPagination.setIdRequest(demande.getIdDemande());
        requestPagination.setUrgent(demande.isUrgent());
        requestPagination.setIdCentre(demande.getIdCentre());
        requestPagination.setDescriptionRequest(demande.getDescriptionDemande());
        Centre centre = centreDao.getCentre(demande.getIdCentre());
        requestPagination.setNameVilleRequest(centre.getAdresseCentre()+", "+villeDao.getVilleById(demande.getIdVilleDemande()).getNomVille());
        requestPagination.setCenterName(centre.getNameCentre());
        String s ="";
        for(ConcerneDemande concerneDemande : demande.getSangGroups()){
            s+=groupSangDao.getGroupSang(concerneDemande.getIdGroupeSang()).getNameGroupe()+" ;";
        }
        requestPagination.setSangGroups(s.substring(0,s.length()-1));
        return requestPagination;
    }
}
