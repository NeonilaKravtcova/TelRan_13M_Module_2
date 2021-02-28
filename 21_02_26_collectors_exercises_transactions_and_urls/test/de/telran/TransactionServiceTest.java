package de.telran;

import org.junit.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionServiceTest {

    Transaction tr01 = new Transaction(10, "Acc01");
    Transaction tr02 = new Transaction(15, "Acc02");
    Transaction tr03 = new Transaction(30, "Acc03");
    Transaction tr04 = new Transaction(5, "Acc01");
    Transaction tr05 = new Transaction(7, "Acc01");
    Transaction tr06 = new Transaction(15, "Acc02");
    Transaction tr07 = new Transaction(8, "Acc03");
    Transaction tr08 = new Transaction(15, "Acc02");
    Transaction tr09 = new Transaction(15, "Acc02");
    Transaction tr10 = new Transaction(50, "Acc04");

    TransactionService service = new TransactionService();

    List<Transaction> transactions = new ArrayList<>(Arrays.asList(tr01, tr02, tr03, tr04, tr05,
            tr06, tr07, tr08, tr09, tr10));

    Map<String, Long> res = new HashMap<>();

    @Test
    public void getTransactionsSums(){
        res.put("Acc01", 22L);
        res.put("Acc02", 60L);
        res.put("Acc03", 38L);
        res.put("Acc04", 50L);
        assertEquals(res, service.getTransactionsSums(transactions));
    }

}
