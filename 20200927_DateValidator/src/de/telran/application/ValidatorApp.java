package de.telran.application;

import de.telran.dao.Validator;
import de.telran.data.Date;

public class ValidatorApp {
    public static void main(String[] args) {
        Validator validator = new Validator();
        System.out.println(validator.dateValidator(new Date(2020, 2, 29)));
        System.out.println(validator.dateValidator(new Date(2019, 2, 29)));
    }
}
