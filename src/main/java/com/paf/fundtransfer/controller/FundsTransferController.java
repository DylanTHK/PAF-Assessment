package com.paf.fundtransfer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping(path={"/", "index.html"})
    public String getView(Model model, HttpSession sess) {
        // restart session
        sess.invalidate();

        // query sql for list of accounts (for thymeleaf)
        List<Account> accounts = transferSvc.getAccounts();
        
        // add list of accounts to 
        model.addAttribute("td", new TransactionDetails());
        model.addAttribute("accounts", accounts);
        // sess.setAttribute("acc", accounts);

        return "index";
    }

    @PostMapping(path="/transfer",
        consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String checkTransfer(Model model, HttpSession sess, 
        @Valid TransactionDetails td, BindingResult binding) {
        // if (binding.hasErrors()) {
        //     return "transfer";
        // }
        // System.out.println("\nBinding Results: " + binding);

        System.out.println("\nTransaction Details: " + td);
        List<Account> accounts = transferSvc.getAccounts();
        // call service for validation (true if pass)
        List<String> errorMessages = transferSvc.validateDetails(td);
        
        System.out.println("List of errors: " + errorMessages);
        // check for error messages
        if (errorMessages.size() > 0) {
            model.addAttribute("accounts", accounts);
            model.addAttribute("td", td);
            model.addAttribute("errors", errorMessages);
            return "transfer";
        } else {
            // NO ERRORS: transferSvc.performTransaction(td);
            model.addAttribute("td", td);
            return "result";
        }
    }
}
