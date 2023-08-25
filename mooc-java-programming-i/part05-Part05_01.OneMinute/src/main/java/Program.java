
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        // You can test your program here
        Timer timer = new Timer();
        
        while (true) {
            timer.advance();
            
            System.out.println(timer);
        }

    }
}
