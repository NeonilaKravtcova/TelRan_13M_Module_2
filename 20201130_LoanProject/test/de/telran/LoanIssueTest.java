package de.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoanIssueTest {

    LoanIssuer[] loanIssuers = new LoanIssuer[] {new LoanIssuer("Vassily", true, true),
            new LoanIssuer("Ivan", false, true),
            new LoanIssuer("Maria", true, false),
            new LoanIssuer("Anna", false, false)};


    LoanConsumer[] loanConsumers = new LoanConsumer[] {new LoanConsumer("Evgeny", 41, 15000),
            new LoanConsumer("Svetlana", 17, 20001),
            new LoanConsumer("Pavel", 41, 70000),
            new LoanConsumer("Stanislav", 18, 20000),
            new LoanConsumer("Alexander", 72, 25000),
            new LoanConsumer("Sergey", 34, 40000)};

    @Test
    void test_employeeLazyAndKind_arrayLoanConsumers(){
            assertFalse(loanIssuers[0].toIssue(loanConsumers[0]));
            assertFalse(loanIssuers[0].toIssue(loanConsumers[1]));
            assertTrue(loanIssuers[0].toIssue(loanConsumers[2]));
            assertTrue(loanIssuers[0].toIssue(loanConsumers[3]));
            assertTrue(loanIssuers[0].toIssue(loanConsumers[4]));
            assertTrue(loanIssuers[0].toIssue(loanConsumers[5]));
    }

    @Test
    void test_employeeLazyNotKind_arrayLoanConsumers() {
        assertFalse(loanIssuers[1].toIssue(loanConsumers[0]));
        assertFalse(loanIssuers[1].toIssue(loanConsumers[1]));
        assertTrue(loanIssuers[1].toIssue(loanConsumers[2]));
        assertTrue(loanIssuers[1].toIssue(loanConsumers[3]));
        assertTrue(loanIssuers[1].toIssue(loanConsumers[4]));
        assertTrue(loanIssuers[1].toIssue(loanConsumers[5]));
    }

    @Test
    void test_employeeNotLazyButKind_arrayLoanConsumers() {
        assertFalse(loanIssuers[2].toIssue(loanConsumers[0]));
        assertFalse(loanIssuers[2].toIssue(loanConsumers[1]));
        assertTrue(loanIssuers[2].toIssue(loanConsumers[2]));
        assertTrue(loanIssuers[2].toIssue(loanConsumers[3]));
        assertFalse(loanIssuers[2].toIssue(loanConsumers[4]));
        assertTrue(loanIssuers[2].toIssue(loanConsumers[5]));
    }

    @Test
    void test_employeeNotLazyNotKind_arrayLoanConsumers() {
        assertFalse(loanIssuers[3].toIssue(loanConsumers[0]));
        assertFalse(loanIssuers[3].toIssue(loanConsumers[1]));
        assertTrue(loanIssuers[3].toIssue(loanConsumers[2]));
        assertTrue(loanIssuers[3].toIssue(loanConsumers[3]));
        assertFalse(loanIssuers[3].toIssue(loanConsumers[4]));
        assertTrue(loanIssuers[3].toIssue(loanConsumers[5]));
    }

}
