import java.util.HashMap;

public class BoxWithMaxWeight extends Box {
    private int capacity;

    public BoxWithMaxWeight(int capacity) {
        this.capacity = capacity;
    }
    
    public void add(Item item) {
        int currentWeight = 0;
        for (Item existingItem : this.contents.values()) {
            currentWeight += existingItem.getWeight();
        }
        
        if ((currentWeight + item.getWeight()) <= this.capacity) {
            contents.put(item, item);
        }
    }
    
    public boolean isInBox(Item item) {
        return this.contents.containsKey(item);
    }
}
