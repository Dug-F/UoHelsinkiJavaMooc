
import java.util.Scanner;

public class PrintThrice {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give a word: ");
        String word = scanner.nextLine();
        
        String printString = "";
        for (int i = 0; i < 3; i++) {
            printString += word;
        }
        
        System.out.println(printString);

    }
}
