package com.techelevator.tenmo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transfer {

    private int transferId;
    private  BigDecimal amount;
    private  int accountFrom;
    private int accountTo;
     private LocalDate date;
     private  String status;
     public Transfer(){

     }

    public Transfer(int transferId, BigDecimal amount, int accountFrom, int accountTo, LocalDate date, String status) {
        this.transferId = transferId;
        this.amount = amount;
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.date = date;
        this.status = status;
    }

    public int getTransferId() {
        return transferId;
    }

    public void setTransferId(int transferId) {
        this.transferId = transferId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(int accountFrom) {
        this.accountFrom = accountFrom;
    }

    public int getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(int accountTo) {
        this.accountTo = accountTo;
    }

    public LocalDate date() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public String toString(){
         return "Transfer{" +
                 "transferId=" + transferId + '\'' +
                 ", amount=" +amount  +
                 ", accountFrom=" + accountFrom +
                 ", accountTo=" + accountTo +
                 ", date =" + date +
                 ", status =" + status + '\'' +
                 "}";
    }
}