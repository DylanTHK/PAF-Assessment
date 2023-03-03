package com.paf.fundtransfer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class FundsTransferController {
    


    @GetMapping(path="/")
    public String getView() {
        // query sql for list of accounts
        // add
        return "transfer";
    }

    @PostMapping(path="/transfer")
    public String checkTransfer() {
        
        // call service to check 



        return "result";
    }
}
