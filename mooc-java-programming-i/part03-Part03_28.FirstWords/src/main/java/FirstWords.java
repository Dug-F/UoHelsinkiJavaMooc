
import java.util.Scanner;

public class FirstWords {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        
        while (true) {
            input = scanner.nextLine();
            
            if (input.equals("")) {
                break;
            }
            
            String[] words = input.split(" ");
            System.out.println(words[0]);                    
            
        }

    }
}
