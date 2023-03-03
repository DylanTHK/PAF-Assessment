package com.paf.fundtransfer.model;

public class Account {
    private String accountId;
    private String name;
    private Double balance;

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
    @Override
    public String toString() {
        return "Account [accountId=" + accountId + ", name=" + name + ", balance=" + balance + "]";
    }
    
}
