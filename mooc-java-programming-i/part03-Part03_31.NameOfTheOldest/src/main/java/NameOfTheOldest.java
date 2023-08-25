
import java.util.Scanner;

public class NameOfTheOldest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int oldestAge = -1;
        String oldestName = "";
        
        while (true) {
            String data = scanner.nextLine();
            if (data.equals("")) {
                break;
            }
            
            String[] parts = data.split(",");
            if (Integer.valueOf(parts[1]) > oldestAge) {
                oldestAge = Integer.valueOf(parts[1]);
                oldestName = parts[0];
                
            }
            
        }
        
        if (oldestAge > -1) {
            System.out.println("Name of the oldest: " + oldestName);
        }


    }
}
