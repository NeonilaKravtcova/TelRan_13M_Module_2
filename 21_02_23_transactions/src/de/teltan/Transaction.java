package de.teltan;

import java.util.Date;

public class Transaction {

    String uuid;
    State state;
    long sum;
    Date date;

    public Transaction(String uuid, State state, long sum, Date date) {
        this.uuid = uuid;
        this.state = state;
        this.sum = sum;
        this.date = date;
    }

    public String getUuid() {
        return uuid;
    }

    public State getState() {
        return state;
    }

    public long getSum() {
        return sum;
    }

    public Date getDate() {
        return date;
    }


}
