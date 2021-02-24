package de.telran;

public class Account {

    private final String number;
    private double balance;
    private boolean isLocked;

    public Account(String number, double balance, boolean isLocked) {
        this.number = number;
        this.balance = balance;
        this.isLocked = isLocked;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isLocked() {
        return isLocked;
    }

    @Override
    public String toString() {
        return "\nAccount " + number + ((!isLocked) ? " is active" : " is locked") + ", balance: " + balance;
    }
}
