package com.paf.fundtransfer.service;

import java.lang.module.FindException;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paf.fundtransfer.model.Account;
import com.paf.fundtransfer.model.TransactionDetails;
import com.paf.fundtransfer.repo.AccountRepo;

@Service
public class TransferService {
    
    @Autowired
    private AccountRepo accountRepo;

    public List<Account> getAccounts() {
        return accountRepo.getAllAccounts();
    }

    public List<String> validateDetails(TransactionDetails td) {
        System.out.println("\n\nTSvc >>> Transaction details: " + td);
        String from = td.getFromAccount();
        System.out.println("\n\nFROM TRANSFER: " + from);
        Account fromAccount = accountRepo.getAccountByName(from);
        List<String> errors = new LinkedList<>();
        // C2 check if accounts are the same
        String to = td.getToAccount();
        if (from.equalsIgnoreCase(to)) {
            errors.add("Can not transfer to same account");
        }
        if (null != td.getAmount()) {
            // C3 transfer amount is not 0 or negative
            if (td.getAmount() <= 0) {
                errors.add("Transfer amount should be more than $0");
            }
            // C4 minimum transfer amount is $10
            if (td.getAmount() < 10) {
                errors.add("Minimum transfer amount is $10");
            }
            // check fromAccount value > transfer amount
            if (td.getAmount() > fromAccount.getBalance()) {
                errors.add("Account should have sufficient balance");
            }    
        } else {
            errors.add("Amount should not be null");
        }
        return errors;
    }

    @Transactional
    public void performTransaction(TransactionDetails td) {
        // generate random id
        td.setId(generateRandomId());


    }

         // method to generate 8 char ID
    public String generateRandomId() {
    String id = UUID.randomUUID().toString().substring(0,8); 
    return id;
}
    
}
