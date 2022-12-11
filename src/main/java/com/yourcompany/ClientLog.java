package com.yourcompany;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import org.w3c.dom.*;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClientLog {
   private List<String[]> logs = new ArrayList<>();
    public void log(String productNum, String quantity) {
        logs.add(((productNum) + "," + quantity).split(","));
    }
    public void exportAsCSV(File txtFile) {
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(txtFile ,true))) {
            csvWriter.writeAll(logs);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
public static void readCSVFile(File txtFile) {
      try(CSVReader csvReader = new CSVReader(new FileReader(txtFile))) {
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

//////для тестирования ClientLog
    public static void main(String[] args) {
        System.out.println(Arrays.toString(load()));
    }

//    блок load говорит нужно ли загружать данные корзины при старте программы из файла (enabled),
//    указывает имя этого файла (fileName) и формат (json или text). Ваша программа должна вести себя соответствующим образом.

//    блок save говорит нужно ли сохранять данные корзины после каждого ввода, куда и в каком формате (text или json).
//    блок log говорит нужно ли сохранять лог при завершении программы и в какой файл; формат лога всегда csv.
    public static String[] load() {
        String[] param = new String[3];
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(new File("shop.xml"));

            NodeList nodeList = document.getChildNodes();

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                Element element = null;
                if (Node.ELEMENT_NODE == node.getNodeType()) {
                    element = (Element) node;
                }
//                System.out.println(element.getTextContent());
                param[0] = element.getElementsByTagName("enabled").item(0).getTextContent();
                param[1] = element.getElementsByTagName("fileName").item(0).getTextContent();
                param[2] = element.getElementsByTagName("format").item(0).getTextContent();

            }
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }


        return param;
   }

   public static void save() {

   }
   public static void log() {

   }

}
