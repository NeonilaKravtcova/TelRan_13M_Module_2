package de.telran;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class AccountFilter {

    List<Account> filter(List<Account> accountList, Predicate<Account> predicate){
        if (accountList.isEmpty()){
            return accountList;
        }
        //List<Account> res = Optional.ofNullable(accountList).orElse(new ArrayList<>());
        List<Account> res = new ArrayList<>();
        for (Account account : accountList) {
            if(predicate.test(account)){
                res.add(account);
            }
        }
        return res;
    }
}
