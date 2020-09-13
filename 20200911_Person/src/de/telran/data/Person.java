package de.telran.data;

import java.util.Arrays;
import java.util.Comparator;

public class Person {
    private String name;
    private int age;

    //Конструктор
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        //В этом методе можем сделать защиту от неправильных данных
        if (age > 0 && age < 110) {
            this.age = age;
        } else {
            System.out.println("Wrong age!");
        }
    }

    @Override
    public String toString() {
        return "Name: " + name +
                ", age " + age + "\n";
    }

    public static void outPrint(Person[] array) {
        for (Person i : array) {
            System.out.print(i);
        }
        System.out.println();
    }

    //public - так как будем использовать метод не внутри класса
    //static - так как будем перебирать группу людей
    public static void findOldestPerson(Person[] array) {
        Arrays.sort(array, Comparator.comparing(Person::getAge));
        System.out.println("The oldest person is " + array[array.length - 1].getName() + ", he is "
                + array[array.length - 1].getAge() + " years old. \n");
    }

    public static void findLongestNamePerson(Person[] array) {
        Person temp;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].getName().length() > array[i + 1].getName().length()) {
                temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
            }
        }
        System.out.println("A person with the longest name is " + array[array.length - 1].getName() + ", "
                + array[array.length - 1].getAge() + " years old.");
    }
}
