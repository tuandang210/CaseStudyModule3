package com.codegym.DAO.person_service;

import com.codegym.DAO.SQLConnection;
import com.codegym.model.PersonService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonServiceDAO implements IPersonServiceDAO {
    private static final String INSERT_NEW_PERSON_SERVICE = "insert into person_service(service_id,person_id) value (?,?)";
    private static final String SELECT_ALL_PERSON_SERVICE = "select * from person_service order by person_id";
    private static final String DELETE_PERSON_SERVICE = "delete from person_service where service_id = ? && person_id = ?";
    private static final String UPDATE_PERSON_SERVICE = "update person_service set service_id = ?  where person_id = ?";
    private static final String SELECT_PERSON_SERVICE = "select * from person_service where service_id = ? && person_id = ?";
    private Connection connection ;
    private int newRow;


    @Override
    public boolean create(com.codegym.model.PersonService personService) throws SQLException {
        newRow = 0;
        connection = SQLConnection.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_PERSON_SERVICE);
        preparedStatement.setInt(1, personService.getService_id());
        preparedStatement.setInt(2, personService.getPerson_id());
        newRow = preparedStatement.executeUpdate();
        return newRow != 0;
    }

    @Override
    public List<PersonService> selectAll() throws SQLException {
        List<PersonService> list = new ArrayList<>();
        connection = SQLConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PERSON_SERVICE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int service_id = resultSet.getInt("service_id");
                int person_id = resultSet.getInt("person_id");
                list.add(new PersonService(service_id, person_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public PersonService select(int service_id, int person_id) throws SQLException {
        PersonService personService = null;
        connection = SQLConnection.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PERSON_SERVICE);
            preparedStatement.setInt(1, service_id);
            preparedStatement.setInt(2, person_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int service = resultSet.getInt("server_id");
                int person = resultSet.getInt("person_id");
                personService = new PersonService(service, person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personService;
    }

    @Override
    public boolean update(int service_id, int person_id, PersonService personService) throws SQLException {
        return false;
    }


    @Override
    public boolean update(int id, PersonService personService) throws SQLException {
        newRow = 0;
        connection = SQLConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PERSON_SERVICE);
        preparedStatement.setInt(1, personService.getService_id());
        preparedStatement.setInt(2, id);
        newRow = preparedStatement.executeUpdate();
        return newRow != 0;
    }

    @Override
    public boolean delete(int service_id, int person_id) throws SQLException {
        connection = SQLConnection.getConnection();
        newRow = 0;
        PreparedStatement preparedStatement = connection.prepareCall(DELETE_PERSON_SERVICE);
        preparedStatement.setInt(1, service_id);
        preparedStatement.setInt(2, person_id);
        newRow = preparedStatement.executeUpdate();

        return newRow != 0;
    }










    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }
    @Override
    public com.codegym.model.PersonService select(int id) throws SQLException {
        return null;
    }
}
