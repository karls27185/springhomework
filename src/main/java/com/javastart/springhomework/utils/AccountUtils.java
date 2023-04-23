package com.javastart.springhomework.utils;

import com.javastart.springhomework.entity.Account;
import com.javastart.springhomework.entity.Bill;
import com.javastart.springhomework.exceptions.NotDefaultBillException;

public class AccountUtils {

    public static Bill findDefaultBill(Account accountFrom) {
        return accountFrom.getBills().stream()
                .filter(Bill::getDefault).findAny()
                .orElseThrow(() -> new NotDefaultBillException("Unable to find default bill for account with id: "
                        + accountFrom.getAccountId()));
    }
}
