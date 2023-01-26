package com.yourcompany;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File settingFile = new File("shop.xml");
        Setting setting = new Setting(settingFile);
        ClientLog clientLog = new ClientLog();
        Scanner scanner = new Scanner(System.in);

        File file = new File(setting.getLoadFileName());
        Basket basket = null;
        if (!file.exists()) {
            try {
                if (setting.getLoadFormat().equalsIgnoreCase("json")) {
                    Files.copy(Path.of("template.json"), Path.of(String.valueOf(file)));
                    basket = Basket.fromJson(file);
                } else {
                    Files.copy(Path.of("template.txt"), Path.of(String.valueOf(file)));
                    basket = Basket.loadFromTxtFile(file);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            if (setting.getLoadFormat().equalsIgnoreCase("json")) {
                if (setting.getLoadEnabled()) {
                    basket = Basket.fromJson(file);
                } else {
                    basket = Basket.fromJson(new File("template.json"));
                }
            } else {
                if (setting.getLoadEnabled()) {
                    basket = Basket.loadFromTxtFile(file);
                } else {
                    basket = Basket.loadFromTxtFile(new File("template.txt"));
                }
            }
        }
        basket.printCart();
        while (true) {
            System.out.println("Choose a product, quantity or input end");
            System.out.print(">>");
            String input = scanner.nextLine();
            if (input.toLowerCase().equals("end")) {
                basket.result();
                if (setting.getLogEnabled()) {
                    File logFile = new File(setting.getLogFileName());
                    clientLog.exportAsCSV(logFile);
                }
                break;
            }
            String[] parts = input.split(" ");
            if (parts.length != 2) {
                System.out.println("You haven't written two numbers, please try again");
                continue;
            }
// операция записи логов в список
            clientLog.log(parts[0], parts[1]);
            try {
                if (Integer.parseInt(parts[0]) > basket.getGoodsList().length || Integer.parseInt(parts[0]) <= 0) {
                    System.out.println("Please input a correct product number");
                    continue;
                }
                if (Integer.parseInt(parts[1]) < 0) {
                    System.out.println("Goods quantity should be a positive number," +
                            " please input a correct number");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("You entered not a number, please input a number");
                continue;
            }
            int productNumber = (Integer.parseInt(parts[0]) - 1);
            int quantity = Integer.parseInt(parts[1]);

            basket.addToCart(productNumber, quantity);
            if (setting.getSaveFormat().equalsIgnoreCase("json")) {
                if (setting.getSaveEnabled()) {
                    basket.toJson(new File(setting.getSaveFileName()));
                }
            } else {
                if (setting.getSaveEnabled()) {
                    basket.saveTxt(new File(setting.getSaveFileName()));                                                               //2 2
                }
            }
        }
    }
}