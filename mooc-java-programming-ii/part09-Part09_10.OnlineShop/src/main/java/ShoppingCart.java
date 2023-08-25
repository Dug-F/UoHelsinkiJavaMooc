import java.util.Map;
import java.util.HashMap;

public class ShoppingCart {
    private Map<String, Item> items;

    public ShoppingCart() {
        this.items = new HashMap<>();
    }
    
    public void add(String product, int price) {
        if (items.putIfAbsent(product, new Item(product, 1, price)) != null) {
            this.items.get(product).increaseQuantity();
        }
    }
    
    public int price() {
        int total = 0;
        for (Item item : this.items.values()) {
            total += item.price();
        }
        return total;
    }
    
    public void print() {
        for (Item item : this.items.values()) {
            System.out.println(item);
        }
    }
    
    
}


