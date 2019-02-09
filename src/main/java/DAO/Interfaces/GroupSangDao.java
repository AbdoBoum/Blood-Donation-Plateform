package DAO.Interfaces;

import Models.GroupSang;

import java.util.List;

public interface GroupSangDao {
    GroupSang getGroupSang(int idGrp);
    List<GroupSang> getAllGroups();
}
