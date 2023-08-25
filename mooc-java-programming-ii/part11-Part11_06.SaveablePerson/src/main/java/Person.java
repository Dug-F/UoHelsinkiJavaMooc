public class Person implements Saveable {
    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }
    
    public void save() {
        
    }
    
    public void delete() {
        
    }
    
    public void load(String address) {
        this.address = address;
    }
}
