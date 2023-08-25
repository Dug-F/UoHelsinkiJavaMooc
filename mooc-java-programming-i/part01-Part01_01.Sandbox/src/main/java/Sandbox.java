import java.util.ArrayList;

public class Sandbox {

    public static void main(String[] args) {
        // Write your program here
        ArrayList<String> words = new ArrayList<>();
        words.add("Hello");
        words.add("Goodbye");
        words.add("Greetings");
        words.add("Cheerio");
        words.add("Hello");
        
        boolean removed = words.remove("Aargh");
        System.out.println(removed);
        
        for (String word : words) {
            System.out.println(word);
        }
    }
}
