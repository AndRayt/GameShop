package com.labratorij.gameshop.service.Impl;

import com.labratorij.gameshop.entity.EmployeeEntity;
import com.labratorij.gameshop.repository.EmployeeRepository;
import com.labratorij.gameshop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public void add(EmployeeEntity client) {
        employeeRepository.saveAndFlush(client);
    }

    public void edit(EmployeeEntity employee_temp, int id) {
        EmployeeEntity employee = employeeRepository.getOne(id);
        employee.setName(employee_temp.getName());
        employee.setPassport(employee_temp.getPassport());
        employee.setAdress(employee_temp.getAdress());
        employee.setTelephone(employee_temp.getTelephone());
        employee.setOrdersByEmployeeId(employee_temp.getOrdersByEmployeeId());
        employeeRepository.save(employee);
    }

    public void delete(int id) {
        employeeRepository.delete(id);
    }

    public EmployeeEntity get(int id) {
        return employeeRepository.getOne(id);
    }

    public List<EmployeeEntity> getAll() {
        return employeeRepository.findAll();
    }
}
