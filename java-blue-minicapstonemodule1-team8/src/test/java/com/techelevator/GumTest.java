package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class GumTest {
private Gum gum;
    @Before
    public void setUp() {
        this.gum = new Gum(BigDecimal.valueOf(1.65), "A1", "U-Chews", 5, "Chew Chew, Yum!");
    }

    @Test
    public void test_Gum() {

        BigDecimal actualPrice = BigDecimal.valueOf(1.65);
        String actualSlotNumber = "A1";
        String actualProductName = "U-Chews";
        int actualStock = 5;
        String actualMessage = "Chew Chew, Yum!";
        assertEquals(gum.getPrice(), actualPrice);
        assertEquals(gum.getSlotLocation(), actualSlotNumber);
        assertEquals(gum.getProductName(), actualProductName);
        assertEquals(gum.getStock(), actualStock);
        assertEquals(gum.getDispenseMessage(), actualMessage);

    }


}