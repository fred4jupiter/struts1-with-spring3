package com.oc.strutswithspring.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "CONTACT_ID")
    private List<Contact> contacts = new ArrayList<>();

    public Employee() {
    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public Long getId() {
        return id;
    }

    public void addContact(Contact contact) {
        this.contacts.add(contact);
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
