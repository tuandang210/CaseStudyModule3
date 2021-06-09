package com.codegym.DAO.service;

import com.codegym.DAO.IGeneralDAO;
import com.codegym.model.ServiceDB;

import java.util.List;

public interface IServiceDB_DAO extends IGeneralDAO<ServiceDB> {
    public List<Integer> selectAllID();
}
