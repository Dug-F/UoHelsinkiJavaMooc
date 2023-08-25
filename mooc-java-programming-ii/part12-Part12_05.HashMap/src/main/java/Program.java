
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // You can test the class here
//        Pair<String, Integer> pair = new Pair<>("one", 1);
//        System.out.println(pair.getKey() + " -> " + pair.getValue());
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < 200; i++) {
            map.add("Key " + i, "Hello " + i);
        }
        
//        for (int i = 0; i < 200; i++) {
//            System.out.println(map.get("Key " + i));
//        }
//        
        map.remove("Key 27");
        map.remove("Key 37");
        map.add("Key 46", "Updated value 46");
        map.add("Key 54", "Updated value 54");
        
        for (int i = 0; i < 200; i++) {
            System.out.println(map.get("Key " + i));
        }
        
    }

}
