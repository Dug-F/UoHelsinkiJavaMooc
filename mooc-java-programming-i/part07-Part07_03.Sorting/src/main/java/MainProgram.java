
public class MainProgram {

    public static void main(String[] args) {
        // write your test code here
        int[] array = {3, 1, 5, 99, 3, 12};
//        int[] array = {6, 3, 0, -1, 4};
        
        
        System.out.print("Before: ");
        print(array);
        
        sort(array);
        
        System.out.print("After: ");
        print(array);
        
    }
    
    public static int smallest(int[] array){
        if (array.length == 0) {
            return -1;
        }
        int smallest = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
            }
        }
        return smallest;
    }
    
    public static int indexOfSmallest(int[] array){
        return indexOfSmallestFrom(array, 0);
    }
    
    public static int indexOfSmallestFrom(int[] table, int startIndex) {
        if (table.length == 0) {
            return -1;
        }
        int smallest = table[startIndex];
        int index = startIndex;
        
        for (int i = startIndex; i < table.length; i++) {
            if (table[i] < smallest) {
                smallest = table[i];
                index = i;
            }
        }
        
        return index;
    }
    
    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    
    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int index = indexOfSmallestFrom(array, i);
            swap(array, i, index);
        }
    }

    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(array[i]);
        }
        System.out.println("");
    }
    
}
