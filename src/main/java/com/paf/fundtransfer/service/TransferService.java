package com.paf.fundtransfer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paf.fundtransfer.model.Account;
import com.paf.fundtransfer.repo.AccountRepo;

@Service
public class TransferService {
    
    @Autowired
    private AccountRepo accountRepo;

    public List<Account> getAccounts() {
        return accountRepo.getAllAccounts();
    }
    
}
