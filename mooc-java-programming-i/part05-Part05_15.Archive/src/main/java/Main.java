
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<ArchiveEntry> entries = new ArrayList<>();
        
        while(true) {
            System.out.println("Identifier? (empty will stop)");
            String identifier = scanner.nextLine();
            if (identifier.isEmpty()) {
                break;
            }

            System.out.println("Name? (empty will stop)");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                break;
            } 
            
            ArchiveEntry entry = new ArchiveEntry(identifier, name);
            if (!(entries.contains(entry))) {
                entries.add(entry);
            }
            
                    
        }
        
        System.out.println("==Items==");
        for (ArchiveEntry entry : entries) {
            System.out.println(entry);
        }

    }
}
