package com.oc.strutswithspring.repository;

import com.oc.strutswithspring.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
