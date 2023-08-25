
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;

public class RecordsFromAFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Name of the file: ");
        String file = scanner.nextLine();
        ArrayList<Person> people = new ArrayList<>();
        
        try (Scanner fileScanner = new Scanner(Paths.get(file))) {
            while (fileScanner.hasNextLine()) {
                String row = fileScanner.nextLine();
                System.out.println(row);
                String[] rowData = row.split(",");
                people.add(new Person(rowData[0], Integer.valueOf(rowData[1])));
            }
        }
        catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        
        for (Person person : people) {
            System.out.println(person);
        }
        
    }
}
