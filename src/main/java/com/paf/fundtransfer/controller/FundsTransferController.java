package com.paf.fundtransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import com.paf.fundtransfer.model.Account;
import com.paf.fundtransfer.repo.AccountRepo;
import com.paf.fundtransfer.service.TransferService;

@Controller
@RequestMapping
public class FundsTransferController {
    
    @Autowired
    private TransferService transferSvc;
    
    @Autowired
    private AccountRepo accountRepo;

    @GetMapping(path="/")
    public String getView(Model model, HttpSession sess) {
        // query sql for list of accounts (for thymeleaf)
        accountRepo.getAllAccounts();
        // add list of accounts to 

        return "transfer";
    }

    @PostMapping(path="/transfer")
    public String checkTransfer(Model model, HttpSession sess, @Valid Account acc, BindingResult binding) {
        
        // call service to check 



        return "result";
    }
}
