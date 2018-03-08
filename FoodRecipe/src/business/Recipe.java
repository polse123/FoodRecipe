/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import acq.Savable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Frederik
 */
public class Recipe implements Savable {

    private String name;

    // Forret, hovedret,dessert, snack, kaffe ....
    private RecipeType type;

    // minutes
    private int time;

    //Fremgangsmåde
    private String procedure;

    //Ingredienser
    private Set<String> ingredients;

    //Billede af det færdige resutat:
    private String pictureFile;

    // Retten passer til..
    private Set<String> matches;

    //Tilbehør
    private Set<String> accessories;

    public Recipe(String name, RecipeType type, int time, String procedure, Set<String> ingredients) {
        this.name = name;
        this.type = type;
        this.time = time;
        this.procedure = procedure;
        this.ingredients = ingredients;
        this.pictureFile = null;
        this.matches = new HashSet<>();
        this.accessories = new HashSet<>();
    }

    public Recipe(String name, RecipeType type, int time, String procedure, Set<String> ingredients, String pictureFile, Set<String> matches, Set<String> accessories) {
        this.name = name;
        this.type = type;
        this.time = time;
        this.procedure = procedure;
        this.ingredients = ingredients;
        this.pictureFile = pictureFile;
        this.matches = matches;
        this.accessories = accessories;
    }

    public Recipe(Map<String, String> map) {
        this.createFromMap(map);
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public String getPictureFile() {
        return pictureFile;
    }

    public void setPictureFile(String pictureFile) {
        this.pictureFile = pictureFile;
    }

    public Set<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<String> ingredients) {
        this.ingredients = ingredients;
    }

    public Set<String> getMatches() {
        return matches;
    }

    public void setMatches(Set<String> matches) {
        this.matches = matches;
    }

    public Set<String> getAccessories() {
        return accessories;
    }

    public void setAccessories(Set<String> accessories) {
        this.accessories = accessories;
    }

    public RecipeType getType() {
        return type;
    }

    public void setType(RecipeType type) {
        this.type = type;
    }

    @Override
    public Map<String, String> saveToMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Name", name);
        map.put("Type", type.toString());
        map.put("Time", "" + time);
        map.put("Procedure", procedure);
        map.put("PictureFile", pictureFile);
        map.put("ingredients", DataString.toString(ingredients));
        map.put("Accessories", DataString.toString(accessories));

        Set<String> matchesStringSet = new HashSet<>();
        for (String s : matches) {
            matchesStringSet.add(s);
        }
        map.put("Matches", DataString.toString(matchesStringSet));

        return map;
    }

    @Override
    public void createFromMap(Map<String, String> map) {
        this.name = null;
        this.type = null;
        this.time = 0;
        this.procedure = null;
        this.ingredients = new HashSet<String>();
        this.pictureFile = null;
        this.matches = new HashSet<>();
        this.accessories = new HashSet<>();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().equalsIgnoreCase("Name")) {
                this.name = entry.getValue();
            }
            if (entry.getKey().equalsIgnoreCase("Type")) {
                if (RecipeType.exists(entry.getValue())) {
                    this.type = RecipeType.getType(entry.getValue());
                }
            }
            if (entry.getKey().equalsIgnoreCase("Time")) {
                this.time = Integer.parseInt(entry.getValue());
            }
            if (entry.getKey().equalsIgnoreCase("Procedure")) {
                this.procedure = entry.getValue();
            }
            if (entry.getKey().equalsIgnoreCase("Ingredients")) {
                this.ingredients = DataString.toSet(entry.getValue());
            }
            if (entry.getKey().equalsIgnoreCase("PictureFile")) {
                this.pictureFile = entry.getValue();
            }
            if (entry.getKey().equalsIgnoreCase("Matches")) {
                this.matches = DataString.toSet(entry.getValue());
            }
            if (entry.getKey().equalsIgnoreCase("Accessories")) {
                this.accessories = DataString.toSet(entry.getValue());
            }
        }
    }

}
