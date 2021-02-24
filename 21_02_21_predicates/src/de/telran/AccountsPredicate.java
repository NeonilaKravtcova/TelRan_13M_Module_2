package de.telran;

import java.util.function.Predicate;

public class AccountsPredicate {

    public Predicate<Account> positiveBalance = account -> account.getBalance() > 0;

    public Predicate<Account> nonLockedOligarchAccount = account -> !account.isLocked() && account.getBalance() > 100000;


    //Predicate<Account> accountIsBlocked = account -> account.isLocked();
    //Predicate<Account> accountIsBlocked = Account::isLocked;
    //Predicate<Account> balance100000 = account -> account.getBalance() > 100000;
    //Predicate<Account> superAccount = account -> accountIsBlocked.test(account) && balance100000.test(account);

}
