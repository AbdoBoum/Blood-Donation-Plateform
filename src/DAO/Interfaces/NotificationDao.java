package DAO.Interfaces;

import Models.Notification;

import java.util.List;

public interface NotificationDao {

    /* insert a Notification*/
    public Notification insertNotification(Notification notification);

    /* fetch a Notification by id*/
    public Notification fetchNotificationById(int idDonnateur, int idDemande);

    /* fetch all Notifications*/
    public List<Notification> getAllNotifications();

    /* update a Notification: set status to viewed */
    public Notification updateNotification(Notification notification);

    /* delete  a Notification
    public void deleteNotification(int idNotification);*/
}
