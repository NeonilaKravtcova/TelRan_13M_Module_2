package de.teltan;

import java.util.List;
import java.util.stream.Stream;

public class CancelledTransactions {

    List<Account> accounts;

    public CancelledTransactions(List<Account> accounts) {
        this.accounts = accounts;
    }

    public long sum(){
        return accounts.stream().
                filter(x -> x.balance > 0)
                .flatMap(account -> /*Stream.of(account.transactions)*/account.transactions.stream())
                .filter(transaction -> transaction.state.equals(State.CANCELLED))
                .mapToLong(transaction -> transaction.sum)
                .sum();
    }

}
