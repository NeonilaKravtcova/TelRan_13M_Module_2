package de.telran.data;

import java.util.Scanner;

public class Admin {
    private String password;

    public Admin(String password) {
        this.password = password;
    }
    public boolean checkPassword(Scanner scanner) {
        int count = 3;
        while (count > 0) {
            System.out.print("Please, enter your password: ");
            String password = scanner.nextLine();
            if (/*admin.getPassword()*/this.password.equals(password)) {
                return true;
            } else {
                count--;
            }
        }
        return false;
    }

}
