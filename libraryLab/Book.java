package libraryLab;

/**Basic Book class for all types of books. Information includes author, title
 * and ISBN
 * @author Priyanka Dangol
 * @author Sage Kaplan-Goland
 *
 */
public class Book {
    /**The author of the book*/
    protected String author;
    /**The title of the book*/
    protected String title;
    /**The international standard book number*/
    protected String isbn;
    
    /**Null constructor for a book when no information is given*/
    Book(){
        author = "";
        title = "";
        isbn = "";
    }
    
    /**Base book constructor when information is given
     * 
     * @param auth The author of the book, in the form FirstName LastName
     * @param bookName The title of the book
     * @param num The ISBN number (should be on the back of the book)
     */
    Book (String auth, String bookName, String num){
        author = auth;
        title = bookName;
        isbn = num;
    }
    
    /**Getter which returns the name of the author
     * 
     * @return the author of the book
     */
    public String getAuthor() {
        return author;
    }
    
    /**Getter which returns the title of the book
     * 
     * @return the ttitle of the book
     */
    public String getTitle() {
        return title;
    }
    
    /**Getter which returns the ISBN of the book
     *
     * @return the ISBN of the book
     */
    public String getIsbn() {
        return isbn;
    }
    
    /**Setter which sets the author's name for a book
     * 
     * @param str the name of the author, with first name first
     */
    public void setAuthor(String str) {
        author = str;
    }
    
    /**Setter which sets the ISBN of the book
     * 
     * @param str the ISBN of the book
     */
    public void setIsbn(String str) {
        isbn = str;
    }
    
    /** Setter which sets the title of the book
     * 
     * @param str the title of the book
     */
    public void setTitle(String str) {
        title = str;
    }
    
    /**Prints title, author, and ISBN of the book 
     */
    public String toString() {
        return "\nTitle:  " + title + 
        		"\n        Author: " + author +
                "\n        ISBN: " + isbn;
    }
    
    public static void main (String argv []) {
       //test null constructor
        Book book1 = new Book();
        
        //test regular constructor
        Book book2 = new Book("Sage Kaplan-Goland", "The meaning of smth", "13");
        
        //Test getAuthor
        System.out.println("getAuthor returns for each book");
        System.out.println("Book1 (null): " + book1.getAuthor());
        System.out.println("Book2: " + book2.getAuthor());
        System.out.println();        
        
        //Test getTitle
        System.out.println("getTitle returns for each book");
        System.out.println("Book1 (null): " + book1.getTitle());
        System.out.println("Book2: " + book2.getTitle());
        System.out.println();
        
        //Test getIsbn
        System.out.println("getIsbn returns for each book");
        System.out.println("Book1 (null): " + book1.getIsbn());
        System.out.println("Book2: " + book2.getIsbn());
        System.out.println();
        
        //Test setAuthor
        System.out.println("setAuthor returns for a book, new author should be Priyanka");
        book1.setAuthor("Priyanka");
        System.out.println("Book1 author: " + book1.getAuthor());
        System.out.println(); 
        
        //Test setTitle
        System.out.println("setTitlereturns for a book, new title is \"even more stuff\"");
        book1.setTitle("Even more stuff");
        System.out.println("Book1 title: " + book1.getTitle());
        System.out.println(); 
        
        //Test setIsbn
        System.out.println("setIsbn returns for a book, new isbn should b 2");
        book1.setIsbn("2");
        System.out.println("Book1 author: " + book1.getIsbn());
        System.out.println(); 
        
        //Test toString
        System.out.println("Output of printing each book:");
        System.out.println(book1);
        System.out.println(book2);
    }
}
