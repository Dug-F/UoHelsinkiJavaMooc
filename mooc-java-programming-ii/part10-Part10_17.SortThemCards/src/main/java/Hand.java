import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;

public class Hand implements Comparable<Hand> {
    private ArrayList<Card> hand;

    public Hand() {
        this.hand = new ArrayList<>();
    }
    
    public void add(Card card) {
        this.hand.add(card);
    }
    
    public void print() {
        Iterator<Card> iter = this.hand.iterator();
        
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
    
    public void sort() {
        Collections.sort(this.hand);
    }
    
    public void sortBySuit() {
        Collections.sort(this.hand, new BySuitInValueOrder());
    }
    
    public int getValue() {
        return this.hand.stream()
                .map(s -> s.getValue())
                .reduce(0, (previousSum, value) -> previousSum + value);
    }
    
    public int compareTo(Hand hand) {
        return this.getValue() - hand.getValue();
    }
    
    
}
