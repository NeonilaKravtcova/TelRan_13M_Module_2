package de.telran;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Comparator<Car> comparator = new CarsComparator();

        Car car1 = new Car("Mercedec", 2010, 20000);
        Car car2 = new Car("Volkswagen", 2005, 20000);


        if (comparator.compare(car1, car2) > 0) {
            System.out.println(car1.toString() + " is a better deal than " + car2.toString());
        } else if (comparator.compare(car1, car2) < 0) {
            System.out.println(car2.toString() + " is a better deal than " + car1.toString());
        } else {
            System.out.println("Both cars worth their money");
        }
    }
}

class Car {
    String name;
    int yearOfManufacture;
    int distance;

    public Car(String name, int yearOfManufacture, int distance) {
        this.name = name;
        this.yearOfManufacture = yearOfManufacture;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return name + " (" + yearOfManufacture + ", " +
                distance + " km)";
    }
}

class CarsComparator implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {
        if (car1.distance == car2.distance) {
            if (car1.yearOfManufacture > car2.yearOfManufacture) {
                return 1;
            } else if (car1.yearOfManufacture < car2.yearOfManufacture) {
                return -1;
            }
        }
/*        if (car1.distance < car2.distance){
            return 1;
        } else if (car1.distance > car2.distance){
            return -1;
        }
        else return 0;*/
        return Integer.compare(car2.distance, car1.distance);
    }
}


