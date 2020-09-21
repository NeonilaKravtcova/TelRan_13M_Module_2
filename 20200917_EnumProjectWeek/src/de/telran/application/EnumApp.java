package de.telran.application;
import de.telran.data.WeekDays;
import de.telran.data.Schedule;

    public class EnumApp {
        public static void main(String[] args) {
            WeekDays[] days = {WeekDays.MONDAY, WeekDays.TUESDAY, WeekDays.WEDNESDAY, WeekDays.THURSDAY, WeekDays.FRIDAY, WeekDays.SATURDAY, WeekDays.SUNDAY};

            Schedule schedule = new Schedule(days);
            schedule.wakeUpWeek();
            schedule.displayWeekMenu();
        }
}
