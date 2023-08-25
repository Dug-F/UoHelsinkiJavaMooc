
import java.util.ArrayList;
import java.util.Scanner;

public class Searching {

    public static void main(String[] args) {
        // The program below is meant for testing the search algorithms you'll write
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        System.out.println("How many books to create?");
        int numberOfBooks = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < numberOfBooks; i++) {
            books.add(new Book(i, "name for the book " + i));
        }

        System.out.println("Id of the book to search for?");
        int idToSearchFor = Integer.valueOf(scanner.nextLine());

        System.out.println("");
        System.out.println("Searching with linear search:");
        long start = System.currentTimeMillis();
        int linearSearchId = linearSearch(books, idToSearchFor);
        System.out.println("The search took " + (System.currentTimeMillis() - start) + " milliseconds.");
        if (linearSearchId < 0) {
            System.out.println("Book not found");
        } else {
            System.out.println("Found it! " + books.get(linearSearchId));
        }

        System.out.println("");

        System.out.println("");
        System.out.println("Seaching with binary search:");
        start = System.currentTimeMillis();
        int binarySearchId = binarySearch(books, idToSearchFor);
        System.out.println("The search took " + (System.currentTimeMillis() - start) + " milliseconds.");
        if (binarySearchId < 0) {
            System.out.println("Book not found");
        } else {
            System.out.println("Found it! " + books.get(binarySearchId));
        }

    }

    public static int linearSearch(ArrayList<Book> books, int searchedId) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == searchedId) {
                return i;
            }
        }

        return -1;
    }

    public static int binarySearch(ArrayList<Book> books, long searchedId) {
        int lowerBound = 0;
        int upperBound = books.size() - 1;
        int searchIndex = (upperBound - lowerBound) / 2;
        int bookId = 0;
        int newSearchIndex = 0;

        int middle = 0;
        
        while(lowerBound <= upperBound) {
            middle = (lowerBound + upperBound) / 2;
            
            bookId = books.get(middle).getId();
            
            if (bookId == searchedId) {
                return middle;
            }
            
            if (bookId < searchedId) {
                lowerBound = middle + 1;
            }
            
            if (bookId > searchedId) {
                upperBound = middle - 1;
            }
        }
        
        return -1;
        
        
//        while (true) {
//            bookId = books.get(searchIndex).getId();
//            if (bookId == searchedId) {
//                return searchIndex;
//            }
//            
//            if (lowerBound == upperBound) {
//                return -1;
//            }
//            
//            if (searchedId < bookId) {
//                upperBound = searchIndex;
//            } else {
//                lowerBound = searchIndex;
//            }
//            
//            newSearchIndex = (upperBound + lowerBound) / 2;
//            if (newSearchIndex == searchIndex) {
//                searchIndex = upperBound;
//            } else {
//                searchIndex = newSearchIndex;
//            }
//
//        }
    }
}

