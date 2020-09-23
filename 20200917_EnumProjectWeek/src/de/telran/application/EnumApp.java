package de.telran.application;
import de.telran.data.DayOfWeek;
import de.telran.data.Schedule;

    public class EnumApp {
        public static void main(String[] args) {
            DayOfWeek[] days = {DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY, DayOfWeek.SUNDAY};

            Schedule schedule = new Schedule(days);
            schedule.wakeUp(DayOfWeek.TUESDAY);
            schedule.wakeUp(DayOfWeek.SUNDAY);
            schedule.displayTodayMenu(DayOfWeek.MONDAY);
            schedule.displayTodayMenu(DayOfWeek.SATURDAY);
            schedule.displayWeekMenu();
        }
}
