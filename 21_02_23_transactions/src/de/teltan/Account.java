package de.teltan;

import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;

public class Account {

    String id;
    long balance;
    List<Transaction> transactions;

    public Account(String id, long balance, List<Transaction> transactions) {
        this.id = id;
        this.balance = balance;
        this.transactions = transactions;
    }
}
