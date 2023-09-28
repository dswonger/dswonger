package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class DrinkTest {
    private Drink drink;

    @Before
    public void setup() {
        this.drink = new Drink(BigDecimal.valueOf(1.85), "A2", "Ginger Ayle", 5, "Glug Glug, Yum!");
    }
    @Test
    public void test_Drink() {

        BigDecimal actualPrice = BigDecimal.valueOf(1.85);
        String actualSlotNumber = "A2";
        String actualProductName = "Ginger Ayle";
        int actualStock = 5;
        String actualMessage = "Glug Glug, Yum!";
        assertEquals(drink.getPrice(), actualPrice);
        assertEquals(drink.getSlotLocation(), actualSlotNumber);
        assertEquals(drink.getProductName(), actualProductName);
        assertEquals(drink.getStock(), actualStock);
        assertEquals(drink.getDispenseMessage(), actualMessage);

    }


}

/*
so something like
Drink expectedResult = new Drink(BigDecimal(value)of(2.00), A4, "Papsi", 5, "Yummy Yummy, So Sweet!"
BigDecimal actualPrice = 2.00
String actualSlotNumber = "A4"
String actualProductName = "Papsi"
int actualStock = 5
String actualMessage = "Yummy, Yummy, So Sweet!"
assertEquals(expectedResult.getPrice, actualPrice)
assertEquals(expectedResult.getItemCode, actualSlotNumber)
assertEquals(expectedResult.getProductName, actualProductName)
assertEquals(expectedResult.getStock, actualStock)
assertEquals(expectedResult.getMessage, actualMessage)
 */