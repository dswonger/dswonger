package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.security.Principal;

@RestController
@PreAuthorize("isAuthenticated()")
public class AccountController {
@Autowired
    private AccountDao accountDao;
@Autowired
    private UserDao userDao;

    @RequestMapping(path= "/balance", method = RequestMethod.GET)
    public BigDecimal getBalance (Principal principal){
        String user = principal.getName();
        int id = userDao.findIdByUsername(user);
        Account account = accountDao.getAccountByUserId(id);
        return account.getBalance();

    }
    @RequestMapping(path = "/account/{id}", method = RequestMethod.GET)
    public Account getAccountByUserId (@PathVariable int id){
        return accountDao.getAccountByUserId(id);
    }

}
