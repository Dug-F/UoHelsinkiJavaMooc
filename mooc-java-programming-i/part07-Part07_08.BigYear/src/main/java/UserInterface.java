import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface {
    private Scanner scanner;
    private ArrayList<Bird> birds;
    
    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
        this.birds = new ArrayList<>();
    }
    
    public void start() {
        while(true) {
            System.out.println("?");
            String command = scanner.nextLine();
            
            if (command.equals("Quit")) {
                break;
            }
            
            if (command.equals("Add")) {
                this.add();
            } else if (command.equals("Observation")) {
                this.observation();
            } else if (command.equals("All")) {
                this.printAll();
            } else if (command.equals("One")) {
                this.printOne();
            }
        }
    }
    
    public void add() {
        System.out.println("Name:");
        String name = scanner.nextLine();
        System.out.println("Name in Latin:");
        String latinName = scanner.nextLine();

        this.birds.add(new Bird(name, latinName));
    }
    
    public void observation() {
        System.out.println("Bird?");
        String name = scanner.nextLine();
        
        for (Bird bird : birds) {
            if (bird.getName().equals(name)) {
                bird.addObservation();
                return;
            }
        }
        
        System.out.println("Not a bird!");
    }
    
    public void printOne() {
        System.out.println("Bird?");
        String name = scanner.nextLine();
        
        for (Bird bird : birds) {
            if (bird.getName().equals(name)) {
                bird.print();
                return;
            }
        }
        
        System.out.println("Not a bird!");
    }
    
    public void printAll() {
        for (Bird bird : birds) {
            bird.print();
        }
    }
}
