package com.codegym.DAO.typeService;

import com.codegym.DAO.SQLConnection;
import com.codegym.model.TypeService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TypeServiceDAO implements ITypeServiceDAO {
    private static final String INSERT_NEW_TYPE_SERVICE = "insert into type_service(type_name) value (?)";
    private static final String SELECT_ALL_TYPE_SERVICE = "select * from type_service";
    private static final String DELETE_TYPE_SERVICE = "call DELETE_TYPE_SERVICE(?)";
    private static final String UPDATE_TYPE_SERVICE = "update type_service set type_name = ? where type_id = ?";
    private static final String SELECT_TYPE_SERVICE = "select * from type_service where type_id=?";
    private Connection connection = SQLConnection.getConnection();
    private int newRow;

    @Override
    public boolean create(TypeService typeService) throws SQLException {
        connection = SQLConnection.getConnection();
        newRow = 0;
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_TYPE_SERVICE);
        preparedStatement.setString(1, typeService.getName());
        newRow = preparedStatement.executeUpdate();
        return newRow != 0;
    }

    @Override
    public TypeService select(int id) throws SQLException {
        connection = SQLConnection.getConnection();
        TypeService typeService = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TYPE_SERVICE);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int type_id = resultSet.getInt("type_id");
                String type_name = resultSet.getString("type_name");
                typeService = new TypeService(type_id, type_name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeService;

    }

    @Override
    public List<TypeService> selectAll() {
        List<TypeService> list = new ArrayList<>();
        connection = SQLConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TYPE_SERVICE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int type_id = resultSet.getInt("type_id");
                String type_name = resultSet.getString("type_name");
                list.add(new TypeService(type_id, type_name));
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
        CallableStatement callableStatement = connection.prepareCall(DELETE_TYPE_SERVICE);
        callableStatement.setInt(1, id);
        newRow = callableStatement.executeUpdate();
        return newRow != 0;
    }

    @Override
    public boolean update(int id, TypeService typeService) throws SQLException {
        newRow = 0;
        Connection connection = SQLConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TYPE_SERVICE);
        preparedStatement.setString(1, typeService.getName());
        preparedStatement.setInt(2, typeService.getId());
        newRow = preparedStatement.executeUpdate();
        return newRow != 0;
    }
}
