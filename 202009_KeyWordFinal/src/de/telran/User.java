package de.telran;

public class User {
    private String userName;
    private int userId;
    private static int userQty = 0;

    public User(String userName){
        this.userName = userName;
        userId = ++userQty;
    }

    @Override
    public String toString() {
        if (userQty < 10){
            return "00" + userId + ". " + userName;
        } else if (userQty < 99) {
            return "0" + userId + ". " + userName;
        } else {
            return userId + ". " + userName;
        }
    }

    public static void main(String[] args) {

        User user1 = new User("Vasya");
        User user2 = new User ("Petya");
        User user3 = new User ("Kolya");
        User user4 = new User ("Olya");
        User user5 = new User ("Masha");

        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
        System.out.println(user4);
        System.out.println(user5);
        System.out.println();

        User user6 = new User ("Misha");

        System.out.println(user1);
        System.out.println(user6);
        System.out.println(user3);
        System.out.println(user5);
    }
}
