package com.paf.fundtransfer.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.paf.fundtransfer.model.TransactionDetails;
import com.paf.fundtransfer.repo.RedisRepo;

public class LogAuditService {
    
    @Autowired
    private RedisRepo redisRepo;
    
    public void saveTransaction(TransactionDetails td) {
        redisRepo.save(td);
    }

}
