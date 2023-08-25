
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Try out how the different parts of the program work together
        // here
        Scanner scanner = new Scanner(System.in);
        SimpleDictionary dict = new SimpleDictionary();
        
        TextUI ui = new TextUI(scanner, dict);
        ui.start();
        
        System.out.println(dict.translate("pike"));
    }
}
