package libraryLab;

import libraryLab.LibraryBook;

public class CirculatingBook extends LibraryBook{
	String currentHolder;
	String dueDate;
	
	CirculatingBook(String author, String title, String isbn, String callnum){
		super(author, title, isbn, callnum);
		currentHolder = "";
		dueDate = "";
	}
	
	/**
	 * gets the name of the current holder of the book
	 * @return the name of the current holder of the book 
	 *         if the book has been checked out
	 *         null if the book hasn't been checked out
	 */
	public String getCurrentHolder() {
		return currentHolder;
	}
	
	/**
	 * sets name as the current holder of the book
	 */
	public void setCurrentHolder(String name) {
		currentHolder = name;
	}
	
	/**
	 * gets the current dueDate of the book (if applicable)
	 * @return the dueDate of the book if the book has been
	 * 		   checked out
	 *         null if it hasn't been checked out
	 */
	public String getDueDate() {
		return dueDate;
	}
	
	/**
	 * sets date as the current dueDate of the book
	 */
	public void setDueDate(String date) {
		dueDate = date;
	}
	
	/**
	 * updates the checkout information of the book if the 
	 * book has been checked out
	 */
	public void checkout (String name, String date) {
		currentHolder = name;
		dueDate = date;
	}
	
	/**
	 * sets currentDate and dueDate to null if the book
	 * has been returned
	 */
	public void returned() {
		currentHolder = "";
		dueDate = "";
	}
	
	/**
	 * shows the circulation status of a book
	 * @return prints the respective holder of the book and 
	 *         the due date if the book is checked out
	 *         prints out another message if the book hasnt 
	 *         been checked out
	 */
	public String circulationStatus() {
		if (currentHolder.equals("")){
			return "book available on shelves";
		}
		else {
			return "\n        Currently checked out by: " + currentHolder +
					"\n        Due back on: " + dueDate;
 	
		}
	}
	
	
	//tests
	public static void main(String argv []) {

       
        //Test regular constructors
		CirculatingBook cb = new CirculatingBook("Robert Galbraith ", "The Cuckoo's Calling", "018-516-789", "N98.701 2016");
		CirculatingBook cb1 = new CirculatingBook("Ram Prasad", "Everything Hurts", "785-9595-165", "O45.789F 2018");
		
		System.out.println(cb);
		System.out.println(cb1);
        
		//Test checkout method
		cb.checkout("Rahul", "9/9/2018");

		//tests the getters 
		System.out.println("\n The current holder of " + cb.title  + " is " + cb.getCurrentHolder() );
		System.out.println("The current due date of " + cb.title  + " is " + cb.getDueDate() );
		System.out.println("The current holder of " + cb1.title  + " is " + cb1.getCurrentHolder() );
		System.out.println("The current due date of " + cb1.title  + " is " + cb1.getDueDate() );
		
		//tests returned method
		cb.returned();
		
		System.out.println ("\nThe book '" + cb.title + "' is returned");
		System.out.println("The current holder of " + cb.title  + " is " + cb.getCurrentHolder() );
		
		//tests the setter
		cb.setCurrentHolder("Ruhee");
		cb.setDueDate(" 7/12/2020");
		cb1.setCurrentHolder(" Vedahi");
		cb1.setDueDate(" 17/10/2018");
		
		//prints out the updated information for the library books
		//Test toString
		System.out.println ("\nUpdated information for the books: ");
		System.out.println(cb);
		System.out.println(cb1);
		

		
	}
}
