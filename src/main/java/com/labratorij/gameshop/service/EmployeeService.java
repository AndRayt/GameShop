package com.labratorij.gameshop.service;

import com.labratorij.gameshop.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    void add(EmployeeEntity client);
    void edit(EmployeeEntity employee, int id);
    void delete(int id);
    EmployeeEntity get(int id);
    List<EmployeeEntity> getAll();
}
