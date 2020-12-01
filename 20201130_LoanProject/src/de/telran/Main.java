package de.telran;

public class Main {

    public static void main(String[] args) {

        //LoanIssuer vassily = new LoanIssuer("Vassily", true, false);
        LoanIssuer[] loanIssuers = new LoanIssuer[] {new LoanIssuer("Vassily", true, true),
                new LoanIssuer("Ivan", false, true),
                new LoanIssuer("Maria", true, false),
                new LoanIssuer("Anna", false, false)};


        LoanConsumer[] loanConsumers = new LoanConsumer[] {new LoanConsumer("Evgeny", 17, 50000),
                new LoanConsumer("Peter", 25, 20005),
                new LoanConsumer("Olga", 35, 1000),
                new LoanConsumer("Elisabeth", 71, 30000),
                new LoanConsumer("Alexander", 58, 15000),
                new LoanConsumer("Sergey", 51, 40000)};

        for (LoanIssuer loanIssuer : loanIssuers) {
            for (LoanConsumer loanConsumer : loanConsumers) {
                if (loanIssuer.toIssue(loanConsumer)) {
                    System.out.println("Employee " + loanIssuer.getName() + " issues a loan to " +
                            loanConsumer.getName());
                } else {
                    System.out.println("Employee " + loanIssuer.getName() + " does not issue a loan to " +
                            loanConsumer.getName());
                }
            }
            System.out.println();
        }

    }
}
