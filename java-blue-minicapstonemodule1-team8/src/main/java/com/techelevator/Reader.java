package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Reader {
    private File vendingOptions = new File("main.csv");
    List<Item> vendingOptionCodeNamePrice = new ArrayList<>();
    public Reader (List<Item> vendingOptionCodeNamePrice) {
      this.vendingOptionCodeNamePrice = vendingOptionCodeNamePrice;
    }

    public void read () {
        try (Scanner reader = new Scanner(vendingOptions)) {
            while (reader.hasNextLine()) {
                String vendingOptionsLine = reader.nextLine();
                String[] vendingOptionsLineSplit = vendingOptionsLine.split(",");
                if (Objects.equals(vendingOptionsLineSplit[3], "Candy")) {
                    vendingOptionCodeNamePrice.add(new Candy(BigDecimal.valueOf(Double.parseDouble(vendingOptionsLineSplit[2])), vendingOptionsLineSplit[0], vendingOptionsLineSplit[1], 5, "Yummy Yummy, So Sweet!", 0, 0));
                } else if (Objects.equals(vendingOptionsLineSplit[3], "Gum")) {
                    vendingOptionCodeNamePrice.add(new Gum(BigDecimal.valueOf(Double.parseDouble(vendingOptionsLineSplit[2])), vendingOptionsLineSplit[0], vendingOptionsLineSplit[1], 5, "Chew Chew, Yum!", 0, 0));
                } else if (Objects.equals(vendingOptionsLineSplit[3], "Munchy")) {
                    vendingOptionCodeNamePrice.add(new Munchy(BigDecimal.valueOf(Double.parseDouble(vendingOptionsLineSplit[2])), vendingOptionsLineSplit[0], vendingOptionsLineSplit[1], 5, "Crunch Crunch, Yum!", 0, 0));
                } else if (Objects.equals(vendingOptionsLineSplit[3], "Drink")) {
                    vendingOptionCodeNamePrice.add(new Drink(BigDecimal.valueOf(Double.parseDouble(vendingOptionsLineSplit[2])), vendingOptionsLineSplit[0], vendingOptionsLineSplit[1], 5, "Glug Glug, Yum!", 0, 0));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error! Please try again or contact a technician.");
        } catch (ArrayIndexOutOfBoundsException f) {
            System.out.println("Error! File: <" + vendingOptions.getPath() + "> has been corrupted.");
            System.exit(0);
        }
    }
}
//Reader reader = new Reader(vendingOptionCodeNamePrice)
//reader.read