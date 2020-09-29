package de.telran.dao;

import de.telran.data.Date;

public class Validator {
    Date date;

    public boolean checkLeapYear(Date date) {
        if (date.getYear() % 400 == 0) {
            return true;
        }
        return date.getYear() % 100 != 0 && date.getYear() % 4 == 0;
    }


    public int dayQty(Date date) {
        if (date.getMonth() > 0 && date.getMonth() <= 12) {
            if (date.getMonth() == 2) {
                if (checkLeapYear(date)) { return 29;}
                    else { return 28; }
            }
            if (date.getMonth() == 4 || date.getMonth() == 6 || date.getMonth() == 9 || date.getMonth() == 11)
                    { return 30; }
                    else { return 31; }
        }
        return 0;
    }

        public boolean dateValidator(Date date){
            return date.getDay() > 0 && date.getDay() <= dayQty(date);
        }

}
