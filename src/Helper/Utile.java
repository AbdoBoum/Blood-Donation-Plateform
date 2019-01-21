package Helper;

import Models.GroupSang;
import Models.Ville;

import javax.servlet.http.Part;
import java.security.MessageDigest;
import java.util.List;

public class Utile {

    public static final String SUCCESS_MSG = "succes";
    public static final String FAILURE_MSG = "failure";
    public static final String EMPTY_FIELD = "empty.";


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
}
