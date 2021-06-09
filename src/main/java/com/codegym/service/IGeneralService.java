package com.codegym.service;

import java.sql.SQLException;
import java.util.List;

public interface IGeneralService<T>{
    List<T> findAll();
    T findById(int id) throws SQLException;
    boolean create(T t) throws SQLException;
    boolean update(int id, T t) throws SQLException;
    boolean delete(int id) throws SQLException;
}
