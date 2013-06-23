package com.oc.strutswithspring.service;

import java.util.List;


import com.oc.strutswithspring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oc.strutswithspring.domain.Employee;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void updateEmployees(List<Employee> employees) {
        employeeRepository.save(employees);
    }

}
