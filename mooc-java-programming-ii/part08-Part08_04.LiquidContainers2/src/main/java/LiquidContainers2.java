
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        Container first = new Container();
        Container second = new Container();


        while (true) {
            System.out.println("First: " + first);
            System.out.println("Second: " + second);
            System.out.print("> ");

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }
            
            String inputs[] = input.split(" ");
            String command = inputs[0];
            int amount = Integer.valueOf(inputs[1]);
            
            if (amount <= 0) {
                continue;
            }
            
            if (command.equals("add")) {
                first.add(amount);
            } else if (command.equals("move")) {
                if (amount > first.contains()) {
                    amount = first.contains();
                }
                first.remove(amount);
                second.add(amount);
                
            } else if (command.equals("remove")) {
                second.remove(amount);
            }

        }
    }

}
