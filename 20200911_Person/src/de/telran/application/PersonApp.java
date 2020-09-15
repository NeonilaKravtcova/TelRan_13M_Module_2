package de.telran.application;

import de.telran.data.Person;

public class PersonApp {

    public static void main(String[] args) {
        Person person1 = new Person("Vasya", 25, 178);
        person1.setName("Vasiliy");
        Person person2 = new Person("Alex", 24, 182);
        Person person3 = new Person("Katya", 21, 168);
        Person person4 = new Person("Maria Antoinette", 23, 164);
        //Person person5 = new Person("Alex", 24, 182);//для проверки работы equals
        Person person5 = new Person("Alex", 28, 175);

        Person[] people = {person1, person2, person3, person4, person5};

        //System.out.println(person2 == person5);//-> false - так как одинаковые объекты лежат в разных местах

        //System.out.println(person2.equals(person5));//-> будет true (так как объекты идентичны) при условии,
        // что мы переопределили метод equals так, (@Override)
        // что он будет сравнивать сами объекты.
        // Если мы не переопределяем сами метод equals,
        // то будет false, так как он изначально будет сравнивать ссылки

        // Если мы переопределяем equals, то должны переопределить и hashcode. Если нам не нужно сравнивать объекты,
        // то можем вообще не переопределять эти два метода.

        /*int a = 2;
        int b = 2;
        boolean c = a == b;
        System.out.println(c);*/

        Person.outPrint(people);

        Person.findOldestPerson(people);

        Person.findLongestNamePerson(people);

        Person.sortPersonsByAge(people);

        Person.outPrint(people);

        Person.sortPersonsByAge2(people);

        Person.outPrint(people);

        Person.sortPersonsByNames(people);

        Person.outPrint(people);

        Person.sortPersonsByHeight(people);

        Person.outPrint(people);

        Person.sortPersonsByHeight2(people);

        Person.outPrint(people);

    }

}
