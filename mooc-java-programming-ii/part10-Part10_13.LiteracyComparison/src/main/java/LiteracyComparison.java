
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LiteracyComparison {
    
    public static void main(String[] args) {
        
        try {
            Files.lines(Paths.get("literacy.csv"))
                    .map(s -> s.split(","))
                    .filter(s -> s.length >= 6)
                    .sorted((s1, s2) -> Double.compare(Double.parseDouble(s1[5]), Double.parseDouble(s2[5])))
                    .forEach(s -> System.out.println(s[3] + " (" + s[4] + "), " + s[2].trim().split(" ")[0] + ", " + s[5] ));
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
