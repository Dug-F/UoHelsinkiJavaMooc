import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        // implement here the program that allows the user to enter 
        // book information and to examine them
        while (true) {
            System.out.println("Title: ");
            String title = scanner.nextLine();
            
            if (title.isEmpty()) {
                break;
            }
            
            System.out.println("Pages: ");
            int pageCount = Integer.valueOf(scanner.nextLine());

            System.out.println("Publication year: ");
            int publicationYear = Integer.valueOf(scanner.nextLine());
            
            books.add(new Book(title, pageCount, publicationYear));
        }
        
        System.out.println("What information will be printed? ");
        String info = scanner.nextLine();
        
        for (Book book : books) {
            if (info.equals("everything")) {
                book.printEverything();
            } else if (info.equals("name")) {
                book.printName();
            }
        }
        
        

    }
}
