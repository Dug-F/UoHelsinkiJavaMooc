import java.util.ArrayList;

public class Herd implements Movable {
    private ArrayList<Movable> herd;

    public Herd() {
        this.herd = new ArrayList<>();
    }
    
    public String toString() {
        String members = "";
        for (Movable member : this.herd) {
            members += member.toString() + "\n";
        }
        
        return members;
    }
    
    public void addToHerd(Movable movable) {
        this.herd.add(movable);
    }
    
    public void move(int dx, int dy) {
        for (Movable member : this.herd) {
            member.move(dx, dy);
        }
    }
    
    
}
