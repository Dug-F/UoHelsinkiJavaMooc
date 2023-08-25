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
public class Package {
    private ArrayList<Gift> gifts;
    private int totalWeight;

    public Package() {
        this.gifts = new ArrayList<>();
        this.totalWeight = 0;
    }
    
    public void addGift(Gift gift) {
        this.gifts.add(gift);
        this.totalWeight += gift.getWeight();
    }

    public int getTotalWeight() {
        return totalWeight;
    }
    
    
    
    
}
