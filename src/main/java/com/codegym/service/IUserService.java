package com.codegym.service;

import com.codegym.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService extends IGeneralService<User> {
    List<User> findAllCustomerByAddress(String address);

    List<User> sortAllCustomer();

    boolean changePasswordById(int id) throws SQLException;

    String forgotPassword(String userName, String phone) throws SQLException;
}
