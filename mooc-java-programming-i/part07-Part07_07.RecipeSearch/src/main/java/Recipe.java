import java.util.ArrayList;

public class Recipe {
    private String name;
    private int cookingTime;
    private ArrayList<String> ingredients;
    
    public Recipe(String name, int cookingTime, ArrayList<String> ingredients) {
        this.name = name;
        this.cookingTime = cookingTime;
        this.ingredients = ingredients;
    }

    public String getName() {
        return this.name;
    }

    public int getCookingTime() {
        return this.cookingTime;
    }

    public boolean containsIngredient(String ingredient) {
        return this.ingredients.contains(ingredient);
    }
    
    public void list() {
        System.out.println(this.name + ", cooking time: " + this.cookingTime);
    }
    
    
}
