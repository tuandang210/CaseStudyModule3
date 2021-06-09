package com.codegym.DAO.login;

import com.codegym.DAO.SQLConnection;
import com.codegym.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    public int checkLogin(String userName1,String passWord1) throws SQLException {
        Connection connection = SQLConnection.getConnection();
        int isCheck = -1;
        String SELECT_BY_USERNAME = "select userId,password from usermanager.user where username = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_USERNAME);
        preparedStatement.setString(1, userName1);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String password = resultSet.getString("password");
            int userId = resultSet.getInt("userId");
            if (password.equals(passWord1)){
                isCheck = userId;
            }
        }
        return isCheck;
    }
}
