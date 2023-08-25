import java.util.ArrayList;

public class TodoList {
    private ArrayList<String> todoList;
    
    public TodoList() {
        this.todoList = new ArrayList<>();
    }
    
    public void add(String task) {
        this.todoList.add(task);
    }
    
    public void print() {
        for (int i = 1; i <= this.todoList.size(); i++) {
            System.out.println(i + ": " + this.todoList.get(i - 1));
        }
    }
    
    public void remove(int number){
        this.todoList.remove(number - 1);
    }
    
}
