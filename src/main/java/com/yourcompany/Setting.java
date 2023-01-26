package com.yourcompany;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

public class Setting {
    private boolean loadEnabled;
    private String loadFileName;
    private String loadFormat;
    private boolean saveEnabled;
    private String saveFileName;
    private String saveFormat;
    private boolean logEnabled;
    private String logFileName;

    public Setting(File settingfile) {
        importXMLElements(settingfile);
    }
//    public String[] getElement(Document document, String getElementsByTagName) {
//        String[] elements = new String[3];
//        NodeList nodeList = document.getElementsByTagName(getElementsByTagName);
//        Node node = nodeList.item(0);
//        if (Node.ELEMENT_NODE == node.getNodeType()) {
//            Element element = (Element) node;
//            elements[0] = element.getElementsByTagName("enabled").item(0).getTextContent();
//            elements[1] = element.getElementsByTagName("fileName").item(0).getTextContent();
//            if (element.getChildNodes().item(5) != null) {
//                elements[2] = element.getElementsByTagName("format").item(0).getTextContent();
//            }
//        }
//        return elements;
//    }

    public void importXMLElements(File file) {
//        String[][] elementsArray = new String[3][];
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);

            XPath xPath = XPathFactory.newInstance().newXPath();

            boolean doLoad1 = Boolean.parseBoolean(xPath.compile("./config/load/enabled").evaluate(document));

            String loadFileName1 = xPath.compile("./config/load/fileName").evaluate(document);

            String loadFormat1 = xPath.compile("./config/load/format").evaluate(document);


            System.out.println(doLoad1);
            System.out.println(loadFileName1);
            System.out.println(loadFormat1);


            boolean doLoad2 = Boolean.parseBoolean(xPath.compile("./config/save/enabled").evaluate(document));

            String loadFileName2 = xPath.compile("./config/save/fileName").evaluate(document);

            String loadFormat2 = xPath.compile("./config/save/format").evaluate(document);


            System.out.println(doLoad2);
            System.out.println(loadFileName2);
            System.out.println(loadFormat2);


            boolean doLoad3 = Boolean.parseBoolean(xPath.compile("./config/log/enabled").evaluate(document));

            String loadFileName3 = xPath.compile("./config/log/fileName").evaluate(document);



            System.out.println(doLoad3);
            System.out.println(loadFileName3);






//            elementsArray[0] = getElement(document, "load");
//            elementsArray[1] = getElement(document, "save");
//            elementsArray[2] = getElement(document, "log");

            loadEnabled = doLoad1;
            loadFileName = loadFileName1;
            loadFormat = loadFormat1;
            saveEnabled = doLoad1;
            saveFileName = loadFileName2;
            saveFormat = loadFormat2;
            logEnabled = doLoad3;
            logFileName = loadFileName3;

        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (XPathExpressionException e) {
            throw new RuntimeException(e);
        }
//        return elementsArray;
    }

    public boolean getLoadEnabled() {
        return loadEnabled;
    }

    public String getLoadFileName() {
        return loadFileName;
    }

    public void setLoadFileName(String loadFileName) {
        this.loadFileName = loadFileName;
    }

    public String getLoadFormat() {
        return loadFormat;
    }

    public void setLoadFormat(String loadFormat) {
        this.loadFormat = loadFormat;
    }

    public boolean getSaveEnabled() {
        return saveEnabled;
    }

    public String getSaveFileName() {
        return saveFileName;
    }

    public void setSaveFileName(String saveFileName) {
        this.saveFileName = saveFileName;
    }

    public String getSaveFormat() {
        return saveFormat;
    }

    public void setSaveFormat(String saveFormat) {
        this.saveFormat = saveFormat;
    }

    public boolean getLogEnabled() {
        return logEnabled;
    }

    public String getLogFileName() {
        return logFileName;
    }

    public void setLogFileName(String logFileName) {
        this.logFileName = logFileName;
    }
}
