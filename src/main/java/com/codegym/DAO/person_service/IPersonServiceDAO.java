package com.codegym.DAO.person_service;

import com.codegym.DAO.IGeneralDAO;
import com.codegym.model.PersonService;

import java.sql.SQLException;

public interface IPersonServiceDAO extends IGeneralDAO<PersonService> {
    public boolean delete(int service_id,int person_id) throws SQLException;
    public PersonService select(int service_id,int person_id) throws SQLException;
    public boolean update(int service_id,int person_id, PersonService personService) throws SQLException;

}
