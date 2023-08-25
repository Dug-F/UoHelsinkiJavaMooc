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
    private TodoList list;
    
    
    public UserInterface(TodoList list, Scanner scanner) {
        this.scanner = scanner;
        this.list = list;
    }
    
    public void start() {
        
        while(true) {
            System.out.println("Command:");
            String command = this.scanner.nextLine();
            
            if (command.equals("stop")) {
                break;
            }
            
            this.command(command);
        }
    }
    
    public void command(String command) {
        if (command.equals("add")) {
            this.add();
        } else if (command.equals("list")) {
            this.list();
        } else if (command.equals("remove")) {
            this.remove();
        }
    }
    
    public void add() {
        System.out.println("To add:");
        String task = this.scanner.nextLine();
        this.list.add(task);
    }
    
    public void remove() {
        System.out.println("Which one is removed?");
        int number = Integer.valueOf(this.scanner.nextLine());
        this.list.remove(number);
    }
    
    public void list() {
        this.list.print();
    }
}
