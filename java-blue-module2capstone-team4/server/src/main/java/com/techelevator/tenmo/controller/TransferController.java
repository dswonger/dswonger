package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
public class TransferController {
@Autowired
    private TransferDao transferDao;
@Autowired
    private AccountDao accountDao;
@Autowired
    private UserDao userDao;
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/transfer/send", method = RequestMethod.POST)
    public Transfer send(Principal principal, @RequestBody Transfer transfer){

        System.out.println(transfer);

       String username = principal.getName();
      transfer.setStatus("approved");
      transfer.setDate(LocalDate.now());
      Account fromAccount = accountDao.getAccountByUserId(userDao.findIdByUsername(username));
      int fromAccountId = fromAccount.getAccountId();
      int toAccountId = transfer.getAccountTo();
      return transferDao.send(transfer);
//      transferDao.add(transfer);



    }
    @ResponseBody
    @RequestMapping(path ="/myTransfers", method =  RequestMethod.GET)
    public List<Transfer> myTransfers(Principal principal){
        return transferDao.myTransfers(userDao.findIdByUsername(principal.getName()));
    }
    @ResponseBody
    @RequestMapping(path = "/transfer/{id}", method = RequestMethod.GET)
    public Transfer getTransferById(@PathVariable int id){
        return  transferDao.getTransferById(id);
    }
    @RequestMapping(path = "/transferAmount/{id}", method = RequestMethod.GET)
    public BigDecimal getAmountById(@PathVariable int id) {
        Transfer transfer = transferDao.getTransferById(id);
        return transfer.getAmount();
    }
}
