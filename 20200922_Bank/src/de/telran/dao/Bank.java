package de.telran.dao;

import de.telran.data.BankAccount;
import de.telran.data.Person;
import de.telran.data.Sex;

public class Bank {
    private BankAccount[] accounts;
    private int size;
    private Person[] clients;

    public Bank(int capacity) {
        accounts = new BankAccount[capacity];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public BankAccount[] getAccounts() {
        return accounts;
    }

    public int checkAccount(int account) {
        for (int i = 0; i < size; i++) {
            if (account == accounts[i].getAccount()) {
                return i;
            }
        }
        return -1;
    }

    public boolean addAccount(BankAccount account) {
        if (checkAccount(account.getAccount()) >= 0 || size >= accounts.length) {
            return false;
        }
        accounts[size] = account;
        size++;
        return true;
    }

    public boolean closeAccount(int account) {
        int index = checkAccount(account);
        if (index < 0){
            return false;
        }
        accounts[index] = accounts[size - 1];
        size--;
        return true;
    }

    public void displayAccounts(){
        for (int i = 0; i < size; i++) {
            System.out.println(accounts[i]);
            System.out.println("---------------");
        }
    }

    public BankAccount[] getExistingAccounts(){
        BankAccount[] allAccounts = new BankAccount[size];
        for (int i = 0; i < size; i++) {
            allAccounts[i] = accounts[i];
        }
        return allAccounts;
    }

    public double getBalanceOfAccount(){
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum = sum + accounts[i].getBalance();
        }
        return sum;
    }

    public boolean transferMoney(int accountFrom, int accountTo, double sum){
        int indexFrom = checkAccount(accountFrom);
        if (indexFrom < 0){
            System.out.println("Withdrawal account is incorrect, please check and try again");
            return false;
        }
        int indexTo = checkAccount(accountTo);
        if (indexTo < 0 ){
            System.out.println("Recipient's account is incorrect, please check and try again\n");
            return false;
        }
        if (!accounts[indexFrom].credit(sum)){
            System.out.println("Transaction is not possible, your balance is too low\n");
            return false;
        }
        accounts[indexTo].debit(sum);
        System.out.println("Transaction is finished, see details below");
        System.out.println("------------------------------------------");
        System.out.println(sum + " Euro was transferred to " + accounts[indexTo].getClient().toStringName());
        System.out.println("Your balance is " + accounts[indexFrom].getBalance());
        System.out.println();
        return true;
    }

    public int getCountClientsPerSex(Sex sex){
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (accounts[i].getClient().getSex().equals(sex)) {
                count++;
            }
        }
        return count;
    }

    public void displayClientsPerSex(Sex sex){
        int count = 0;
        System.out.println("---------------------------------------");
        System.out.println("The following " + sex + " clients are found:");
        System.out.println("---------------------------------------");
        for (int i = 0; i < size; i++) {
            if (accounts[i].getClient().getSex().equals(sex)) {
                count++;
                System.out.println(count + ". " + accounts[i].getClient().toStringName() + "\n");
            }
        }
        System.out.println("-------------------------------");
        System.out.println("TOTAL: " + count + " clients");
        System.out.println();
    }

    public Person[] getClientsPerSex(Sex sex){
        int j = 0;
        Person[] clients = new Person[getCountClientsPerSex(sex)];
        System.out.println("SEX: " + sex);
        System.out.println("------------");
        for (int i = 0; i < size; i++) {
            if (accounts[i].getClient().getSex().equals(sex)) {
                clients[j] = accounts[i].getClient();
                j++;
            }
        }
        return clients;
    }
}