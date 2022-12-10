package com.yourcompany;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class ClientLog {

    public void log(int productNum, int quantity) {

    }

    public void exportAsCSV(File txtFile) {

    }

    public static void toJson(Basket basket) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("basket.json"))) {
            bufferedWriter.write(gson.toJson(basket));
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Basket fromJson(File jsonFile) {
        Basket basket;
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
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
