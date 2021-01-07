package de.telran;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

public class ComparatorTest {

    Comparator<Car> comparator = new CarsComparator();



    @Test
    public void testSameYearsOfManufactureAndSameDistance() {
        Car car1 = new Car("Mercedec", 2010, 20000);
        Car car2 = new Car("Volkswagen", 2010, 20000);
        assertTrue(comparator.compare(car1, car2) == 0);
    }

    @Test
    public void testSameYearsOfManufactureAndCar1DistanceIsLonger() {
        Car car1 = new Car("Mercedec", 2010, 30000);
        Car car2 = new Car("Volkswagen", 2010, 20000);
        assertTrue(comparator.compare(car1, car2) < 0);
    }

    @Test
    public void testSameYearsOfManufactureAndCar2DistanceIsLonger() {
        Car car1 = new Car("Mercedec", 2010, 20000);
        Car car2 = new Car("Volkswagen", 2010, 30000);
        assertFalse(comparator.compare(car1, car2) < 0);
    }

    @Test
    public void testSameDistanceAndCar1YearOfManufactureIsEarlier() {
        Car car1 = new Car("Mercedec", 2005, 20000);
        Car car2 = new Car("Volkswagen", 2010, 20000);
        assertTrue(comparator.compare(car1, car2) < 0);
    }

    @Test
    public void testSameDistanceAndCar2YearOfManufactureIsEarlier() {
        Car car1 = new Car("Mercedec", 2010, 20000);
        Car car2 = new Car("Volkswagen", 2005, 20000);
        assertTrue(comparator.compare(car1, car2) > 0);
    }

}
