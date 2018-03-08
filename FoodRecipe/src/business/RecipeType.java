/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import acq.*;

/**
 *
 * @author Bruger
 */
public enum RecipeType
{

    STARTER("Starter"), MAIN_COURSE("Main Course"),
    DESSERT("Dessert"), BREAKFAST("Breakfast"),
    LUNCH("Lunch"), SNACK("Snack"), DRINK("Drink");

    RecipeType(String string)
    {
        this.string = string;
    }

    private String string;

    @Override
    public String toString()
    {
        return string;
    }

    public boolean equals(String string)
    {
        if (this.string.equalsIgnoreCase(string))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
