import java.util.HashMap;

public class MisplacingBox extends Box {

    public MisplacingBox() {
    }

    public void add(Item item) {
        contents.put(item, item);
    }
    
    public boolean isInBox(Item item) {
        return false;
    }
    
}
