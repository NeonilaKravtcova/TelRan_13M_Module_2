package de.telran.contacts.entity;

public class Contact {

    private int id;
    private String name;
    private String lastName;
    private String phoneNumber;

    public Contact(int id, String name, String lastName, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public Contact() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}