package com.codegym.DAO.rentalPerson;

import com.codegym.DAO.SQLConnection;

import com.codegym.model.RentalPerson;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RentalPersonDAO implements IRentalPersonDAO {


    public static final String SELECT_ALL_RENTAL_PEOPLE = "select * from personrental";
    public static final String SELECT_RENTAL_PERSON_BY_ID = "select * from personrental where personId = ?";
    public static final String INSERT_RENTAL_PERSON = "insert into personrental(name, age, gender, status, phone, urlImg) values (?,?,?,?,?,?)";
    public static final String UPDATE_RENTAL_PERSON_BY_ID = "update personrental set name = ?, age = ?, gender = ?, status = ?, phone = ?, urlImg = ? where personId = ?";
    public static final String DELETE_RENTAL_PERSON_BY_ID = "Call deleteRentalPerson(?)";
    public static final String SORT_RENTAL = "select * from personrental order by";
    private static final String SELECT_ALL_ID = "select personId from personrental";


    @Override
    public List<RentalPerson> selectAll() throws SQLException {
        Connection connection = SQLConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_RENTAL_PEOPLE);
        ResultSet rs = preparedStatement.executeQuery();
        return convertResultSetToList(rs);
    }

    @Override
    public RentalPerson select(int selectedId) throws SQLException {
        RentalPerson rental = null;
        Connection connection = SQLConnection.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RENTAL_PERSON_BY_ID);
        preparedStatement.setInt(1, selectedId);
        ResultSet rs = preparedStatement.executeQuery();

        return convertResultSetToList(rs).get(0);
    }


    @Override
    public boolean create(RentalPerson rentalPerson) throws SQLException {
        int insertedRow = 0;
        Connection connection = SQLConnection.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RENTAL_PERSON);
        preparedStatement.setString(1, rentalPerson.getName());
        preparedStatement.setInt(2, rentalPerson.getAge());
        preparedStatement.setString(3, rentalPerson.getGender());
        preparedStatement.setBoolean(4, rentalPerson.isStatus());
        preparedStatement.setString(5, rentalPerson.getPhone());
        preparedStatement.setString(6, rentalPerson.getUrlImage());

        insertedRow = preparedStatement.executeUpdate();
        return insertedRow != 0;
    }



    @Override
    public boolean delete(int id) throws SQLException {
        int deletedRow;
        Connection connection = SQLConnection.getConnection();
        CallableStatement callableStatement = connection.prepareCall(DELETE_RENTAL_PERSON_BY_ID);
        callableStatement.setInt(1, id);

        deletedRow = callableStatement.executeUpdate();
        return deletedRow != 0;
    }

    @Override
    public boolean update(int id, RentalPerson rentalPerson) throws SQLException {
        int updatedRow;
        Connection connection = SQLConnection.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_RENTAL_PERSON_BY_ID);
        preparedStatement.setString(1, rentalPerson.getName());
        preparedStatement.setInt(2, rentalPerson.getAge());
        preparedStatement.setString(3, rentalPerson.getGender());
        preparedStatement.setBoolean(4, rentalPerson.isStatus());
        preparedStatement.setString(5, rentalPerson.getPhone());
        preparedStatement.setString(6, rentalPerson.getUrlImage());
        preparedStatement.setInt(7, rentalPerson.getId());

        updatedRow = preparedStatement.executeUpdate();

        return updatedRow != 0;
    }

    @Override
    public List<RentalPerson> findRentalByName(String inputName) throws SQLException {
        Connection connection = SQLConnection.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("select * from personrental where name like ?");
        preparedStatement.setString(1, "%"+inputName+"%");

        ResultSet rs = preparedStatement.executeQuery();
        return convertResultSetToList(rs);
    }

    @Override
    public List<RentalPerson> sort(String category, String type) throws SQLException {
        Connection connection = SQLConnection.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(SORT_RENTAL+" "+category+" "+type);
        ResultSet rs = preparedStatement.executeQuery();

        return convertResultSetToList(rs);
    }

    @Override
    public List<Integer> selectAllID() {
        Connection connection = SQLConnection.getConnection();
        List<Integer> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int personId = resultSet.getInt("personId");
                list.add(personId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }




    private List<RentalPerson> convertResultSetToList(ResultSet rs) throws SQLException {
        List<RentalPerson> rentals = new ArrayList<>();
        while (rs.next()){
            int id = rs.getInt("personId");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String gender = rs.getString("gender");
            boolean status = rs.getBoolean("status");
            String phone = rs.getString("phone");
            String urlImage = rs.getString("urlImg");
            rentals.add(new RentalPerson(id, name, age, gender, status, phone, urlImage));
        }
        return rentals;
    }
}
