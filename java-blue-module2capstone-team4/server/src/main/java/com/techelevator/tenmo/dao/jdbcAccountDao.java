package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
public class jdbcAccountDao implements AccountDao{
    private jdbcAccountDao jdbcAccountDao;
    private JdbcTemplate jdbcTemplate;

    public jdbcAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public BigDecimal getBalance(int id){
        BigDecimal balance= BigDecimal.ZERO;
      //SqlRowSet rowSet;
        String sql = "select * from account where account_id = ?;";

         SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
         Account account = new Account();
         if (results.next()){
            balance = results.getBigDecimal("balance");
            account.setBalance(balance);
//             account = new Account();
//             account.setUserId(results.getInt("user_id"));
//             account.setBalance(results.getBigDecimal("balance"));
         }
        return account.getBalance();
    }
    @Override
    public Account getAccountByUserId( int userId){
        String sql = "SELECT * FROM account WHERE user_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);
        Account account = null;

        if (rowSet.next()) {
            account = mapRowToAccount(rowSet);
        }
        return account;
    }




    public Account mapRowToAccount(SqlRowSet rowSet){
        Account account = new Account();
        account.setAccountId(rowSet.getInt("account_id"));
        account.setUserId(rowSet.getInt("user_id"));
        account.setBalance(rowSet.getBigDecimal("balance"));
        return account ;
    }
}
