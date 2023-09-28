package com.techelevator.tenmo.model;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class AccountTest {
    @Test
    public void test_Set_Account_Id() {
        int id = 1;
        Account account = new Account();
        account.setAccountId(1);
        assertEquals(1, account.getAccountId());
    }
    @Test
    public void test_Set_UserId() {
        int id =1;
        Account account = new Account();
        account.setUserId(1);
        assertEquals(1, account.getUserId());
    }
    @Test
    public void test_Set_Balance() {
        BigDecimal balance = BigDecimal.valueOf(1);
        Account account = new Account();
        account.setBalance(BigDecimal.valueOf(1));
        assertEquals(BigDecimal.valueOf(1), account.getBalance());
    }
}