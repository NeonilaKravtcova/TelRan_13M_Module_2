package de.telran.data;

public class Schedule {
    private WeekDays[] days;

    public Schedule(WeekDays[] days) {
        this.days = days;
    }

    public void wakeUpWeek() {
        for (WeekDays day : days) {
            if (day == WeekDays.SATURDAY || day == WeekDays.SUNDAY) {
                System.out.println(day.getTitle() + " - you can sleep longer..");
            } else {
                System.out.println(day.getTitle() + " - wake up!");
            }
        }
        System.out.println();
    }

    public void displayWeekMenu() {
        System.out.println("------------------");
        System.out.println("Menu for this week");
        System.out.println("------------------");
        for (int i = 0; i < days.length; i++) {
            System.out.println(days[i].getTitle() + " - " + days[i].getCourse());
        }
        System.out.println("\nBon appetit!");
    }
}
