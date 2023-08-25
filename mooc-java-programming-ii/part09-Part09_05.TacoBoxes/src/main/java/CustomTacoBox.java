public class CustomTacoBox implements TacoBox {
    private int tacos;
    
    public CustomTacoBox(int tacos) {
        this.tacos = tacos;
    }
    
    public void eat() {
        if (this.tacos >= 1)  {
            this.tacos--;
        }
    }
    
    public int tacosRemaining() {
        return this.tacos;
    }
}
