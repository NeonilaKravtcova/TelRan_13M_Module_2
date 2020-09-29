package de.telran.data;

public class Schedule {
    private DayOfWeek dayOfWeek;
    //Сделать массив
    //переделать wakeUp
    //переделать menu - чтобы выводилось на все дни недели

    public Schedule(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public void wakeUp() {
        if (getDayOfWeek() == DayOfWeek.SATURDAY || getDayOfWeek() == DayOfWeek.SUNDAY) {
            System.out.println("You can sleep longer..");
        } else {
            System.out.println("Wake up!");
        }
    }

    public void getMenu() {
        switch (dayOfWeek) {
            case MONDAY:
                System.out.println("Spaghetti");
                break;
            case TUESDAY:
                System.out.println("Pizza");
                break;
            case WEDNESDAY:
                System.out.println("Chicken");
                break;
            case THURSDAY:
                System.out.println("Fish&Cheaps");
                break;
            case FRIDAY:
                System.out.println("Burger");
                break;
            case SATURDAY:
                System.out.println("Olivie");
                break;
            case SUNDAY:
                System.out.println("Soup");
                break;
        }
    }
}
