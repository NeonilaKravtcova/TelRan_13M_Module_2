package de.telran;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Account account1 = new Account("0001", 13748.56, false);
        Account account2 = new Account("0002", 118.02, false);
        Account account3 = new Account("0003", -0.05, true);
        Account account4 = new Account("0004", 105000.16, false);
        Account account5 = new Account("0005", 200000.78, true);
        Account account6 = new Account("0006", 538.00, true);

        List<Account> accountList = new ArrayList(Arrays.asList(account1, account2, account3, account4, account5, account6));

        AccountFilter accountFilter = new AccountFilter();

        AccountsPredicate predicate = new AccountsPredicate();

        System.out.println(accountFilter.filter(accountList, predicate.positiveBalance) + "\n");
        System.out.println(accountFilter.filter(accountList, predicate.nonLockedOligarchAccount));

    }

}
