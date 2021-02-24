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

}
