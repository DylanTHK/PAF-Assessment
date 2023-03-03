package com.paf.fundtransfer.model;


public class Account {
    private String accountId;
    private String name;
    private String details;
    private Double balance;

    public Double addBalance(Double amt) {
        this.balance = balance + amt;
        return this.balance;
    }
    public Double subtractBalance(Double amt) {
        this.balance = balance - amt;
        return this.balance;
    }
    public String getAccountId() {
        return accountId;
    }
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getBalance() {
        return balance;
    }
    public void setBalance(Double balance) {
        this.balance = balance;
    }
    public String getDetails() {
        return details;
    }
    public void setDetails() {
        this.details = name + " (" + accountId + ")";
    }

    @Override
    public String toString() {
        return "Account [accountId=" + accountId + ", name=" + name + ", details=" + details + ", balance=" + balance
                + "]";
    }

    
}

