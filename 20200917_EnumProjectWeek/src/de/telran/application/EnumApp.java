package de.telran.application;
import de.telran.data.DayOfWeek;
import de.telran.data.Schedule;

    public class EnumApp {
        public static void main(String[] args) {
            //DayOfWeek[] days = {DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY, DayOfWeek.SUNDAY};
            //Schedule schedule = new Schedule(days); - заменим эти две строки на строку 10
            
            Schedule schedule = new Schedule(DayOfWeek.value());//Метод, который возвращает массив объектов enum 
            schedule.wakeUp(DayOfWeek.THURSDAY);
            schedule.wakeUp(DayOfWeek.SUNDAY);
            schedule.displayTodayMenu(DayOfWeek.MONDAY);
            schedule.displayTodayMenu(DayOfWeek.SATURDAY);
            schedule.displayWeekMenu();
        }
}
