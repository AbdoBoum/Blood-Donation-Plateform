package DAO.InterfacesImpl;

import DAO.DAOFactory;
import DAO.Interfaces.GroupSangDao;
import Models.GroupSang;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GroupSangDaoImpl implements GroupSangDao {
    private DAOFactory daoFactory ;

    public GroupSangDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public GroupSang getGroupSang(int idGrp) {
        String query = "SELECT * FROM groupesang WHERE id_groupe='"+idGrp+"'";
        try {
            Connection connection = daoFactory.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                GroupSang groupSang = new GroupSang();
                groupSang.setIdGroupe(resultSet.getInt("id_groupe"));
                groupSang.setNameGroupe(resultSet.getString("nom_groupe"));
                return  groupSang;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<GroupSang> getAllGroups() {
        String query = "SELECT * FROM groupesang";
        try {
            Connection connection = daoFactory.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<GroupSang> groupSangList = new ArrayList<>();
            while(resultSet.next()){
                GroupSang groupSang = new GroupSang();
                groupSang.setIdGroupe(resultSet.getInt("id_groupe"));
                groupSang.setNameGroupe(resultSet.getString("nom_groupe"));
                groupSangList.add(groupSang);
            }
            return groupSangList;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
