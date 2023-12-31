package application;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.List;


public class UserInterface {

    private Scanner scanner;
    private TodoDao database;

    public UserInterface(Scanner scanner, TodoDao database) {
        this.scanner = scanner;
        this.database = database;
    }

    public void start() throws SQLException {
        while (true) {
            System.out.println("");
            System.out.println("Enter command:");
            System.out.println("1) list");
            System.out.println("2) add");
            System.out.println("3) mark as done");
            System.out.println("4) remove");
            System.out.println("x) quit");

            System.out.print("> ");
            String command = this.scanner.nextLine();
            if (command.equals("x")) {
                break;
            }
            
            switch(command) {
                case "1":
                    list();
                    break;
                case "2":
                    add();
                    break;
                case "3":
                    markDone();
                    break;
                case "4":
                    remove();
                    break;
                default: 
                    System.out.println("invalid choice");
                    break;
            }

            // implement the functionality here
        }
        
        System.out.println("Thank you!");
    }

    private void list() throws SQLException {
        System.out.println("Listing the database contents");
        List<Todo> todos = database.list();
        todos.stream().forEach(todo -> System.out.println(todo));
    }
    
    private void add() throws SQLException {
        System.out.println("Adding a new todo");
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter description");
        String description = scanner.nextLine();
        Todo todo = new Todo(0, name, description, false);
        database.add(todo);
    }
    
    private void markDone() throws SQLException {
        System.out.println("Which todo should be marked as done (give the id)?");
        int id = Integer.valueOf(scanner.nextLine());
        database.markAsDone(id);
    }
    
    private void remove() throws SQLException {
        System.out.println("Which todo should be removed (give the id)?");
        int id = Integer.valueOf(scanner.nextLine());
        database.remove(id);
    }
    
}
