package de.teltan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Transaction tr01 = new Transaction("0001", State.FINISHED, 1300, new Date(20, 0,31));
        Transaction tr02 = new Transaction("0002", State.CANCELLED, 500, new Date(20, 1,15));
        Transaction tr03 = new Transaction("0003", State.PROCESSING, 200, new Date(20, 2,12));
        Transaction tr04 = new Transaction("0004", State.CANCELLED, 700, new Date(20, 3,5));
        Transaction tr05 = new Transaction("0005", State.CANCELLED, 100, new Date(20, 4,1));
        Transaction tr06 = new Transaction("0005", State.PROCESSING, 50, new Date(20, 4,1));
        Transaction tr07 = new Transaction("0005", State.FINISHED, 600, new Date(20, 4,1));
        Transaction tr08 = new Transaction("0005", State.FINISHED, 100, new Date(20, 4,1));
        Transaction tr09 = new Transaction("0005", State.CANCELLED, 400, new Date(20, 4,1));
        Transaction tr10 = new Transaction("0005", State.CANCELLED, 300, new Date(20, 4,1));

        Account acc1 = new Account("01", 50, new ArrayList(Arrays.asList(tr01, tr02, tr03, tr04, tr05)));
        Account acc2 = new Account("02", 200, new ArrayList(Arrays.asList(tr06, tr07, tr09)));
        Account acc3 = new Account("02", 200, new ArrayList(Arrays.asList(tr08, tr10)));

        List<Account> accountList = new ArrayList(Arrays.asList(acc1, acc2, acc3));

        System.out.println(new CancelledTransactions(accountList).sum());
    }
}
