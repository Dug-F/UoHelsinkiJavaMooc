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
public class Suitcase {
    private ArrayList<Item> items;
    private int maxWeight;

    public Suitcase(int maxWeight) {
        this.items = new ArrayList<>();
        this.maxWeight = maxWeight;
    }
    
    public void addItem(Item item) {
        if (item.getWeight() + this.totalWeight() > this.maxWeight) {
            return;
        }
        this.items.add(item);
    }
    
    public int totalWeight() {
        int weight = 0;
        for (Item item : this.items) {
            weight += item.getWeight();
        }
        
        return weight;
    }
    
    public String toString() {
        if (this.items.isEmpty()) {
            return "no items (0 kg)";
        }
        
        String suffix = "";
        if (this.items.size() > 1) {
            suffix = "s";
        }
        return this.items.size() + " item" + suffix  + "(" + this.totalWeight() + " kg)";
        
    }
    
    public void printItems() {
        for (Item item : this.items) {
            System.out.println(item);
        }
    }
    
    public Item heaviestItem() {
        if (this.items.isEmpty()) {
            return null;
        }
        
        Item heaviestItem = items.get(0);
        for (Item item : this.items) {
            if (item.getWeight() > heaviestItem.getWeight()) {
                heaviestItem = item;
            }
        }
        
        return heaviestItem;
    }
    
}


