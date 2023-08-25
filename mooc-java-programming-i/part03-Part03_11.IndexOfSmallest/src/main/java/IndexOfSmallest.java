
import java.util.ArrayList;
import java.util.Scanner;

public class IndexOfSmallest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();
        int number;
        int smallest = 0;
        
        while(true) {
            number = Integer.valueOf(scanner.nextLine());
            
            if (number == 9999) {
                break;
            }
            
            list.add(number);
            if (list.size() == 1) {
                smallest = number;
            } else if (number < smallest) {
                smallest = number;
            }
            
        }
        
        System.out.println("Smallest number: " + smallest);
        
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == smallest) {
                System.out.println("Found at index: " + i);
            }
        }
        
        
        
        // implement here a program that reads user input
        // until the user enters 9999
        
        // after that, the program prints the smallest number
        // and its index -- the smallest number
        // might appear multiple times

        
    }
}
