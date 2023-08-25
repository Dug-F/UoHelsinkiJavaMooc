public class List<T> {
    private T[] list;
    private int lastIndex;

    public List() {
        this.list = (T[]) new Object[10];
        this.lastIndex = 0;
    }
    
    public void add(T value) {
        if (this.lastIndex == this.list.length) {
            this.grow();
        }
        
        this.list[this.lastIndex] = value;
        this.lastIndex++;
    }
    
    private void grow() {
        int newSize = this.lastIndex + this.lastIndex / 2;
        T[] newList = (T[]) new Object[newSize];
        
        for (int i = 0; i < this.lastIndex; i++) {
            newList[i] = this.list[i];
        }
        
        this.list = newList;
    }
    
    public boolean contains(T value) {
        return indexOfValue(value) >= 0;
    }
    
    public void remove(T value) {
        int i = indexOfValue(value);
        if (i < 0) {
            return;
        }
        
        this.moveLeft(i);
    }
    
    public int indexOfValue(T value) {
        for (int i=0; i < this.lastIndex; i++) {
            if (this.list[i] == value || this.list[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }
    
    private void moveLeft(int fromIndex) {
        for (int i = fromIndex; i < this.list.length - 1; i++) {
            this.list[i] = this.list[i+1];
        }
        this.lastIndex--;
    }
    
    public T value(int index) {
        if (index < 0 || index >= this.list.length) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " outside of [0, " + this.lastIndex + "]");
        }
        return this.list[index];
    }
    
    public int size() {
        return this.lastIndex;
    }
    
    
}
