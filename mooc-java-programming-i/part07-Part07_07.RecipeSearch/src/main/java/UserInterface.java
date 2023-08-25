import java.util.Scanner;
import java.nio.file.Paths;

public class UserInterface {
    private Scanner scanner;
    private RecipeList recipes;
    
    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
        this.recipes = new RecipeList();
    }
    
    public void start() {
        
        System.out.println("File to read:");
        String filename = scanner.nextLine();
        System.out.println("");
                
        this.recipes.readRecipesFromFile(filename);
        
        System.out.println("Commands: ");
        System.out.println("list - lists the recipes");
        System.out.println("stop - stops the program");
        System.out.println("find name - searches recipes by name");
        System.out.println("find cooking time - searches recipes by cooking time");
        System.out.println("find ingredient - searches recipes by ingredient");
        
        while(true) {
            System.out.println("");
            System.out.println("Enter command: ");
            String command = scanner.nextLine();
            
            if (command.equals("stop")) {
                break;
            }
            
            if (command.equals("list")) {
                this.recipes.list();
            } else if (command.equals("find name")) {
                this.findName();
            } else if (command.equals("find cooking time")) {
                this.findCookingTime();
            } else if (command.equals("find ingredient")) {
                this.findIngredient();
            }
                        
        }
        
    }
    
    public void findName() {
        System.out.println("Searched word:");
        String name = scanner.nextLine();
        this.recipes.findName(name);
    }
    
    public void findCookingTime() {
        System.out.println("Max cooking time:");
        int maxCookingTime = Integer.valueOf(scanner.nextLine());
        this.recipes.findCookingTime(maxCookingTime);
    }
    
    public void findIngredient() {
        System.out.println("Ingredient:");
        String ingredient = scanner.nextLine();
        this.recipes.findIngredient(ingredient);
    }
}
