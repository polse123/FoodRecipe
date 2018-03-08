/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.Set;

/**
 *
 * @author Frederik
 */
public class Recipe {

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
    private Set<Recipe> matches;

    //Tilbehør
    private Set<String> accessories;

    public Recipe(String name, RecipeType type, int time, String procedure, Set<String> ingredients) {
        this.name = name;
        this.type = type;
        this.time = time;
        this.procedure = procedure;
        this.ingredients = ingredients;
    }

    public Recipe(String name, RecipeType type, int time, String procedure, Set<String> ingredients, String pictureFile, Set<Recipe> matches, Set<String> accessories) {
        this.name = name;
        this.type = type;
        this.time = time;
        this.procedure = procedure;
        this.ingredients = ingredients;
        this.pictureFile = pictureFile;
        this.matches = matches;
        this.accessories = accessories;
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

    public Set<Recipe> getMatches() {
        return matches;
    }

    public void setMatches(Set<Recipe> matches) {
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

}
