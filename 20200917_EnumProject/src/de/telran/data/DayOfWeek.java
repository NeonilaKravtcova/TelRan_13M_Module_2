package de.telran.data;

public enum DayOfWeek {
    //В теле класса типа Enum достаточно перечислить объекты через запятую ЗАГЛАВНЫМИ БУКВАМИ
    MONDAY("MO"),
    TUESDAY("TU"),
    WEDNESDAY("WE"),
    THURSDAY("TH"),
    FRIDAY("FR"),
    SATURDAY("SA"),
    SUNDAY("SU");//Если мы хотим расширить наш класс, то после последнего объекта ставится ";" и можем делать поле

    private String title;

    //Можем сделать и конструктор
    DayOfWeek(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
/*
    @Override
    public String toString() {
        return title;
    }*/
}
