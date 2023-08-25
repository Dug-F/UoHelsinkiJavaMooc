
import java.util.ArrayList;
import java.util.Scanner;

public class PrintingUserInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> words = new ArrayList<>();
        
        while(true) {
            String input = scanner.nextLine();
            
            if (input.isEmpty()) {
                break;
            }
            
            words.add(input);
        }
        
        words.stream()
                .forEach(w -> System.out.println(w));

    }
}
