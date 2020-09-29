package de.telran.data;

public enum Menu {

    MO("Spaghetti"),
    TU("Pizza"),
    WE("Chicken"),
    TH("Fish&Cheaps"),
    FR("Burger"),
    SA("Olivie"),
    SU("Soup");

    private String menu;

    Menu(String menu){
        this.menu = menu;
    }

    public String getMenu() {
        return menu;
    }
}
