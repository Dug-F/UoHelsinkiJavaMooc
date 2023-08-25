
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int[] volume = {0, 0};
        int[] capacity = {100, 100};
        String[] label = {"First: ", "Second: "};


        while (true) {
//            System.out.print("> ");
            for (int i=0; i <= 1; i++) {
                System.out.println(label[i] + volume[i] + "/" + capacity[i]);
            }

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }
            
            String[] inputParts = input.split(" ");
            String command = inputParts[0];
            int vol = Integer.valueOf(inputParts[1]);
            
            if (command.equals("add")) {
                if (vol > 0) {
                    volume[0] += vol;
                    if (volume[0] > capacity[0]) {
                        volume[0] = capacity[0];
                    } 
                }
            }
            
            if (command.equals("move")) {
                if (vol > 0) {
                    if (vol > volume[0]) {
                        vol = volume[0];
                    }
                    if (vol > capacity[1] - volume[1]) {
                        vol = capacity[1] - volume[1];
                    }
                    volume[0] -= vol;
                    volume[1] += vol;
                }
            }
            
            if (command.equals("remove")) {
                if (vol > 0) {
                    if (vol > volume[1]) {
                        vol = volume[1];
                    }
                    volume[1] -= vol;
                }
            }

        }
    }

}
