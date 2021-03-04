package de.telran;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {

        LocalDate now = LocalDate.now();
        System.out.println(now);

        LocalDate tomorrow = now.plus(Period.ofDays(1));
        System.out.println(tomorrow);

        tomorrow = now.plusDays(1);
        System.out.println(tomorrow);

        tomorrow = now.plus(1, ChronoUnit.DAYS);
        System.out.println(tomorrow);

        System.out.println("Today is " + now.getDayOfWeek() + " day of week");

        System.out.println(now.isAfter(tomorrow));

        System.out.println(System.currentTimeMillis());

        //System.out.println(now.toEpochSecond(LocalTime.now(), ZoneOffset.ofHours(2)));

        //LocalTime
        LocalTime currentTime = LocalTime.now();
        LocalTime nextHour = currentTime.plus(Duration.ofHours(1));
        System.out.println(nextHour);
        nextHour = currentTime.plus(1, ChronoUnit.HOURS);
        System.out.println(nextHour);
        nextHour = currentTime.plusHours(1);
        System.out.println(nextHour);
        System.out.println(currentTime.isBefore(nextHour));

        //LocalDateTime
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime fromDateAndTime = LocalDateTime.of(now, currentTime);
        LocalDateTime parsed = LocalDateTime.parse("2021-03-02T22:18:56");
        System.out.println(today);
        System.out.println(parsed);

        System.out.println(parsed.getDayOfWeek());
        System.out.println(parsed.get(ChronoField.DAY_OF_YEAR));
        System.out.println(parsed.get(ChronoField.ALIGNED_WEEK_OF_YEAR));

        //with
        LocalDateTime yearAgo = today.with(ChronoField.YEAR, 2020);
        System.out.println("Year ago: " + yearAgo);

        //ZonedDateTime
        System.out.println(ZoneId.getAvailableZoneIds());
        ZonedDateTime minskMorning = ZonedDateTime.of(LocalDateTime.of(2021, Month.MARCH, 2, 6, 0),
                ZoneId.of("Europe/Minsk"));

        System.out.println(minskMorning);
        ZonedDateTime moscowMorning = minskMorning.withZoneSameInstant(ZoneId.of("Asia/Vladivostok"));//IMPORTANTE
        System.out.println(moscowMorning);
        ZonedDateTime sameTimeOtherZone = minskMorning.withZoneSameLocal(ZoneId.of("Asia/Vladivostok"));//IMPORTANTE
        System.out.println(sameTimeOtherZone);

        //Differences between times/dates etc
        //for dates
        Period period = Period.between(now, tomorrow);
        System.out.println(period);
        System.out.println(period.getDays());

    }
}
