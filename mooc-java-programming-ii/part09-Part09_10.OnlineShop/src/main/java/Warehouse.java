import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Warehouse {
    private Map<String, Integer> prices;
    private Map<String, Integer> stockLevels;
    
    public Warehouse() {
        this.prices = new HashMap<>();
        this.stockLevels = new HashMap<>();
    }
    
    public void addProduct(String product, int price, int stock) {
        this.prices.put(product, price);
        this.stockLevels.put(product, stock);
    }
    
    public int price(String product) {
        return this.prices.getOrDefault(product, -99);
    }
    
    public int stock(String product) {
        return this.stockLevels.getOrDefault(product, 0);
    }
    
    public boolean take(String product) {
        
        
        int stockLevel = this.stockLevels.getOrDefault(product, 0);
        if (stockLevel == 0) {
            return false;
        }

        this.stockLevels.put(product, stockLevel - 1);
        return true;
    }
    
    public Set<String> products() {
        return this.prices.keySet();
    }
}
