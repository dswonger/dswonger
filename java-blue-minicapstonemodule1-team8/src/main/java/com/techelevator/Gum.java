package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Item {
    public Gum(BigDecimal price, String slotLocation, String productName, int stock, String dispenseMessage, int fullPriceSaleCounter, int discountSaleCounter) {
        super(price, slotLocation, productName, stock, dispenseMessage, fullPriceSaleCounter, discountSaleCounter);
    }
}
