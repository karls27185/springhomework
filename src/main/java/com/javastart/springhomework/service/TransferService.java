package com.javastart.springhomework.service;

import com.javastart.springhomework.entity.Account;
import com.javastart.springhomework.entity.Bill;
import com.javastart.springhomework.exceptions.NotDefaultBillException;
import com.javastart.springhomework.utils.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransferService {

    private final AccountService accountService;

    @Autowired
    public TransferService(AccountService accountService) {
        this.accountService = accountService;
    }

    public Object transfer(Long accountIdFrom, Long accountIdTo, BigDecimal amount) {
        Account accountFrom = accountService.getById(accountIdFrom);
        Account accountTo = accountService.getById(accountIdTo);
        Bill billFrom = AccountUtils.findDefaultBill(accountFrom);
        Bill billTo = AccountUtils.findDefaultBill(accountTo);
        billFrom.setAmount(billFrom.getAmount().subtract(amount));
        billTo.setAmount(billTo.getAmount().add(amount));
        accountService.update(accountFrom);
        accountService.update(accountTo);
        return "Success";
    }


}
