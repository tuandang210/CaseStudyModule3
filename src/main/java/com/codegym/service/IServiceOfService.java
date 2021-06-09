package com.codegym.service;

import com.codegym.model.ServiceDB;

import java.util.List;

public interface IServiceOfService extends IGeneralService<ServiceDB>{
    public List<Integer> selectAllID();

}
