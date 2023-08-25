public class Dog extends Animal implements NoiseCapable {
    
    
    public Dog() {
        this("Dog");
    }
    
    public Dog (String name) {
        super(name);
    }
    
    public void bark() {
        System.out.println(this.getName() + " barks");
    }
    
    public void makeNoise() {
        this.bark();
    }
    
}
