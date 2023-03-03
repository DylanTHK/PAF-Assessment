package com.paf.fundtransfer.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paf.fundtransfer.exception.TransferException;
import com.paf.fundtransfer.model.Account;
import com.paf.fundtransfer.model.TransactionDetails;
import com.paf.fundtransfer.repo.AccountRepo;

@Service
public class FundsTransferService {
    
    @Autowired
    private AccountRepo accRepo;

    // conduct transaction operations
    @Transactional(rollbackFor = TransferException.class)
    public void performTransaction(TransactionDetails td) throws TransferException {
        // generate random id
        td.setId(generateRandomId());
        String from = td.getFromAccount();
        String to = td.getToAccount();
        Double amt = td.getAmount();

        // get accounts to and from (SQL queries) to check updated amount
        Account fromAcc = accRepo.getAccountByName(from);
        Account toAcc = accRepo.getAccountByName(to);

        // update balances
        Double fromBalance = fromAcc.subtractBalance(amt);
        Double toBalance = toAcc.addBalance(amt);
        accRepo.updateBalance(from, fromBalance);
        accRepo.updateBalance(to, toBalance);
        System.out.println("\n\nTRANSACTION>>> from: " + fromAcc);
        System.out.println("\nTRANSACTION>>> to: " + toAcc);
        
        // check if amount in from negative (if -ve, else roll back)
        String message = "Insufficient balance in account";
        if (fromAcc.getBalance() < 0) {
            throw new TransferException(message);
        }
        
    }

    // method to generate 8 char ID
    public String generateRandomId() {
    String id = UUID.randomUUID().toString().substring(0,8); 
    return id;
    }
}
