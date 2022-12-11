package com.yourcompany;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Setting {
    private String loadEnabled;
    private String loadFileName;
    private String loadFormat;
    private String saveEnabled;
    private String saveFileName;
    private String saveFormat;
    private String logEnabled;
    private String logFileName;

    public Setting(File settingfile) {
        importXMLElements(settingfile);
    }

    public String[] getElement(Document document, String getElementsByTagName) {
        String[] elements = new String[3];
        NodeList nodeList = document.getElementsByTagName(getElementsByTagName);
        Node node = nodeList.item(0);
        if (Node.ELEMENT_NODE == node.getNodeType()) {
            Element element = (Element) node;
            elements[0] = element.getElementsByTagName("enabled").item(0).getTextContent();
            elements[1] = element.getElementsByTagName("fileName").item(0).getTextContent();
            if (element.getChildNodes().item(5) != null) {
                elements[2] = element.getElementsByTagName("format").item(0).getTextContent();
            }
        }
        return elements;
    }

    public String[][] importXMLElements(File file) {
        String[][] elementsArray = new String[3][];
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);

            elementsArray[0] = getElement(document, "load");
            elementsArray[1] = getElement(document, "save");
            elementsArray[2] = getElement(document, "log");

            loadEnabled = elementsArray[0][0];
            loadFileName = elementsArray[0][1];
            loadFormat = elementsArray[0][2];
            saveEnabled = elementsArray[1][0];
            saveFileName = elementsArray[1][1];
            saveFormat = elementsArray[1][2];
            logEnabled = elementsArray[2][0];
            logFileName = elementsArray[2][1];

        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
        return elementsArray;
    }


    public String getLoadEnabled() {
        return loadEnabled;
    }

    public String getLoadFileName() {
        return loadFileName;
    }

    public String getLoadFormat() {
        return loadFormat;
    }

    public String getSaveEnabled() {
        return saveEnabled;
    }

    public String getSaveFileName() {
        return saveFileName;
    }

    public String getSaveFormat() {
        return saveFormat;
    }

    public String getLogEnabled() {
        return logEnabled;
    }

    public String getLogFileName() {
        return logFileName;
    }

    public void setLoadEnabled(String loadEnabled) {
        this.loadEnabled = loadEnabled;
    }

    public void setLoadFileName(String loadFileName) {
        this.loadFileName = loadFileName;
    }

    public void setLoadFormat(String loadFormat) {
        this.loadFormat = loadFormat;
    }

    public void setSaveEnabled(String saveEnabled) {
        this.saveEnabled = saveEnabled;
    }

    public void setSaveFileName(String saveFileName) {
        this.saveFileName = saveFileName;
    }

    public void setSaveFormat(String saveFormat) {
        this.saveFormat = saveFormat;
    }

    public void setLogEnabled(String logEnabled) {
        this.logEnabled = logEnabled;
    }

    public void setLogFileName(String logFileName) {
        this.logFileName = logFileName;
    }
}
