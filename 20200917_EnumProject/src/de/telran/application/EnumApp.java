package de.telran.application;

import de.telran.data.DayOfWeek;
import de.telran.data.Menu;
import de.telran.data.Schedule;
import de.telran.data.ScheduleForWeek;

public class EnumApp {
    public static void main(String[] args) {
/*        WeekDay weekDay = WeekDay.MONDAY;
        System.out.println(weekDay);

        DayOfWeek monday = DayOfWeek.MONDAY;
        System.out.println(monday);
        System.out.println(DayOfWeek.FRIDAY.ordinal());//порядковый номер в массиве объектов
        System.out.println(Arrays.toString(DayOfWeek.values()));//все объекты массива
        System.out.println(monday.toString());
        System.out.println(DayOfWeek.FRIDAY.getTitle());
        DayOfWeek.FRIDAY.sayHello();
        monday.sayHello();

        Schedule schedule = new Schedule(monday);
        schedule.wakeUp();

        schedule.getMenu();

        Schedule[] schedules = {new Schedule(DayOfWeek.MONDAY), new Schedule(DayOfWeek.TUESDAY), new Schedule(DayOfWeek.WEDNESDAY)};
        for (Schedule i : schedules) {
            i.getMenu();
        }*/

        DayOfWeek[] days = {DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY, DayOfWeek.SUNDAY};

        Menu[] menu = {Menu.MO, Menu.TU, Menu.WE, Menu.TH, Menu.FR, Menu.SA, Menu.SU};

        ScheduleForWeek scheduleForWeek = new ScheduleForWeek(days, menu);
        scheduleForWeek.wakeUpWeek();
        scheduleForWeek.displayWeekMenu();
    }

}
