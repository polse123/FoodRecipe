/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acq;

import java.util.Map;
import business.DataString;

/**
 *
 * @author Bruger
 */
public interface IDataString {

    public static String toString(Map<String, String> map) {
        return DataString.toString(map);
    }
    
    public static Map<String, String> toMap(String string) {
        return DataString.toMap(string);
    }

}
