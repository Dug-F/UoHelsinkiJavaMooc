import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface {
    private TodoList todoList;
    private Scanner scanner;
    
    public UserInterface(TodoList list, Scanner scanner) {
        this.todoList = list;
        this.scanner = scanner;
    }
    
    public void start() {
        while(true) {
            System.out.println("Command:");
            
            String command = scanner.nextLine();
            
            if (command.equals("stop")) {
                break;
            }
            
            if (command.equals("add")) {
                this.add();
            } else if (command.equals("list")) {
                this.todoList.print();
            } else if (command.equals("remove")) {
                this.remove();
            }
        }
    }
    
    public void add() {
        System.out.println("Task:");
        String task = scanner.nextLine();
        this.todoList.add(task);
    }
    
    public void remove() {
        System.out.println("Which task was completed?");
        int taskNumber = Integer.valueOf(scanner.nextLine());
        this.todoList.remove(taskNumber);
    }

}
