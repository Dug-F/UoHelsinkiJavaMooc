import java.util.Scanner;
import java.util.ArrayList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Doug
 */
public class TextUI {
    private Scanner scanner;
    private SimpleDictionary dict;
    
    public TextUI(Scanner scanner, SimpleDictionary dict) {
        this.scanner = scanner;
        this.dict = dict;
    }
    
    public void start() {
        
        while(true) {
            System.out.println("Command: ");
            String command = this.scanner.nextLine();

            if (command.equals("end")) {
                System.out.println("Bye bye!");
                break;
            }
            
            if (command.equals("add")) {
                System.out.println("Word:");
                String word = this.scanner.nextLine();
                System.out.println("Translation:");
                String translation = this.scanner.nextLine();
                this.dict.add(word, translation);
                
                continue;
            }
            
            if (command.equals("search")) {
                System.out.println("To be translated:");
                String search = this.scanner.nextLine();
                String translation = this.dict.translate(search);
                if (translation == null) {
                    System.out.println("Word " + search +" was not found");
                } else {
                    System.out.println("Translation: " + translation);
                }
                
                continue;
            }
            
            System.out.println("Unknown command");
        }

    }
    
}
