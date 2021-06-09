package com.codegym.service;

import com.codegym.model.RentalPerson;

import java.util.List;

public interface IRentalPersonService {

    List<RentalPerson> selectAll();

    RentalPerson select(int id);

    boolean create(RentalPerson rental);

    boolean update(int id, RentalPerson rental);

    boolean delete(int id);

    List<RentalPerson> findRentalByName(String name);

    List<RentalPerson> sort(String category, String type);
    public List<Integer> selectAllID();
}
