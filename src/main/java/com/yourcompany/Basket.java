package com.yourcompany;

import java.io.*;
import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Basket {
    private String[] goodsList;
    private int[] quantityList;
    private int[] prices;

    public Basket() {}
    public Basket(String[] goodsList, int[] prices) {
        this.goodsList = goodsList;
        this.prices = prices;
    }

    public static Basket loadFromTxtFile(File textFile) {
        String[] goodsList;
        int[] quantityList;
        int[] prices;
        StringBuilder text = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(textFile))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                text.append(line);
                text.append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Object[] o = text.toString().lines().toArray();
        goodsList = o[0].toString().split(" ");
        prices = Arrays.stream(o[1].toString().split(" ")).mapToInt(n -> Integer.parseInt(n)).toArray();
        quantityList = Arrays.stream(o[2].toString().split(" ")).mapToInt(n -> Integer.parseInt(n)).toArray();

        Basket basket = new Basket(goodsList, prices);
        basket.setQuantitylist(quantityList);
        return basket;
    }

    public void addToCart(int productNum, int quantity) {
        this.quantityList[productNum] += quantity;
    }

    public void printCart() {
        System.out.println("The product list for purchase:");
        for (int i = 0; i < goodsList.length; i++) {
            System.out.printf("%d. %s %d rub/piece\n", i + 1, goodsList[i], prices[i]);
        }
    }
//если тут выбрасывать исключение наверх, а не try  ресурсами, то нужно закрывать поток!!точнее
    public void saveTxt(File textFile) {
        try (BufferedWriter out = new BufferedWriter(new PrintWriter(textFile))) {
            for (String s : goodsList)
                out.append(s + " ");
            out.newLine();
            for (int i : prices)
                out.append(i + " ");
            out.newLine();
            for (int i : quantityList)
                out.append(i + " ");
            out.newLine();
                out.flush();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void result() {
        int total = 0;
        int lineNumber = 1;
        int productIterationNumber = 0;
        System.out.println("Orders:");
        for (int i : this.quantityList) {
            if (i != 0) {
                int priceInOrder = i * this.prices[productIterationNumber];
                total += priceInOrder;
                System.out.printf("%d. %s %d pieces %d rub/piece %d rub in order\n",
                        lineNumber, this.goodsList[productIterationNumber], i,
                        this.prices[productIterationNumber], priceInOrder);
                lineNumber++;
            }
            productIterationNumber++;
        }
        System.out.println("Total: " + total + " rubles");
    }
    public String[] getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(String[] goodsList) {
        this.goodsList = goodsList;
    }

    public int[] getQuantitylist() {
        return quantityList;
    }

    public void setQuantitylist(int[] quantitylist) {
        this.quantityList = quantitylist;
    }

    public int[] getPrices() {
        return prices;
    }

    public void setPrices(int[] prices) {
        this.prices = prices;
    }

    public void toJson(File fileName) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            bufferedWriter.write(gson.toJson(this));
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Basket fromJson(File jsonFile) {
        Basket basket;
//        GsonBuilder gsonBuilder = new GsonBuilder();
//        Gson gson = gsonBuilder.create();
        Gson gson = new Gson();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(jsonFile))) {
            basket = gson.fromJson(bufferedReader, Basket.class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return basket;
    }
}
