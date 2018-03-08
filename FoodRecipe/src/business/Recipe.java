/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author Frederik
 */
public class Recipe
{
    private String name;

    // Forret, hovedret,dessert, snack, kaffe ....
//    private String type;
    // minutes
    private int time;

    //Fremgangsmåde
    private String procedure;

    //Ingredienser
    private String ingredients;

    //Billede af det færdige resutat:
    private String pictureFile;

    // Retten passer til..
    private Recipe matches;

    //Tilbehør
    private String accessories;

    public Recipe(String name, int time, String procedure, String pictureFile)
    {
        this.name = name;
        this.time = time;
        this.procedure = procedure;
        this.pictureFile = pictureFile;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getTime()
    {
        return time;
    }

    public void setTime(int time)
    {
        this.time = time;
    }

    public String getProcedure()
    {
        return procedure;
    }

    public void setProcedure(String procedure)
    {
        this.procedure = procedure;
    }

    public String getPictureFile()
    {
        return pictureFile;
    }

    public void setPictureFile(String pictureFile)
    {
        this.pictureFile = pictureFile;
    }

    public Recipe getMatches()
    {
        return matches;
    }

    public void setMatches(Recipe matches)
    {
        this.matches = matches;
    }

    public String getIngredients()
    {
        return ingredients;
    }

    public void setIngredients(String ingredients)
    {
        this.ingredients = ingredients;
    }

    public String getAccessories()
    {
        return accessories;
    }

    public void setAccessories(String accessories)
    {
        this.accessories = accessories;
    }

}
