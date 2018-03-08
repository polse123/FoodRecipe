/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acq;

import java.util.Map;

/**
 *
 * @author Bruger
 */
public interface Savable {

    public Map<String, String> saveToMap();

    public abstract void createFromMap(Map<String, String> map);

}
