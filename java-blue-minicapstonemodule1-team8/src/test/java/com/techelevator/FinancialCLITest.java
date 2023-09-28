package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class FinancialCLITest {
    private FinancialCLI financialCLI;
    @Before
    public void setUp() {
        this.financialCLI = new FinancialCLI();
    }

    @Test
    public void makeChange() {

        String expectedResult = "Your change is $" + BigDecimal.valueOf(4.65) + ", which will be dispensed to you as" + "\n" + 18 + " quarters, " + 1 + " dime(s), & " + 1 + " nickel(s).";
        String actualResult = financialCLI.makeChange(BigDecimal.valueOf(4.65));

        assertEquals(expectedResult, actualResult);

    }
    @Test
    public void makeChange_2() {

        String expectedResult = "Your change is $" + BigDecimal.valueOf(0) + ", which will be dispensed to you as" + "\n" + 0 + " quarters, " + 0 + " dime(s), & " + 0 + " nickel(s).";
        String actualResult = financialCLI.makeChange(BigDecimal.valueOf(0));

        assertEquals(expectedResult, actualResult);

    }
    @Test
    public void addToCurrentMoneyTest() {

        BigDecimal expectedResult = BigDecimal.valueOf(0);
        BigDecimal actualResult = financialCLI.addToCurrentMoney(BigDecimal.valueOf(0), BigDecimal.valueOf(0));

        assertEquals(expectedResult, actualResult);

    }
    @Test
    public void subtractFromCurrentMoneyTest() {

        BigDecimal expectedResult = BigDecimal.valueOf(4);
        BigDecimal actualResult = financialCLI.subtractFromCurrentMoney(BigDecimal.valueOf(4), BigDecimal.valueOf(0));

        assertEquals(expectedResult, actualResult);

    }
}