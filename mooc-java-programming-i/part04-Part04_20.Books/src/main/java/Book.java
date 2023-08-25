/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Doug
 */
public class Book {
    private String title;
    private int pageCount;
    private int publicationYear;
    
    public Book(String title, int pageCount, int publicationYear) {
        this.title = title;
        this.pageCount = pageCount;
        this.publicationYear = publicationYear;
    }
    
    public void printEverything() {
        System.out.println(this.title + ", " + this.pageCount + " pages, " + this.publicationYear);
    }
    
    public void printName() {
        System.out.println(this.title);
    }
}
