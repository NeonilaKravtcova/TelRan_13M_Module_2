package de.telran.data;

public class WeekDay {
    private String titleOfDay;

    //Если у нас публичный конструктор, то мы не контролируем названия дней
/*    public static void main(String[] args){
        WeekDay monday = new WeekDay("monday");
        System.out.println();
    }*/

    //Поэтому конструктор объявляется приватным
    public WeekDay (String titleOfDay){
        this.titleOfDay = titleOfDay;
    }

    //И создаются защищённым образом дни недели, которые нельзя поменять
    public final static WeekDay MONDAY = new WeekDay("monday");
    public final static WeekDay TUESDAY = new WeekDay("tuesday");
    public final static WeekDay WEDNESDAY = new WeekDay("wednesday");
    public final static WeekDay THURSDAY = new WeekDay("thursday");
    public final static WeekDay FRIDAY = new WeekDay("friday");
    public final static WeekDay SATURDAY = new WeekDay("saturday");
    public final static WeekDay SUNDAY = new WeekDay("sunday");

    @Override
    public String toString() {
        return "WeekDay: " +
                titleOfDay;
    }

}
