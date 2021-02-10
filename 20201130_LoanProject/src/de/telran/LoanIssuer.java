package de.telran;

public class LoanIssuer {

    private String name;
    private boolean isKind;
    private boolean isLazy;

    public LoanIssuer(String name, boolean isKind, boolean isLazy){
        this.name = name;
        this.isKind = isKind;
        this.isLazy = isLazy;
    }

    public boolean toIssue(LoanConsumer loanConsumer){
        if (loanConsumer.getAge() < 18 || loanConsumer.getSalary() < 20000){
            return false;
        } else if (isLazy || isKind && loanConsumer.getAge() < 70) {
            return true;
        } else return loanConsumer.getAge() < 50;
    }

    public String getName() {
        return name;
    }

}
