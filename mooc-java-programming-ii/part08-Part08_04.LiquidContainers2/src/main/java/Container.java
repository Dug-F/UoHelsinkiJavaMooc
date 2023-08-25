/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Doug
 */
public class Container {
    private int volume = 0;
    private int capacity = 100;
    
    public Container() {
        
    }

    public int contains() {
        return volume;
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
    
    public void remove (int amount) {
        if (amount <= 0) {
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
