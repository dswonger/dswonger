package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class MunchyTest {
    private Munchy munchy;

    @Before
    public void setUp() {
        this.munchy = new Munchy(BigDecimal.valueOf(3.85), "A4", "Chippos", 5, "Crunch Crunch, Yum!");
    }


    @Test
    public void test_Munchy() {
        BigDecimal actualPrice = BigDecimal.valueOf(3.85);
        String actualSlotNumber = "A4";
        String actualProductName = "Chippos";
        int actualStock = 5;
        String actualMessage = "Crunch Crunch, Yum!";
        assertEquals(munchy.getPrice(), actualPrice);
        assertEquals(munchy.getSlotLocation(), actualSlotNumber);
        assertEquals(munchy.getProductName(), actualProductName);
        assertEquals(munchy.getStock(), actualStock);
        assertEquals(munchy.getDispenseMessage(), actualMessage);
    }
}