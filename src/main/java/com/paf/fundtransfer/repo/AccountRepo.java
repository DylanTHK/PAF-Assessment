package com.paf.fundtransfer.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.paf.fundtransfer.model.Account;

import static com.paf.fundtransfer.repo.Queries.*;

import java.util.LinkedList;
import java.util.List;

@Repository
public class AccountRepo {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Account> getAllAccounts() {
        List<Account> accounts = new LinkedList<>();
        final SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_GET_ALL_ACCOUNTS);

        while (rs.next()) {
            Account a = new Account();
            a.setAccountId(rs.getString("account_id"));
            a.setName(rs.getString("name"));
            a.setBalance(rs.getDouble("balance"));
            a.setDetails();
            accounts.add(a);
        }
        // System.out.println("\nAccounts created: " + accounts);
        return accounts;
    }

    public Account getAccountByName(String name) {
        final SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_GET_ACC_BY_NAME, name);
        Account a = new Account();
        if(rs.next()) {
            a.setAccountId(rs.getString("account_id"));
            a.setName(rs.getString("name"));
            a.setBalance(rs.getDouble("balance"));
            a.setDetails();
        }
        return a;
    }
}
