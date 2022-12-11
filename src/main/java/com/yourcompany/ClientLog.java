package com.yourcompany;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClientLog {
    private List<String[]> logs = new ArrayList<>();

    public static void readCSVFile(File txtFile) {
        try (CSVReader csvReader = new CSVReader(new FileReader(txtFile))) {
            List<String[]> logs = csvReader.readAll();
            for (String[] o : logs) {
                System.out.println(Arrays.toString(o));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void log(String productNum, String quantity) {
        logs.add(((productNum) + "," + quantity).split(","));
    }
    public void exportAsCSV(File txtFile) {
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(txtFile, true))) {
            csvWriter.writeAll(logs);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
