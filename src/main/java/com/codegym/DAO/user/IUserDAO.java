package com.codegym.DAO.user;
import com.codegym.DAO.IGeneralDAO;
import com.codegym.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO extends IGeneralDAO<User> {
    boolean changePasswordById(int id) throws SQLException;
    String forgotPassword(String userName,String phone) throws SQLException;
}
