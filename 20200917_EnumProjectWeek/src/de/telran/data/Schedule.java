package de.telran.data;

public class Schedule {
    private DayOfWeek[] days;

    public Schedule(DayOfWeek[] days) {
        this.days = days;
    }

    public void wakeUp(DayOfWeek day) {
            if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY /*|| day.ordinal() >= 5*/) {
                System.out.println(day.getTitle() + " - you can sleep longer..");
            } else {
                System.out.println(day.getTitle() + " - wake up!");
            }
        System.out.println();
    }

    public void displayTodayMenu(DayOfWeek day) {
            System.out.println(day.getTitle() + " - " + day.getCourse());
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
