package libraryLab;

import libraryLab.Book;

abstract class LibraryBook extends Book implements Comparable <LibraryBook> {

    protected String callNumber ;
    
    //constructor
    LibraryBook(String author, String title, String isbn, String num){
        super(author, title, isbn);
        callNumber = num;
        
    }
    
    /**
	 * gets the callNumber of the book
	 * @return callNumber of the book
	 */
    public String getCallNumber() {
        return callNumber;
    }
    
    /**
	 * sets num as the callNumber of a book
	 * @param callNumber of the book is passed
	 */
    public void setCallNumber (String num) {
        callNumber = num;
    }
    
    abstract void checkout (String patron, String dueDate);
    abstract void returned () ; 
    abstract String circulationStatus ();
    
    /** 
	 * implementation of Comparable's compareTo method
	 * @param l:  Library object being compared
	 * @return 0 if call numbers of this and l match
	 *         < 0 if call number of this comes before call number of l
	 *         > 0 otherwise
	 */
    public int compareTo (LibraryBook l) {
        return (callNumber.compareTo(l.getCallNumber()));
    }
    
    
    /**
	   * Specifies the order and the format in which the data
	   * is printed.
	   */
    public String toString ()
    {
        return ( super.toString() + "\n        Call Number: " + getCallNumber()
                                  + "\n        Status: " + circulationStatus()); 
    }
    
   
}
