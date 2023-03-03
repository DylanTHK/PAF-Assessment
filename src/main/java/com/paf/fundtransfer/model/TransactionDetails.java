package com.paf.fundtransfer.model;

import java.util.UUID;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


public class TransactionDetails {
    private String id;

    @NotNull(message="Please choose an account")
    private String fromAccount;

    @NotNull(message="Please choose an account")
    private String toAccount;

    @NotNull(message="Please choose an amount")
    @Min(value=10, message="Minimum value of $10")
    private Double amount;

    private String comments;

    public TransactionDetails() {
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
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
        return "TransactionDetails [id=" + id + ", fromAccount=" + fromAccount + ", toAccount=" + toAccount
                + ", amount=" + amount + ", comments=" + comments + "]";
    }


}
