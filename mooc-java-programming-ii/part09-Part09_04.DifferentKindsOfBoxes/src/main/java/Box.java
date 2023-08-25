import java.util.HashMap;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Box {
    protected HashMap<Item, Item> contents;
    
    protected Box() {
        this.contents = new HashMap<>();
    }
    
    public abstract void add(Item item);

    public void add(ArrayList<Item> items) {
        for (Item item : items) {
            Box.this.add(item);
        }
    }

    public abstract boolean isInBox(Item item);
}
