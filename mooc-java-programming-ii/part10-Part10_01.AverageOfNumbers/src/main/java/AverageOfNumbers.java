
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Write your program here
        ArrayList<String> numbers = new ArrayList<>();
        while(true) {
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            
            numbers.add(input);
            
        }
        
        double average = numbers.stream()
                .mapToInt(s -> Integer.valueOf(s))
                .average()
                .getAsDouble();
        
        System.out.println("Average of the numbers: " + average);

    }
}
