import java.util.Scanner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Doug
 */
public class UserInterface {
    private Scanner scanner;
    private JokeManager jokes;
    
    public UserInterface(JokeManager jokes, Scanner scanner) {
        this.scanner = scanner;
        this.jokes = jokes;
    }
    
    public void start() {
        while(true) {
            System.out.println("Commands:");
            System.out.println(" 1 - add a joke");
            System.out.println(" 2 - draw a joke");
            System.out.println(" 3 - list jokes");
            System.out.println(" X - stop");
            String command = scanner.nextLine();
            
            if (command.equals("X")) {
                break;
            }
            
            this.command(command);
        }
    }
    
    public void command(String command) {
        if (command.equals("1")) {
            this.add();
        } else if (command.equals("2")) {
            this.draw();
        } else if (command.equals("3")) {
            this.list();
        }
    }
    
    public void add() {
        System.out.println("Write the joke to be added:");
        String joke = this.scanner.nextLine();
        this.jokes.addJoke(joke);
    }
    
    public void draw() {
        System.out.println(this.jokes.drawJoke());
    }
    
    public void list() {
        this.jokes.printJokes();
    }
}
