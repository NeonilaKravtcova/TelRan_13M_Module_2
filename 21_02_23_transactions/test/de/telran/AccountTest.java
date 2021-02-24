package de.telran;

import de.teltan.Account;
import de.teltan.State;
import de.teltan.Transaction;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class AccountTest {

    Transaction tr01 = new Transaction("0001", State.FINISHED, 1300, new Date(20, 0,31));
    Transaction tr02 = new Transaction("0002", State.CANCELLED, 500, new Date(20, 1,15));
    Transaction tr03 = new Transaction("0003", State.PROCESSING, 200, new Date(20, 2,12));
    Transaction tr04 = new Transaction("0004", State.CANCELLED, 700, new Date(20, 3,5));
    Transaction tr05 = new Transaction("0005", State.CANCELLED, 100, new Date(20, 4,1));
    List<Transaction> transactions01 = new ArrayList(Arrays.asList(tr01, tr02, tr03, tr04, tr05));

    Account acc1 = new Account("01", 050, transactions01);


    @Test
    public void cancelledTransactions_test(){
        acc1.cancelledTransactions();
    }
}
