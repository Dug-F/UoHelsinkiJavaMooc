import java.util.HashMap;
import java.util.ArrayList;

public class VehicleRegistry {
    private HashMap<LicensePlate, String> registry;
    
    public VehicleRegistry() {
        this.registry = new HashMap<>();
    }
    
    public boolean add(LicensePlate licensePlate, String owner) {
        if (this.registry.containsKey(licensePlate)) {
            return false;
        }
        
        this.registry.put(licensePlate, owner);
        return true;
    }
    
    public String get(LicensePlate licensePlate) {
        return this.registry.get(licensePlate);
    }
    
    public boolean remove(LicensePlate licensePlate) {
        if (!this.registry.containsKey(licensePlate)) {
            return false;
        }
        this.registry.remove(licensePlate);
        return true;
    }
    
    public void printLicensePlates() {
        for (LicensePlate key : this.registry.keySet()) {
            System.out.println(key);
        }
    }
    
    public void printOwners() {
        ArrayList<String> owners = new ArrayList<>();
        
        for (String owner : this.registry.values()) {
            if (!owners.contains(owner)) {
                owners.add(owner);
            }
        }
        
        for (String owner : owners) {
            System.out.println(owner);
        }
    }
    
}
