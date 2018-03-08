/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Bruger
 */
public class XMLHandler implements SavableLoadable {

    private String fileName;

    public XMLHandler(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Map<String, String> load() {

        Map<String, String> map = new LinkedHashMap<>();
        StringBuilder xml = new StringBuilder();
        try {
            File f = new File(fileName);
            Scanner outputStream = new Scanner(f);
            while (outputStream.hasNextLine()) {
                xml.append(outputStream.nextLine());
            }
            outputStream.close();

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new ByteArrayInputStream(xml.toString().getBytes()));
            NodeList nodeList = doc.getDocumentElement().getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                map.put(nodeList.item(i).getNodeName(), nodeList.item(i).getChildNodes().item(0).getNodeValue());
            }

        } catch (FileNotFoundException e) {
            System.err.println("File " + fileName + " not found");
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public boolean save(Map<String, String> map) {
        boolean successful = false;
        StringBuilder buffer = new StringBuilder();

        buffer.append("<RecipeData>\n");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            buffer.append("<").append(entry.getKey()).append(">");
            buffer.append(entry.getValue());
            buffer.append("</").append(entry.getKey()).append(">\n");
        }
        buffer.append("</RecipeData>\n");

        File file = new File(fileName);
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write(buffer.toString());
            fileWriter.close();
            successful = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return successful;
    }

    @Override
    public boolean doesFileExist(String fileName) {
        File file = new File(fileName);
        return file.exists();
    }

    @Override
    public boolean deleteFile(String fileName) {
        if (doesFileExist(fileName)) {
            File file = new File(fileName);
            return file.delete();
        }
        return false;
    }

}
