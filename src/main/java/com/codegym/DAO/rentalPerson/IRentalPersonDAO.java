package com.codegym.DAO.rentalPerson;

import com.codegym.DAO.IGeneralDAO;
import com.codegym.model.RentalPerson;

import java.sql.SQLException;
import java.util.List;

public interface IRentalPersonDAO extends IGeneralDAO<RentalPerson> {
    List<RentalPerson> findRentalByName(String name) throws SQLException;

    List<RentalPerson> sort(String category, String type) throws SQLException;
    public List<Integer> selectAllID();

}
