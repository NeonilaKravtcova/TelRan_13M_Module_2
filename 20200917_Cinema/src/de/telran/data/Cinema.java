package de.telran.data;

import java.time.LocalDate;

public class Cinema {
    private String name;
    private Address address;

    //Конструктор 1
    public Cinema(String name) {
        this.name = name;
    }

    //Конструктор 2
    public Cinema(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cinema)) return false;

        Cinema cinema = (Cinema) o;

        if (!getName().equals(cinema.getName())) return false;
        return getAddress().equals(cinema.getAddress());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getAddress().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "\"" + name + '\"' +
                ", " + address.getStreetName() + ", " + address.getHouseNumber();
    }

    public static boolean cinemaCheck(Cinema[] cinemas, String name){
        for (Cinema i: cinemas){
            if (i.name.equalsIgnoreCase(name)){
                return true;
            }
        }
        return false;
    }
}

