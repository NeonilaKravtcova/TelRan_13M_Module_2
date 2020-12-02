package de.telran;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Address address;

    public Person(String name, Address address){
        this.name =name;
        this.address = address;
    }

    @Override
    public String toString() {
        return name + ", " + address.toString();
    }

    public static List<Address> getAddresses(List<Person> persons){
        List<Address> returnList = new ArrayList<>();
        for (Person person : persons) {
            returnList.add(person.address);
        }
        return returnList;
    }
}
