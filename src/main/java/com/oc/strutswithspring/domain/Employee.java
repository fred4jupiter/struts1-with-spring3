package com.oc.strutswithspring.domain;

import java.io.Serializable;
import java.util.List;

public class Employee implements Serializable {

    private static final long serialVersionUID = -6698286968829292053L;
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private List<Contact> contacts;

    public Employee() {
    }

    public Employee(Integer employeeId, String firstName, String lastName, List<Contact> contacts) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contacts = contacts;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
