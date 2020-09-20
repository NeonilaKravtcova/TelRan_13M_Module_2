package de.telran.data;

public class ScheduleForWeek {
    private DayOfWeek[] days;
    private Menu[] menu;

    public ScheduleForWeek(DayOfWeek[] days, Menu[] menu) {
        this.days = days;
        this.menu = menu;
    }

    public void wakeUpWeek() {
        for (DayOfWeek day : days) {
            if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {
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
            System.out.println(days[i].getTitle() + " - " + menu[i].getMenu());
        }
        System.out.println("\nBon appetit!");
    }
}
