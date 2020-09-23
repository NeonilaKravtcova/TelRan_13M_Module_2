package de.telran.application;

import de.telran.dao.Bank;
import de.telran.data.BankAccount;
import de.telran.data.Person;
import de.telran.data.Sex;

import java.util.Arrays;

public class BankApp {
    public static void main(String[] args) {
        Person client1 = new Person("Ivan", "Ivanov", 1978, "Moscow", Sex.MALE);
        Person client2 = new Person("Maria", "Petrova", 1972, "Moscow", Sex.FEMALE);
        Person client3 = new Person("Natalia", "Orlova", 1985, "Moscow", Sex.FEMALE);
        Person client4 = new Person("Olga", "Stepanova", 1964, "Moscow", Sex.FEMALE);
        Person client5 = new Person("Andrey", "Kozlov", 1987, "Moscow", Sex.MALE);
        Person client6 = new Person("Stepan", "Sidorov", 1999, "Moscow", Sex.MALE);
        Person client7 = new Person("Valentina", "Egorova", 1957, "Moscow", Sex.FEMALE);
        Person client8 = new Person("Alexandr", "Tikhonov", 2001, "Moscow", Sex.MALE);
        Person client9 = new Person("Evgeniy", "Likhachev", 1984, "Moscow", Sex.MALE);
        //Person client10 = new Person("Antonina", "Pavlova", 1972, "Moscow", Sex.FEMALE);

        BankAccount account1 = new BankAccount(client1, 2000.00);
        BankAccount account2 = new BankAccount(client2, 500.18);
        BankAccount account3 = new BankAccount(client3, 0.20);
        BankAccount account4 = new BankAccount(client4, 124.32);
        BankAccount account5 = new BankAccount(client5, 1975.00);
        BankAccount account6 = new BankAccount(client6, 16.50);
        BankAccount account7 = new BankAccount(client7, 144.10);
        BankAccount account8 = new BankAccount(client8, 12.08);
        BankAccount account9 = new BankAccount(client9, 0.45);
        //BankAccount account10 = new BankAccount(client10, 955.25);

        Bank myBank = new Bank(100);
        myBank.addAccount(account1);
        myBank.addAccount(account2);
        myBank.addAccount(account3);
        myBank.addAccount(account4);
        myBank.addAccount(account5);
        myBank.addAccount(account6);
        myBank.addAccount(account7);
        myBank.addAccount(account8);
        myBank.addAccount(account9);
        //myBank.addAccount(account10);

        myBank.displayAccounts();

        myBank.transferMoney(10100001, 10100002, 200.25);
        myBank.transferMoney(10100002, 10100001, 100);
        myBank.transferMoney(10100002, 10100001, 700);
        myBank.transferMoney(10100002, 10100011, 700);

        myBank.getCountClientsPerSex(Sex.FEMALE);
        myBank.displayClientsPerSex(myBank.getClientsPerSex(Sex.FEMALE));

        myBank.getCountClientsPerSex(Sex.MALE);
        myBank.displayClientsPerSex(myBank.getClientsPerSex(Sex.MALE));
    }
}

