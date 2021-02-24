package de.teltan;

import java.util.Date;

public class Transaction {

    String uuid;
    private State state;
    private long sum;
    Date date;

    public Transaction(String uuid, State state, long sum, Date date) {
        this.uuid = uuid;
        this.state = state;
        this.sum = sum;
        this.date = date;
    }

    public long getSum() {
        return sum;
    }

    public State getState() {
        return state;
    }
}

