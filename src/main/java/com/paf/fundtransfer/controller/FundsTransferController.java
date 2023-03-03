package com.paf.fundtransfer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import com.paf.fundtransfer.model.Account;
import com.paf.fundtransfer.model.TransactionDetails;
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
        List<Account> accounts = transferSvc.getAccounts();
        System.out.println("\nController >>> list of Accounts: " + accounts);
        // add list of accounts to 
        model.addAttribute("details", new TransactionDetails());
        model.addAttribute("accounts", accounts);

        return "transfer";
    }

    @PostMapping(path="/transfer",
        consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String checkTransfer(Model model, HttpSession sess, 
        @Valid TransactionDetails td, BindingResult binding
        // ,@RequestBody MultiValueMap<String, String> form
        ) {
        
        // call service to check 



        return "result";
    }
}
