import java.util.ArrayList;
import java.util.HashMap;

public class StorageFacility {
    private HashMap<String, ArrayList<String>> units;
    
    public StorageFacility() {
        this.units = new HashMap<>();
    }
    
    public void add(String unit, String item) {
        this.units.putIfAbsent(unit, new ArrayList<String>());
        this.units.get(unit).add(item);
    }
    
    public ArrayList<String> contents(String storageUnit) {
        return this.units.getOrDefault(storageUnit, new ArrayList<>());
    }
    
    public void remove(String storageUnit, String item) {
        this.units.get(storageUnit).remove(item);
        if (this.units.get(storageUnit).size() == 0) {
            this.units.remove(storageUnit);
        }
    }
    
    public ArrayList<String> storageUnits() {
        ArrayList<String> unitList = new ArrayList<>();
        
        for (String unit : units.keySet()) {
            unitList.add(unit);
        }
        
        return unitList;
    }
    
}
