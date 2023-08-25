
public class ArrayPrinter {

    public static void main(String[] args) {
        // You can test your method here
        int[] array = {5, 1, 3, 4, 2};
        printNeatly(array);
    }

    public static void printNeatly(int[] array) {
        if (array.length > 0) {
            System.out.print(array[0]);
            
            if (array.length > 1) {
                for (int i = 1; i < array.length; i++) {
                    System.out.print(", " + array[i]);
                }
            }
            
            System.out.println("");
        }
    }
}
