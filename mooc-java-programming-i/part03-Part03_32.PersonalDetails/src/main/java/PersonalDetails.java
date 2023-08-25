
import java.util.ArrayList;
import java.util.Scanner;

public class PersonalDetails {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int count = 0;
        int birthYearSum = 0;
        String longestName = "";
        
        while (true) {
            String data = scanner.nextLine();
            if (data.equals("")) {
                break;
            }
            
            String[] parts = data.split(",");
            
            count++;
            birthYearSum += Integer.valueOf(parts[1]);
            if (parts[0].length() > longestName.length()) {
                longestName = parts[0];
            }
            
        }
        
        if (count > 0) {
            System.out.println("Longest name: " + longestName);
            System.out.println("Average of the birth years: " + ((double) birthYearSum / count));
        }


    }
}
