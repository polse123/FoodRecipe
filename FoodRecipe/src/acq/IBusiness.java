/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acq;

import business.RecipeType;
import java.util.Set;

/**
 *
 * @author Bruger
 */
public interface IBusiness {
    
    void CreateRecipe(String name, RecipeType type, int time, String procedure, Set<String> ingredients);
}
