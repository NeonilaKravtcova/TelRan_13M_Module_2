package de.telran.data;

import java.util.Date;
import java.util.Objects;

public class Person {
    private String firstName;
    private String lastName;
    private int birthDay;
    private String address;
    private Sex sex;

    public Person(String firstName, String lastName, int birthDay, String address, Sex sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.address = address;
        this.sex = sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public String getAddress() {
        return address;
    }

    public Sex getSex() {
        return sex;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (getBirthDay() != person.getBirthDay()) return false;
        if (!getFirstName().equals(person.getFirstName())) return false;
        if (!getLastName().equals(person.getLastName())) return false;
        if (!getAddress().equals(person.getAddress())) return false;
        return getSex() == person.getSex();
    }

    @Override
    public int hashCode() {
        int result = getFirstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        result = 31 * result + getBirthDay();
        result = 31 * result + getAddress().hashCode();
        result = 31 * result + getSex().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Client: " +
                firstName +
                " " + lastName + '\'' +
                ", birthDay: " + birthDay +
                ", address: " + address +
                ", sex: " + sex;
    }

    public String toStringName(){
        return "Client: " + firstName + " " + lastName;
    }

    public static void toStringNameNew(Person[] people){
        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i].toStringName());
        }
        System.out.println();
    }
}
