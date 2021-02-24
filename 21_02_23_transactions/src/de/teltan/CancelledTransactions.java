package de.teltan;

import java.util.List;

public class CancelledTransactions {

    List<Account> accounts;

    public CancelledTransactions(List<Account> accounts) {
        this.accounts = accounts;
    }

    public long sum(){
        return accounts.stream().
                filter(x -> x.balance > 0)
                .flatMap(account -> /*Stream.of(account.transactions)*/account.transactions.stream())
                .filter(transaction -> transaction.getState().equals(State.CANCELLED))
                .mapToLong(transaction -> transaction.getSum())
                .sum();
    }
}

