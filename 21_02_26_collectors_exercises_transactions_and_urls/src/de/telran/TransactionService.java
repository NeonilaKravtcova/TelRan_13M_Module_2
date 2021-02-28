package de.telran;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionService {

    public Map<String, Long> getTransactionsSums(List<Transaction> transactions){
        return transactions
                .stream()
                .collect(Collectors.groupingBy(transaction -> transaction.account,
                        Collectors.summingLong(account -> account.sum)));
    }

}
