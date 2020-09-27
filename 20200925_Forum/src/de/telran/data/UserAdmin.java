package de.telran.data;

public class UserAdmin extends User {
    private String password;

    public UserAdmin(String userName, int userAge, String password){
        super(userName, userAge);
        this.password = password;
    }

    public String getPassword(){
        return password;
    }
}
