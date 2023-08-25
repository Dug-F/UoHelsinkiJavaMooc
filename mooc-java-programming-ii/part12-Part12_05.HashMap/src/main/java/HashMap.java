import java.util.ArrayList;

public class HashMap<K, V> {
    private ArrayList<Pair<K, V>>[] map;
    private int arrayIndexesUsed;

    public HashMap() {
        this.map = (ArrayList<Pair<K, V>>[]) new ArrayList[32];
        this.arrayIndexesUsed = 0;
        
    }
    
    public V get(K key) {
        int arrayIndex = Math.abs(key.hashCode() % this.map.length);
        if (this.map[arrayIndex] == null) {
            return null;
        }
        
        ArrayList<Pair<K, V>> list = this.map[arrayIndex];
        for (int i = 0; i <list.size(); i++) {
            if (list.get(i).getKey().equals(key)) {
                return list.get(i).getValue();
            }
        }
        return null;
    }
    
    public int getIndexOfKey(ArrayList<Pair<K, V>> list, K key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getKey().equals(key)) {
                return i;
            }
        }
        return -1;
    }
    
    private ArrayList<Pair<K, V>> getListAtIndex(int index) {
        if (this.map[index] == null) {
            this.map[index] = new ArrayList<Pair<K, V>>();
            arrayIndexesUsed++;
        }
        
        return this.map[index];
    }
    
    public void add(K key, V value) {
        if (arrayIndexesUsed >= (double) this.map.length * 0.75) {
            this.grow();
        }
        
        int arrayIndex = Math.abs(key.hashCode() % this.map.length);
        ArrayList<Pair<K, V>> list = this.getListAtIndex(arrayIndex);
        
        int index = this.getIndexOfKey(this.map[arrayIndex], key);
        if (index < 0) {
            this.map[arrayIndex].add(new Pair(key, value));
        } else {
            this.map[arrayIndex].get(index).setValue(value);
        }
    }
    
    private void grow() {
        int newSize = this.map.length * 2;
        ArrayList<Pair<K, V>>[] newArray = (ArrayList<Pair<K, V>>[]) new ArrayList[newSize];
        ArrayList<Pair<K, V>>[] oldArray = this.map;
        this.map = newArray;
        
        for (int i = 0; i < oldArray.length; i++) {
            if (oldArray[i] == null) {
                continue;
            }
            this.relocate(oldArray[i]);
        }
        
    }
    
    private void relocate(ArrayList<Pair<K, V>> list) {
        for (int i = 0; i < list.size(); i++) {
            this.add(list.get(i).getKey(), list.get(i).getValue());
        }
    }
    
    public V remove(K key) {
        int arrayIndex = Math.abs(key.hashCode() % this.map.length);
        int index = getIndexOfKey(this.map[arrayIndex], key);
        
        if (index < 0) {
            return null;
        }
        V value = this.map[arrayIndex].get(index).getValue();
        this.map[arrayIndex].remove(index);
        return value;
    }
    
    
    
}
