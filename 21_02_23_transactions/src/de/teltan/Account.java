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


    public long cancelledTransactions() {
        /*DoubleStream transactionStream = */return transactions.stream()
                .filter(transaction -> transaction.state.equals(State.CANCELLED))
                .flatMapToLong(transaction -> LongStream.of(transaction.sum))
                .sum();
        //return transactionStream.sum();
    }
}
