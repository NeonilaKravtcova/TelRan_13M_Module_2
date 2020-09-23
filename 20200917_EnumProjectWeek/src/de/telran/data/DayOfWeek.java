package de.telran.data;

public enum DayOfWeek {
    MONDAY("MO", "Spaghetti"),
    TUESDAY("TU", "Pizza"),
    WEDNESDAY("WE", "Chicken"),
    THURSDAY("TH", "Fish&Cheaps"),
    FRIDAY("FR", "Burger"),
    SATURDAY("SA", "Olivie"),
    SUNDAY("SU", "Lasagna");

    private String title;
    private String course;

    DayOfWeek(String title, String course) {
        this.title = title;
        this.course = course;
    }

    public String getTitle() {
        return title;
    }

    public String getCourse() {
        return course;
    }
}