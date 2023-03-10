package com.paf.fundtransfer.repo;

public class Queries {
    public static String SQL_GET_ALL_ACCOUNTS = "SELECT * FROM accounts";
    public static String SQL_GET_ACC_BY_ID = "SELECT * FROM accounts WHERE account_id = ?";
    public static String SQL_GET_ACC_BY_NAME = "SELECT * FROM accounts WHERE name = ?";
    public static String SQL_UPDATE_BALANCE_BY_NAME = "UPDATE accounts SET balance = ? WHERE name = ?";

}
