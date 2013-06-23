package com.oc.strutswithspring.service;

import java.util.List;

import com.oc.strutswithspring.domain.Employee;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    void updateEmployees(List<Employee> employees);
}
