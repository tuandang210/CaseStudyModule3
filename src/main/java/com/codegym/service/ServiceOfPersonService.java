package com.codegym.service;

import com.codegym.DAO.person_service.IPersonServiceDAO;
import com.codegym.DAO.person_service.PersonServiceDAO;
import com.codegym.model.PersonService;

import java.sql.SQLException;
import java.util.List;

public class ServiceOfPersonService implements IServiceOfPersonService{
    IPersonServiceDAO personServiceDAO = new PersonServiceDAO();
    @Override
    public List<PersonService> findAll() {
        try {
            return personServiceDAO.selectAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }return null;
    }

    @Override
    public boolean create(PersonService personService) throws SQLException {
        return personServiceDAO.create(personService);
    }


    @Override
    public boolean update(int id, PersonService personService) throws SQLException {
        return personServiceDAO.update(id,personService);
    }

    @Override
    public PersonService findById(int service_id, int person_id) throws SQLException {
        return personServiceDAO.select(service_id,person_id);
    }

    @Override
    public boolean delete(int service_id, int person_id) throws SQLException {
        return personServiceDAO.delete(service_id,person_id);
    }


//    ---------
    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }
    @Override
    public PersonService findById(int id) throws SQLException {
        return null;
    }


}
