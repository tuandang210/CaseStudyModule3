package com.codegym.service;

import com.codegym.model.PersonService;

import java.sql.SQLException;

public interface IServiceOfPersonService extends IGeneralService<PersonService>{
    public PersonService findById(int service_id,int person_id) throws SQLException;
    public boolean delete(int service_id,int person_id) throws SQLException;

}
