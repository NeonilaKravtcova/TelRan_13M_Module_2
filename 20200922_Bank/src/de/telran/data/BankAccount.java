package de.telran.data;

public class BankAccount {
    private int account;
    private Person client;
    private double balance;
    private static int accountsNumber = 10100000;

    public BankAccount(Person client, double balance){
        account = ++accountsNumber;
        this.client = client;
        this.balance = balance;
    }

    public int getAccount() {
        return account;
    }

    public Person getClient() {
        return client;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount)) return false;

        BankAccount that = (BankAccount) o;

        if (getAccount() != that.getAccount()) return false;
        if (Double.compare(that.getBalance(), getBalance()) != 0) return false;
        return getClient().equals(that.getClient());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getAccount();
        result = 31 * result + getClient().hashCode();
        temp = Double.doubleToLongBits(getBalance());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Bank account number: " +
                account +
                "\n" + client.toStringName() +
                "\nBalance: " + balance;
    }

    public void debit(double sum){
        balance = balance + sum;
    }

    public boolean credit(double sum){
        if (sum <= balance){
            balance = balance - sum;
            return true;
        }
        return false;
    }
}
