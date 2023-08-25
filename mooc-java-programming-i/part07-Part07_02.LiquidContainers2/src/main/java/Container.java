import java.util.ArrayList;

public class Container {
    private int volume;
    private int capacity;
    
    public Container() {
        this.volume = 0;
        this.capacity = 100;
    }
    
    public int contains() {
        return this.volume;
    }
    
    public void add(int amount) {
        if (amount <= 0) {
            return;
        }
        
        this.volume += amount;
        if (this.volume > this.capacity) {
            this.volume = this.capacity;
        }
    }
    
    public void remove(int amount) {
        if (amount < 0) {
            return;
        }
        
        this.volume -= amount;
        if (this.volume < 0) {
            this.volume = 0;
        }
    }
    
    public String toString() {
        return this.volume + "/" + this.capacity;
    }
}
