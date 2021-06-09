package com.codegym.DAO.service;

import com.codegym.DAO.SQLConnection;
import com.codegym.model.ServiceDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceDB_DAO implements IServiceDB_DAO{
    private static final String INSERT_NEW_SERVICE = "insert into service(service_name,type_id) value (?,?)";
    private static final String SELECT_ALL_SERVICE = "select * from service";
    private static final String DELETE_SERVICE = "delete from service where server_id = ?";
    private static final String UPDATE_SERVICE = "update service set service_name = ?,type_id = ?  where server_id = ?";
    private static final String SELECT_SERVICE = "select * from service where server_id=?";
    private static final String SELECT_ALL_ID = "select server_id from service";
    private Connection connection = SQLConnection.getConnection();
    private int newRow;

    @Override
    public boolean create(ServiceDB serviceDB) throws SQLException {
        connection = SQLConnection.getConnection();
        newRow = 0;
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_SERVICE);
        preparedStatement.setString(1, serviceDB.getName());
        preparedStatement.setInt(2, serviceDB.getType());
        newRow = preparedStatement.executeUpdate();
        return newRow != 0;
    }

    @Override
    public ServiceDB select(int id) throws SQLException {
        connection = SQLConnection.getConnection();
        ServiceDB serviceDB = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SERVICE);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int service_id = resultSet.getInt("server_id");
                String service_name = resultSet.getString("service_name");
                int type_id = resultSet.getInt("type_id");

                 serviceDB = new ServiceDB(service_id, service_name , type_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceDB;

    }

    @Override
    public List<ServiceDB> selectAll() {
        List<ServiceDB> list = new ArrayList<>();
        connection = SQLConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int service_id = resultSet.getInt("server_id");
                String service_name = resultSet.getString("service_name");
                int type_id = resultSet.getInt("type_id");

                list.add(new ServiceDB(service_id, service_name,type_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        connection = SQLConnection.getConnection();
        newRow = 0;
        CallableStatement callableStatement = connection.prepareCall(DELETE_SERVICE);
        callableStatement.setInt(1, id);
        newRow = callableStatement.executeUpdate();

        return newRow != 0;
    }

    @Override
    public boolean update(int id, ServiceDB serviceDB) throws SQLException {
        newRow = 0;
        Connection connection = SQLConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SERVICE);
        preparedStatement.setString(1, serviceDB.getName());
        preparedStatement.setInt(2, serviceDB.getType());
        preparedStatement.setInt(3, serviceDB.getId());
        newRow = preparedStatement.executeUpdate();
        return newRow != 0;
    }

    @Override
    public List<Integer> selectAllID() {
        List<Integer> list = new ArrayList<>();
        connection = SQLConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int service_id = resultSet.getInt("server_id");
                list.add(service_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
