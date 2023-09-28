package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;;

public class Logger {
    public Logger(File logger) {
        this.logger = logger;
    }
    private File logger;
    public void write (String message) {

         String pattern = "MM/dd/yyyy hh:mm:ss a";
         SimpleDateFormat date = new SimpleDateFormat(pattern);
         String timestamp = date.format(new Date());
        try{
            File newFile = new File ("Logger.txt");
            PrintWriter writer = null;

            if(newFile.exists()) {
                writer = new PrintWriter(new FileOutputStream(newFile.getAbsoluteFile(), true));
            }else{
                writer = new PrintWriter(newFile.getAbsoluteFile());
            }
            writer.append(timestamp + " " + message + "\n");
            writer.flush();
            writer.close();
        }catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    public void ledge (List<Item> vendingOptionCodeNamePrice, BigDecimal totalSalesTracker) {

        String pattern = "MM-dd-yyyy_hh-mm-ss-a";
        SimpleDateFormat date = new SimpleDateFormat(pattern);
        String timestamp = date.format(new Date());
        try{
            File newFile = new File ((timestamp + "-sale-report.txt"));
            PrintWriter writer = null;

            if(newFile.exists()) {
                writer = new PrintWriter(new FileOutputStream(newFile.getAbsoluteFile(), true));
            }else{
                writer = new PrintWriter(newFile.getAbsoluteFile());
            }
            for (Item item: vendingOptionCodeNamePrice) {
                writer.append(item.getProductName() + "|" + item.getFullPriceSaleCounter() + "|" + item.getDiscountSaleCounter() + "\n");
            }
            writer.append("**TOTAL SALES** $" + totalSalesTracker);
            writer.flush();
            writer.close();
        }catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

}
