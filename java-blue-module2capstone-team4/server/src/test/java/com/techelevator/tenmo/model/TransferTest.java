package com.techelevator.tenmo.model;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class TransferTest {
@Test
    public void test_Set_Transfer_Id() {
    int id = 1;
    Transfer transfer = new Transfer();
    transfer.setTransferId(1);
    assertEquals(1, transfer.getTransferId());
}
@Test
    public void test_Set_Amount() {
    Transfer transfer = new Transfer();
    transfer.setAmount(BigDecimal.valueOf(1));
    assertEquals(BigDecimal.valueOf(1), transfer.getAmount());
}
@Test
    public void test_Set_AccountFrom() {
    Transfer transfer = new Transfer();
    transfer.setAccountFrom(1);
    assertEquals(1, transfer.getAccountFrom());
}
@Test
    public void test_Set_AccountTo() {
    Transfer transfer = new Transfer();
    transfer.setAccountTo(1);
    assertEquals(1, transfer.getAccountTo());
}
@Test
    public void test_Get_Status() {
    Transfer transfer = new Transfer();
    transfer.setStatus("approved");
    assertEquals("approved", transfer.getStatus());
}

}