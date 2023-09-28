package com.techelevator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FinancialCLI {
    private BigDecimal currentMoneyProvided = new BigDecimal(0);
    private BigDecimal moneyFed;
    private String change;
    private BigDecimal quarters;
    private BigDecimal dimes;
    private BigDecimal nickels;
    private final double QUARTER = 0.25;
    private final double DIME = 0.10;
    private final double NICKEL = 0.05;
    private final double BOGODO = 1.00;
    private BigDecimal totalSalesTracker = BigDecimal.valueOf(0);
    public BigDecimal getTotalSalesTracker() {
        return totalSalesTracker;
    }

    public void setMoneyFed(BigDecimal moneyFed) {
        this.moneyFed = moneyFed;
    }

    public BigDecimal getCurrentMoneyProvided() {
        return currentMoneyProvided;
    }

    public BigDecimal getMoneyFed() {
        return moneyFed;
    }

    public void run() {
        System.out.println("testing");
    }
    public BigDecimal addToCurrentMoney(BigDecimal currentMoneyProvided, BigDecimal moneyFed) {
        this.currentMoneyProvided = currentMoneyProvided.add(moneyFed);
        return this.currentMoneyProvided;
    }

    public BigDecimal subtractFromCurrentMoney(BigDecimal currentMoneyProvided, BigDecimal money) {
        this.currentMoneyProvided = currentMoneyProvided.subtract(money);
        return this.currentMoneyProvided;
    }

    public String makeChange (BigDecimal currentMoneyProvided) {
        quarters = ((currentMoneyProvided.divide(BigDecimal.valueOf(QUARTER))).setScale(0, RoundingMode.DOWN));
        dimes = ((currentMoneyProvided.subtract(quarters.multiply(BigDecimal.valueOf(QUARTER)))).divide(BigDecimal.valueOf(DIME))).setScale(0, RoundingMode.DOWN);
        nickels = ((currentMoneyProvided.subtract(quarters.multiply(BigDecimal.valueOf(QUARTER)))).subtract(dimes.multiply(BigDecimal.valueOf(DIME))).divide(BigDecimal.valueOf(NICKEL))).setScale(0, RoundingMode.DOWN);
        change = "Your change is $" + currentMoneyProvided + ", which will be dispensed to you as" + "\n" + quarters + " quarters, " + dimes + " dime(s), & " + nickels + " nickel(s).";
        System.out.println(change);
        this.currentMoneyProvided = BigDecimal.valueOf(0);
        return change;
    }

    public BigDecimal addToTotalSalesTracker (Item item) {
        totalSalesTracker = totalSalesTracker.add(item.getPrice());
        return totalSalesTracker;
    }

}
