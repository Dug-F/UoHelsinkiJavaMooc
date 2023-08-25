
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int[] volume = {0, 0};
        int[] capacity = {100, 100};
        String[] labels = {"First: ", "Second: "};


        while (true) {
            System.out.print("> ");
            
            for (int i = 0; i < 2; i++) {
                System.out.println(labels[i] + volume[i] + "/" + capacity[i]);
            }

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }
            
            String[] commands = input.split(" ");
            String command = commands[0];
            int amount = Integer.valueOf(commands[1]);
            
            if (amount < 0) {
                continue;
            }
           
            if (command.equals("add")) {
                volume[0] += amount;
                if (volume[0] > capacity[0]) {
                    volume[0] = capacity[0];
                }
            } else if (command.equals("move")) {
                if (amount > volume[0]) {
                    amount = volume[0];
                }
                volume[0] -= amount;
                if (volume[0] < 0) {
                    volume[0] = 0;
                }
                volume[1] += amount;
                if (volume[1] > 100) {
                    volume[1] = 100;
                }
            } else if (command.equals("remove")) {
                volume[1] -= amount;
                if (volume[1] < 0) {
                    volume[1] = 0;
                }
            }

        }
    }

}
