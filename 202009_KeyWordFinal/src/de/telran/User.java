package de.telran;

public class User {
    private String userName;
    private static int userId = 0;

    public User(String userName){
        this.userName = userName;
    }

    public String getUserName(){
        return userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(String userName){
        userId++;
    }

    @Override
    public String toString() {
        return userId + ". " + userName;
    }

    private static String addUser(String userName){
        User user = new User(userName);
        user.setUserId(user.getUserName());
        return user.getUserId() + ". " + user.getUserName();
    }

    public static void main(String[] args) {
        //1 - можно так
        User user1 = new User("Vasya");
        user1.setUserId(user1.getUserName());
        System.out.println(user1.toString());

        //2 - можно так
        User user2 = new User ("Petya");
        user2.setUserId(user2.getUserName());
        System.out.println(user2.getUserId() + ". " + user2.getUserName());

        //3 - и вот так
        System.out.println(addUser("Kolya"));
        System.out.println(addUser("Olya"));
        System.out.println(addUser("Masha"));
    }
}
