package com.codegym.service;

import com.codegym.DAO.service.IServiceDB_DAO;
import com.codegym.DAO.service.ServiceDB_DAO;
import com.codegym.model.ServiceDB;

import java.sql.SQLException;
import java.util.List;

public class ServiceOfService implements IServiceOfService{
    IServiceDB_DAO serviceDB_dao = new ServiceDB_DAO();
    @Override
    public List<ServiceDB> findAll() {
        try {
            return serviceDB_dao.selectAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public ServiceDB findById(int id) throws SQLException {
        return serviceDB_dao.select(id);
    }

    @Override
    public boolean create(ServiceDB serviceDB) throws SQLException {
        return serviceDB_dao.create(serviceDB);
    }

    @Override
    public boolean update(int id, ServiceDB serviceDB) throws SQLException {
        return serviceDB_dao.update(id,serviceDB);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return serviceDB_dao.delete(id);
    }

    @Override
    public List<Integer> selectAllID() {
        return serviceDB_dao.selectAllID();
    }
}
