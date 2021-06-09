package com.codegym.service;

import com.codegym.DAO.login.LoginDAO;

import java.sql.SQLException;

public class LoginService {
    private final LoginDAO loginDAO = new LoginDAO();


    public int loginService(String userName, String passWord) throws SQLException {
        return loginDAO.checkLogin(userName,passWord);
    }
}
