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
public class Stack {
    private ArrayList<String> stack;
    
    public Stack() {
        this.stack = new ArrayList<>();
    }
    
    public boolean isEmpty() {
        return this.stack.size() == 0;
    }
    
    public void add(String value) {
        this.stack.add(value);
    }
    
    public ArrayList<String> values() {
        ArrayList<String> newList = new ArrayList<>();
        for (String entry : this.stack) {
            newList.add(entry);
        }
        return newList;
    }
    
    public String take() {
        if (this.stack.size() == 0) {
            return "";
        }
        
        return this.stack.remove(this.stack.size() - 1);
    }
}
