
import java.util.Scanner;

public class IsItTrue {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give a string: ");
        boolean answer = Boolean.valueOf(scanner.nextLine());
        
        if (answer == true) {
            System.out.println("You got it right!");
        } else {
            System.out.println("Try again!");
        }
        
    }
}
