package de.telran;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Comparator<Human> humanComparator = new peopleComparator();

        Human vasya = new Human(true, 170);
        Human petya = new Human(false, 169);
        Human tonya = new Human(true, 25);

        int comparison = humanComparator.compare(vasya, petya);
        if (comparison < 0){
            System.out.println("Petya will be first");
        } else if (comparison > 0) {
            System.out.println("Vasya will be first");
        } else {
            System.out.println("No matter who will be the first");
        }

        //how to use comparators in Java
        //not sorted list
        List<Human> humans = Arrays.asList(vasya, petya, tonya);
        //straight sort
        Collections.sort(humans, humanComparator);//(petya, tonya, vasya)
        System.out.println(humans);

        Collections.sort(humans, humanComparator.reversed());//(petya, tonya, vasya)
        System.out.println(humans);

        //Можно отсортировать сразу сам List
        //humans.sort(humanComparator);
        //humans.sort(humanComparator.reversed());
    }
}

    class Human {
        boolean isMedicalPersonal;
        int age;

        public Human(boolean isMedicalPersonal, int age) {
            this.isMedicalPersonal = isMedicalPersonal;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Human{" +
                    "isMedicalPersonal=" + isMedicalPersonal +
                    ", age=" + age +
                    '}';
        }
    }

    /**
     * The comparator determines a rule for comparing of two persons as follows:
     * medical personal has more priority than other people, then the most priority has the older person
     */

    class peopleComparator implements Comparator<Human> {
        @Override
        public int compare(Human h1, Human h2) {
            if (h1.isMedicalPersonal && h2.isMedicalPersonal ||
                    !h1.isMedicalPersonal && !h2.isMedicalPersonal) {
                return h1.age - h2.age;
            }
            if (h1.isMedicalPersonal) {
                return 1;
            } else {
                return -1;
            }
        }
    }
