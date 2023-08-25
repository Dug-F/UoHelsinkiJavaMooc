import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class RecipeList {
    private ArrayList<Recipe> recipes;
    
    public RecipeList() {
        this.recipes = new ArrayList<>();
    }
    
    public void list() {
        System.out.println("Recipes:");
        
        for (Recipe recipe : recipes) {
            recipe.list();
        }
    }
    
    public void findName(String name) {
        for (Recipe recipe : recipes) {
            if (recipe.getName().contains(name)) {
                recipe.list();
            }
        }
    }
    
    public void findIngredient(String ingredient) {
        for (Recipe recipe : recipes) {
            if (recipe.containsIngredient(ingredient)) {
                recipe.list();
            }
        } 
    }
    
    public void findCookingTime(int maxCookingTime) {
        for (Recipe recipe : recipes) {
            if (recipe.getCookingTime() <= maxCookingTime) {
                recipe.list();
            }
        }
    }
    
    public void readRecipesFromFile(String filename) {
        
        try(Scanner fileScanner = new Scanner(Paths.get(filename))) {
            while(fileScanner.hasNextLine()) {
                String name = fileScanner.nextLine();
                int cookingTime = Integer.valueOf(fileScanner.nextLine());
                ArrayList<String> ingredients = new ArrayList<>();
               
                while(fileScanner.hasNextLine()) {
                    String ingredient = fileScanner.nextLine();
                    if (ingredient.isEmpty()) {
                        break;
                    }
                    ingredients.add(ingredient);
                }
                
                this.recipes.add(new Recipe(name, cookingTime, ingredients));
            }
        }
        catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
    }
    
}
