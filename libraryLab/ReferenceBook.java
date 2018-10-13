package libraryLab;

import libraryLab.LibraryBook;

/**Class for a book which is housed in a specific collection and does not circulate
 * 
 * @author Sage Kaplan-Goland
 * @author Priyanka Dangol
 *
 */
public class ReferenceBook extends LibraryBook{
    /**Colection where the reference book is housed     */
    private String collection;
    
    /**Constructor for a reference book, which includes all aspects of a LibraryBook
     * with the additional of a collection field
     * @param author the author of the book
     * @param title the title of the book
     * @param isbn the ISBN of the book
     * @param num the call number of the book
     * @param coll the collection where the book is housed
     */
    ReferenceBook(String author, String title, String isbn, String num, String coll){
        super(author, title, isbn, num);
        collection = coll;
    }
    
    /**Getter which returns what collection the book is in
     * 
     * @return the name of the collection to which the book belongs
     */
    public String getCollection() {
        return collection;
    }
    
    /**Setter which allows the collection to be changed
     * 
     * @param str the name of the new collection for the book
     */
    public void setCollection (String str) {
        collection = str;
    }  
    
    /**Process to check out book, which is disallowed for reference books
     */
    public void checkout (String patron, String dueDate) {
        System.out.println(patron + " cannot check out a reference book");
    }
    
    /**Process to return a book, which is impossible for reference books
     * as they cannot be checked out
     */
    public void returned() {
        System.out.println("reference book could not have been checked "
                + "out -- return impossible");
    }
    
    /**Method which returns the circulation status, notifying the user that
     * this is a reference book which cannot circulate
     */
    public String circulationStatus() {
        return "non-circulating reference book";
    }
    
    /**Added collection information to output
     */
    public String toString ()
    {
        return super.toString() + "\n        Collection: " + getCollection();  
    }
    
    public static void main (String argv []) {         
         //test regular constructor
         ReferenceBook book1 = new ReferenceBook("Sage Kaplan-Goland", "The meaning of smth", "13",
                                         "KQW1", "Self-help");
         
         //Test getCollection
         System.out.println("getCollection return for the book:");
         System.out.println("Book1: " + book1.getCollection() + "\n");
         System.out.println("Setting collection to \"classics\"");
         book1.setCollection("Classics");
         System.out.println("getCollection return for the book:");
         System.out.println("Book1: " + book1.getCollection());
         System.out.println();        
         
         //Test checkout
         System.out.println("Attempting to check out book to Sage:");
         book1.checkout("Sage", "9/28");
         System.out.println();
         
         //Test return
         System.out.println("Attempting to return book:");
         book1.returned();
         System.out.println();
         
         //Test circulationStatus
         System.out.println("Check circulationStatus of reference book");
         System.out.println(book1.circulationStatus());
         System.out.println(); 
         
         //Test toString
         System.out.println("Output of printing book:");
         System.out.println(book1);
     }
}
