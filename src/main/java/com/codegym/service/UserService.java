package com.codegym.service;

import com.codegym.DAO.user.IUserDAO;
import com.codegym.DAO.user.UserDAO;
import com.codegym.model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

public class UserService implements IUserService {
    private final IUserDAO userDAO = new UserDAO();

    @Override
    public List<User> findAll() {
        try {
            return userDAO.selectAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public User findById(int id) throws SQLException {
        return userDAO.select(id);
    }

    @Override
    public boolean create(User user) throws SQLException {
        if (checkUser(user)) {
            return userDAO.create(user);
        } else {
            return false;
        }
    }

    private boolean checkUser(User user) {
        return Pattern.matches("^[0-9a-zA-Z]{6,20}$", user.getPassWord());
    }

    @Override
    public boolean update(int id, User user) throws SQLException {
        return userDAO.update(id, user);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return userDAO.delete(id);
    }

    @Override
    public List<User> findAllCustomerByAddress(String address) {
        return null;
    }

    @Override
    public List<User> sortAllCustomer() {
        return null;
    }

    @Override
    public boolean changePasswordById(int id) throws SQLException {
        return userDAO.changePasswordById(id);
    }
    @Override
    public String forgotPassword(String userName,String phone) throws SQLException {
        return userDAO.forgotPassword( userName, phone);
    }
}
