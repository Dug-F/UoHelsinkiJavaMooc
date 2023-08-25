
import java.util.Scanner;

public class AreWeThereYet {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int integer;
        
        while (true) {
            System.out.println("Give a number:");
            integer = Integer.valueOf(scanner.nextLine());
            if (integer == 4) {
                break;
            }
        }
        
    }
}
