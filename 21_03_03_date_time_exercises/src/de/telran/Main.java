package de.telran;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {

        LocalDate localdate = LocalDate.of(2008, Month.DECEMBER, 6);
        System.out.println(localdate);
        System.out.println(localdate.getDayOfWeek());
        System.out.println(localdate.getDayOfYear());

        LocalDate myNextBirthday = LocalDate.of(2021, Month.DECEMBER, 6);
        LocalDate today = LocalDate.now();

        System.out.println("My next birthday is on " + myNextBirthday);
        System.out.println("Today is " + today);

        BiFunction<LocalDate, LocalDate, String> compareDates = (birthday, date) -> {
            String str = "";
            if (birthday.isAfter(date)){
                str = " days later this date";
            } else {
                str = " days before this date";
            }
            return ("Your birthday this year is " + Math.abs(birthday.getDayOfYear() - date.getDayOfYear()) + str);
        };

        System.out.println(compareDates.apply(myNextBirthday, today));

        System.out.println(compareDates.apply(myNextBirthday.minusMonths(10), today));

        System.out.println(today.lengthOfYear() - today.getDayOfYear() + " days till New Year");

    }

/*    public int intersectWorkingTime(LocalTime start1, int hours, ZoneId zone1, LocalTime start2, int hours2, ZoneId zone2){

    }*/
}
