
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // toteuta ohjelmasi tänne
        ArrayList<String> inputs = new ArrayList<>();
        
        System.out.println("Input numbers, type \"end\" to stop.");

        while(true) {
            String input = scanner.nextLine();
            
            if (input.equals("end")) {
                break;
            }
            
            inputs.add(input);
        }
        
        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
        String type = scanner.nextLine();
        
        double average = inputs.stream()
                .mapToInt(s -> Integer.valueOf(s))
                .filter(number -> type.equals("p") ? number >= 0 : number < 0)
                .average()
                .getAsDouble();
                        
        String typeText = type.equals("p") ? "positive" : "negative";
        System.out.println("Average of the " + typeText + " numbers: " + average);

    }
}
