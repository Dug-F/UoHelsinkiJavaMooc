
import java.util.Scanner;

public class Counting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int integer = Integer.valueOf(scanner.nextLine());
        
        for (int i = 0; i <= integer; i++) {
            System.out.println(i);
        }

    }
}
