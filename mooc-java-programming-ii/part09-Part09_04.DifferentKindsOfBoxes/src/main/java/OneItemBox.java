import java.util.HashMap;

import java.util.HashMap;

public class OneItemBox extends Box {
    
    public OneItemBox() {
    }
    
    public void add(Item item) {
        if (this.contents.isEmpty()) {
            contents.put(item, item);
        }
    }
    
    public boolean isInBox(Item item) {
        return this.contents.containsKey(item);
    }
}
