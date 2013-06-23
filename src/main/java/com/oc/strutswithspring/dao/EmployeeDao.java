package com.oc.strutswithspring.dao;

import java.util.List;

import com.oc.strutswithspring.domain.Employee;

public interface EmployeeDao {
    List<Employee> getAllEmployees();

    void updateEmployees(List<Employee> employees);
}
