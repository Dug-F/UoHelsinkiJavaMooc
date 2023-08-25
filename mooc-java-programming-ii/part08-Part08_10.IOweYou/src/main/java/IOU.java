import java.util.HashMap;

public class IOU {
    private HashMap<String, Double> iou;
    
    public IOU() {
        this.iou = new HashMap<>();
    }
    
    public void setSum(String toWhom, double amount) {
        double amountOwed = iou.getOrDefault(toWhom, 0.0);
        amountOwed += amount;
        iou.put(toWhom, amountOwed);
    }
    
    public double howMuchDoIOweTo(String toWhom) {
        return iou.getOrDefault(toWhom, 0.0);
    }
    
}
