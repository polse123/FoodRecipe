package main;

import acq.IBusiness;
import business.BusinessFacade;
import business.RecipeType;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Søren Bendtsen
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code applicastiteston logic here
       // frederikstest
       // nikolajstest
       IBusiness business = new BusinessFacade();
       HashSet<String> ing = new HashSet<>();
       ing.add("oksekød");
       business.CreateRecipe("lagsagne", RecipeType.MAIN_COURSE, 90, "mix it all up", ing);
    }
    
}
