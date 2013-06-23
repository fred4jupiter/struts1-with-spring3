package com.oc.strutswithspring.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.oc.strutswithspring.domain.Contact;
import com.oc.strutswithspring.domain.Employee;

@Component
public class InMemoryEmployeeDaoImpl implements EmployeeDao {

    private static List<Employee> employees;

    static {
        List<Contact> contacts = new ArrayList<>(2);
        contacts.add(new Contact("phone1", "999-123-5678"));
        contacts.add(new Contact("cell", "999-345-4557"));

        List<Contact> contacts2 = new ArrayList<>(2);
        contacts2.add(new Contact("phone1", "888-222-4444"));
        contacts2.add(new Contact("mobile", "222-111-3333"));

        List<Contact> contacts3 = new ArrayList<>(2);
        contacts3.add(new Contact("pager", "999-333-8888"));
        contacts3.add(new Contact("cell", "999-111-6666"));

        employees = new ArrayList<>();
        employees.add(new Employee(1, "John", "Doe", contacts));
        employees.add(new Employee(2, "Bob", "Smith", contacts2));
        employees.add(new Employee(3, "Sue", "Boe", contacts3));
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public void updateEmployees(List<Employee> emps) {
        employees = emps;
    }

}
