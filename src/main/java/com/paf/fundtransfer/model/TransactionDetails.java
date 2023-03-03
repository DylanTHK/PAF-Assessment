package com.paf.fundtransfer.model;

import jakarta.validation.constraints.NotNull;


public class TransactionDetails {
    @NotNull(message="Please choose an account")
    private String fromAccount;

    @NotNull(message="Please choose an account")
    private String toAccount;

    @NotNull(message="Please choose an amount")
    private Double amount;

    private String comments;

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "TransactionDetails [fromAccount=" + fromAccount + ", toAccount=" + toAccount + ", amount=" + amount
                + ", comments=" + comments + "]";
    }

}
