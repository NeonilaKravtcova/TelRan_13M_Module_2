package de.telran;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountsPredicateTest {

    Account account1 = new Account("0001", 13748.56, false);
    Account account2 = new Account("0002", 118.02, true);
    Account account3 = new Account("0003", -0.05, true);
    Account account4 = new Account("0004", 0.00, false);

    //List<Account> accountList = new ArrayList(Arrays.asList(account1, account2, account3, account4, account5, account6));

    AccountsPredicate predicate = new AccountsPredicate();

    @Test
    public void positiveBalance_balanceMore0AndIsNotLocked(){
        Assert.assertTrue(predicate.positiveBalance.test(account1));
    }

    @Test
    public void positiveBalance_balanceMore0AndIsLocked(){
        Assert.assertTrue(predicate.positiveBalance.test(account2));
    }

    @Test
    public void positiveBalance_balanceLess0(){
        Assert.assertFalse(predicate.positiveBalance.test(account3));
    }

    @Test
    public void positiveBalance_balanceIs0(){
        Assert.assertFalse(predicate.positiveBalance.test(account4));
    }
}
