package com.oc.strutswithspring.domain;

public class Contact {
    private String label;
    private String phoneNumber;

    public Contact() {
    }

    public Contact(String label, String phoneNumber) {
        this.label = label;
        this.phoneNumber = phoneNumber;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
