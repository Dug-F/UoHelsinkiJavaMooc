
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        Container first = new Container();
        Container second = new Container();

        while (true) {
            System.out.println("First: " + first);
            System.out.println("Second: " + second);

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }
            
            String[] inputParts = input.split(" ");
            String command = inputParts[0];
            int vol = Integer.valueOf(inputParts[1]);
            
            if (command.equals("add")) {
                first.add(vol);
            }
            
            if (command.equals("move")) {
                if (vol > first.contains()) {
                    vol = first.contains();
                }
                first.remove(vol);
                second.add(vol);
            }
            
            if (command.equals("remove")) {
                second.remove(vol);
            }

        }
    }

}
