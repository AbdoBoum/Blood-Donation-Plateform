package Helper;

import Models.ConcerneDemande;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class RequestPagination {
    private int idRequest;
    private Timestamp dateRequest;
    private String descriptionRequest;
    private String pathImgRequest;
    private boolean isUrgent;
    private String sangGroups ;
    private String titleRequest;
    private String centerName;
    private String nameVilleRequest;

    public int getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(int idRequest) {
        this.idRequest = idRequest;
    }

    public Timestamp getDateRequest() {
        return dateRequest;
    }

    public void setDateRequest(Timestamp dateRequest) {
        this.dateRequest = dateRequest;
    }

    public String getDescriptionRequest() {
        return descriptionRequest;
    }

    public void setDescriptionRequest(String descriptionRequest) {
        this.descriptionRequest = descriptionRequest;
    }

    public String getPathImgRequest() {
        return pathImgRequest;
    }

    public void setPathImgRequest(String pathImgRequest) {
        this.pathImgRequest = pathImgRequest;
    }

    public boolean isUrgent() {
        return isUrgent;
    }

    public void setUrgent(boolean urgent) {
        isUrgent = urgent;
    }

    public String getSangGroups() {
        return sangGroups;
    }

    public void setSangGroups(String sangGroups) {
        this.sangGroups = sangGroups;
    }

    public String getTitleRequest() {
        return titleRequest;
    }

    public void setTitleRequest(String titleRequest) {
        this.titleRequest = titleRequest;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getNameVilleRequest() {
        return nameVilleRequest;
    }

    public void setNameVilleRequest(String nameVilleRequest) {
        this.nameVilleRequest = nameVilleRequest;
    }
}
