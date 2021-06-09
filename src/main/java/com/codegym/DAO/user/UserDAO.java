package com.codegym.DAO.user;

import com.codegym.DAO.SQLConnection;
import com.codegym.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    private Connection connection = SQLConnection.getConnection();
    private int rowInserted = 0;

    @Override
    public boolean create(User user) throws SQLException {
        connection = SQLConnection.getConnection();
        String INSERT_USER = "insert into usermanager.user (username, password, gender, phone, level) VALUE (?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER);
        preparedStatement.setString(1, user.getUserName());
        preparedStatement.setString(2, user.getPassWord());
        preparedStatement.setString(3, user.getGender());
        preparedStatement.setString(4, user.getPhone());
        preparedStatement.setInt(5, user.getLevel());
        rowInserted = preparedStatement.executeUpdate();
        return rowInserted != 0;
    }

    @Override
    public User select(int id) throws SQLException {
        connection = SQLConnection.getConnection();
        User user = null;
        String SELECT_BY_ID = "select * from usermanager.user where userId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String gender = resultSet.getString("gender");
            String phone = resultSet.getString("phone");
            int level = resultSet.getInt("level");
            user = new User(id, username, password, gender, phone, level);
        }
        return user;
    }

    @Override
    public String forgotPassword(String userName,String phone) throws SQLException {
        connection = SQLConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select password from usermanager.user where username = ? and phone = ?");
        preparedStatement.setString(1,userName);
        preparedStatement.setString(2,phone);
        ResultSet resultSet = preparedStatement.executeQuery();
        String password = "";
        while (resultSet.next()){
             password = resultSet.getString("password");
        }
        return password;
    }

    @Override
    public List<User> selectAll() {
        List<User> list = new ArrayList<>();
        connection = SQLConnection.getConnection();
        try {
            String SELECT_ALL_USER = "select * from usermanager.user";
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int userId = resultSet.getInt("userId");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String gender = resultSet.getString("gender");
                String phone = resultSet.getString("phone");
                int level = resultSet.getInt("level");
                list.add(new User(userId, username, password, gender, phone, level));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        rowInserted = 0;
        String DELETE_USER = "{call deleteUser(?)}";
        CallableStatement preparedStatements = connection.prepareCall(DELETE_USER);
        preparedStatements.setInt(1, id);
        rowInserted = preparedStatements.executeUpdate();
        return rowInserted != 0;
    }

    @Override
    public boolean update(int id, User user) throws SQLException {
        rowInserted = 0;
        try {
            String UPDATE_USER = "update usermanager.user set username = ?,password = ?,gender = ?,phone = ?,level = ? where userId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassWord());
            preparedStatement.setString(3, user.getGender());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setInt(5, user.getLevel());
            preparedStatement.setInt(6, id);
            rowInserted = preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return rowInserted != 0;
    }

    @Override
    public boolean changePasswordById(int id) throws SQLException {
        rowInserted = 0;

        String CHANGE_PW = "delete from usermanager.user where userId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(CHANGE_PW);
        preparedStatement.setInt(1, id);
        rowInserted = preparedStatement.executeUpdate();
        return rowInserted != 0;
    }
}