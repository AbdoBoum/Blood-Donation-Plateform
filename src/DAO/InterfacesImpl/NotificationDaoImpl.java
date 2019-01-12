package DAO.InterfacesImpl;

import DAO.DAOFactory;
import DAO.Interfaces.NotificationDao;
import Models.Notification;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NotificationDaoImpl implements NotificationDao {

    private DAOFactory daoFactory;

    public NotificationDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Notification insertNotification(Notification notification) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("insert into Notification values (?, ?, ?, ?)");
            preparedStatement.setInt(1, notification.getIdDonnateur());
            preparedStatement.setInt(2, notification.getIdDemande());
            preparedStatement.setString(3, notification.getDescriptionNotification());
            preparedStatement.setBoolean(4, notification.isViewed());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return notification;
    }

    @Override
    public Notification fetchNotificationById(int idDonnateur, int idDemande) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Notification notification;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM  notification where id_donnateur = ? and id_demande = ?");
            preparedStatement.setInt(1, idDonnateur);
            preparedStatement.setInt(2, idDemande);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                notification = new Notification();
                notification.setIdDonnateur(resultSet.getInt(1));
                notification.setIdDemande(resultSet.getInt(2));
                notification.setDescriptionNotification(resultSet.getString(3));
                notification.setViewed(resultSet.getBoolean(4));
                return notification;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public List<Notification> getAllNotifications() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Notification notification;
        List<Notification> notifications = new ArrayList<Notification>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM  notification");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                notification = new Notification();
                notification.setIdDonnateur(resultSet.getInt(1));
                notification.setIdDemande(resultSet.getInt(2));
                notification.setDescriptionNotification(resultSet.getString(3));
                notification.setViewed(resultSet.getBoolean(4));
                notifications.add(notification);
            }
            return notifications;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Notification updateNotification(Notification notification) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            /* etablish the connection and update the notification*/
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE Notification set is_viewed = ? where id_donnateur = ? and id_demande = ?");
            preparedStatement.setInt(1, notification.getIdDonnateur());
            preparedStatement.setInt(2,notification.getIdDemande());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return notification;
    }

    /*@Override
    public void deleteNotification(int idNotification) {}*/
}
