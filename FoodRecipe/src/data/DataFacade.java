/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import acq.*;
import business.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Bruger
 */
public class DataFacade implements IData {

    private SavableLoadable handler;

    public DataFacade() {
        handler = new XMLHandler("RecipeData.xml");
    }

    public void save(Set<Savable> savables) {
        Map<String, String> mapOfSavables = new HashMap<>();
        for (Savable s : savables) {
            mapOfSavables.put(s.toString(), IDataString.toString(s.saveToMap()));
        }
        handler.save(mapOfSavables);
    }

    public void saveRecipes(Set<Recipe> savables) {
        Map<String, String> mapOfSavables = new HashMap<>();
        for (Recipe r : savables) {
            mapOfSavables.put(r.toString(), IDataString.toString(r.saveToMap()));
        }
        handler.save(mapOfSavables);
    }

    public Map<String, String> load() {
        return handler.load();
    }

}
