/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import acq.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class DataString implements IDataString {

    public static String toString(Set<String> set) {
        StringBuilder buffer = new StringBuilder();

        for (String s : set) {
            buffer.append("|" + s + "#");
        }

        return buffer.toString();
    }

    public static Set<String> toSet(String string) {
        Set<String> set = new HashSet<>();
        Scanner sc = new Scanner(string);
        int indexStart = 0;
        int lastIndexStart = -1;
        int indexEnd = 0;
        int lastIndexeEnd = -1;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            indexStart = line.indexOf('|', lastIndexStart + 1);
            indexEnd = line.indexOf('#', lastIndexeEnd + 1);
            String value = line.substring(indexStart + 1, indexEnd);
            set.add(value);
        }

        return set;
    }

    public static String toString(Map<String, String> map) {
        StringBuilder buffer = new StringBuilder();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            buffer.append("<").append(entry.getKey()).append(">");
            buffer.append(entry.getValue());
            buffer.append("</").append(entry.getKey()).append(">\n");
        }

        return buffer.toString();
    }

    public static Map<String, String> toMap(String string) {
        Map<String, String> map = new HashMap<>();
        Scanner sc = new Scanner(string);

        try {
            /*
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                int keyIndexStart = line.indexOf('<');
                int keyIndexEnd = line.indexOf('>');
                int valueIndexEnd = line.indexOf('<', keyIndexEnd);
                String key = line.substring(keyIndexStart + 1, keyIndexEnd);
                String value = line.substring(keyIndexEnd + 1, valueIndexEnd);
                map.put(key, value);
            }
             //*/

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new ByteArrayInputStream(string.getBytes()));
            NodeList nodeList = doc.getDocumentElement().getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                map.put(nodeList.item(i).getNodeName(), nodeList.item(i).getChildNodes().item(0).getNodeValue());
            }
            //*/

        } catch (IOException ex) {
            Logger.getLogger(DataString.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(DataString.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(DataString.class.getName()).log(Level.SEVERE, null, ex);
        }

        return map;
    }

}
