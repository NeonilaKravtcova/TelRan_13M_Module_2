package de.telran;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AccountFilterTest {

    Account account1 = new Account("0001", 18245.56, false);
    Account account2 = new Account("0002", 413.02, false);
    Account account3 = new Account("0003", -100.05, true);
    Account account4 = new Account("0004", 100000.16, false);
    Account account5 = new Account("0005", 200005.78, true);
    Account account6 = new Account("0006", 738.00, true);

    List<Account> accountList = new ArrayList(Arrays.asList(account1, account2, account3, account4, account5, account6));

    AccountFilter accountFilter = new AccountFilter();
    AccountsPredicate predicate = new AccountsPredicate();

    @Test
    public void filter_emptyListTest(){
        List<Account> res = new ArrayList<>();
        accountList = new ArrayList<>(Collections.emptyList());
        Assert.assertEquals(res, accountFilter.filter(accountList, predicate.positiveBalance));
    }

    @Test
    public void filter_positiveBalanceTest(){
        List<Account> res = new ArrayList(Arrays.asList(account1, account2, account4, account5, account6));
        Assert.assertEquals(res, accountFilter.filter(accountList, predicate.positiveBalance));
    }

    @Test
    public void filter_nonLockedOligarchAccountTest(){
        List<Account> res = new ArrayList(Arrays.asList(account4));
        Assert.assertEquals(res, accountFilter.filter(accountList, predicate.nonLockedOligarchAccount));
    }
}
