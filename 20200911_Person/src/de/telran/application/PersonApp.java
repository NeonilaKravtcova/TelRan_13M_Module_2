package de.telran.application;

import de.telran.data.Person;

public class PersonApp {

    public static void main(String[] args) {
        Person person1 = new Person("Vasya", 25);
        person1.setName("Vasiliy");
        Person person2 = new Person("Alex", 24);
        Person person3 = new Person("Katya", 21);
        Person person4 = new Person("Maria Antoinetta", 23);

        Person[] people = {person1, person2, person3, person4};

        Person.outPrint(people);

        Person.findOldestPerson(people);

        Person.findLongestNamePerson(people);

    }

}
