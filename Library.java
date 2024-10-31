import java.util.Hashtable;
import javax.swing.border.TitledBorder;

/**
 * Represents a library, which is a type of building that contains a collection of books.
 * Extends the Building class.
 */
public class Library extends Building {

    /** Stores book titles and their availability in the library */
    private Hashtable<String, Boolean> collection;

    /**
     * Constructs a Library object with the specified attributes.
     * 
     * @param name The name of the library
     * @param address The address of the library
     * @param nFloors The number of floors of the library
     */
    public Library(String name, String address, int nFloors) {      
    super(name, address, nFloors); //Call the Building constructor
    this.collection = new Hashtable<String, Boolean>(); //Initialize the collection
    System.out.println("You have built a library: 📖");
    }
  
    /**
     * Adds a book title to the collection and marks it as available.
     * 
     * @param title The title of the book to add
     */
    public void addTitle(String title) {
      collection.put(title, true); //Add the title and mark it as available
    }

    /**
     * Removes a book title from the library collection.
     * 
     * @param title The title of the book to remove
     * @return The title of the book if it was removed, or null if it was not found
     */
    public String removeTitle(String title) {
        if (collection.containsKey(title)) {
          collection.remove(title); //Remove the title if it exists
          return title;
        } else {
          return null; //Return null if the title doesn't exist
        }
    }

    /**
     * Checks out a book by marking it as unavailable in the library collection.
     * 
     * @param title The title of the book to check out
     */
    public void checkOut(String title) {
      if (collection.containsKey(title) && collection.get(title)) {
        collection.replace(title, false); //Mark the title as checked out
      } else {
        System.out.println("Book not available for checkout.");
      }
    }

    /**
     * Returns a book by marking it as available in the library collection.
     * 
     * @param title The title of the book to return
     */
    public void returnBook(String title) {
      if (collection.containsKey(title)) {
        collection.replace(title, true); //Mark the title as available again
      } else {
        System.out.println("This title was not part of the libary's collection.");
      }
    }

    /**
     * Tests the functionality of the Library class methods.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
      //Create a new Library object
      Library myLibrary = new Library("Smith College Library", "100 Green St, Northampton, MA", 4);

      //Test toString method from Building class
      System.out.println(myLibrary);

      //Test addTitleMethod
      myLibrary.addTitle("The Great Gatsby");
      myLibrary.addTitle("1984");

      // Test removeTitle method
      myLibrary.removeTitle("1984");
      myLibrary.removeTitle("To Kill a Mockingbird"); // Testing removing a non-existent book

      // Test checkOut method
      myLibrary.checkOut("The Great Gatsby"); // Checking out an available book
      myLibrary.checkOut("The Great Gatsby"); // Attempting to check out the same book again

      // Test returnBook method
      myLibrary.returnBook("The Great Gatsby"); // Returning a checked-out book
      myLibrary.returnBook("To Kill a Mockingbird"); // Testing return for a non-existent book
    }
  
  }