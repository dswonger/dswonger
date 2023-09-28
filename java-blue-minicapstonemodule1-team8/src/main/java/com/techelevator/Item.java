package com.techelevator;

import java.math.BigDecimal;

public abstract class Item {

    private BigDecimal price;
    private String slotLocation;
    private String productName;
    private int stock = 5;
    private int fullPriceSaleCounter = 0;
    private int discountSaleCounter = 0;

    public int getFullPriceSaleCounter() {
        return fullPriceSaleCounter;
    }

    public int getDiscountSaleCounter() {
        return discountSaleCounter;
    }

    public void setDispenseMessage(String dispenseMessage) {
        this.dispenseMessage = dispenseMessage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getSlotLocation() {
        return slotLocation;
    }

    public String getProductName() {
        return productName;
    }

    public int getStock() {
        return stock;
    }

    public String getDispenseMessage() {
        return dispenseMessage;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    private String dispenseMessage;

    public Item(BigDecimal price, String slotLocation, String productName, int stock, String dispenseMessage, int fullPriceSaleCounter, int discountSaleCounter) {
        this.price = price;
        this.slotLocation = slotLocation;
        this.productName = productName;
        this.stock = stock;
        this.dispenseMessage = dispenseMessage;
        this.fullPriceSaleCounter = fullPriceSaleCounter;
        this.discountSaleCounter = discountSaleCounter;
    }

    public String dispense() {
        System.out.println(getProductName() + " $" + getPrice());
        return getDispenseMessage();
    }

    public int takeOutOfStock() {
        this.stock--;
        return this.stock;
    }

    public BigDecimal discountItemPrice(Item item, int saleCounter) {
        if (saleCounter % 2 == 1) {
            item.price = item.getPrice().subtract(BigDecimal.valueOf(1));
            item.discountSaleCounter++;
        } else {item.fullPriceSaleCounter++;}
        return item.price;
    }

    public BigDecimal resetItemPrice(Item item, int saleCounter) {
        if (saleCounter % 2 == 1) {
            item.price = item.getPrice().add(BigDecimal.valueOf(1));
        }
        return item.price;
    }
}
