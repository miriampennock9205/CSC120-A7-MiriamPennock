import java.util.ArrayList;

/**
 * Represents a house, which is a type of building with residents and possibly a dining room.
 * Extends the Building class
 */
public class House extends Building{
  /** Stores list of residents in the house */
  private ArrayList<String> residents;
  /** Indicated if a house has a dining room */
  private boolean hasDiningRoom;

  /**
   * Constructs a House object with the specified attributes.
   * 
   * @param name The name of the house
   * @param address The address of the house
   * @param nFloors The number of floors in the house
   * @param hasDiningRoom Whether the house has a dining room
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors); //call the Building constructor
    this.residents = new ArrayList<String>(); //Initalize the residents list
    this.hasDiningRoom = hasDiningRoom; //Set whether the house has a dining room
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Checks if the house has a dining room.
   * 
   * @return True if the house has a dining room, false otherwise
   */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /**
   * Gets the number of residents currently in the house.
   * 
   * @return The number of residents in the house
   */
  public int nResidents() {
    return this.residents.size();
  }

  /**
   * Moves a person into the house, adding them to the residents list.
   * If a person is already a resident, a message is printed instead.
   * 
   * @param name The name of the person moving in
   */
  public void moveIn(String name) {
    if (!this.residents.contains(name)) {
      this.residents.add(name); 
    } else {
      System.out.println(name + " is already a resident.");
    }
  }

  /**
   * Moves a person out of the house, removing them from the residents list.
   * If the person is not a resident, a message is printed instead.
   * 
   * @param name The name of the person moving out
   * @return The name of the person who moved out, or null if they were not a resident
   */
  public String moveOut(String name) {
    if (this.residents.contains(name)) {
      this.residents.remove(name);
      return name;
    } else {
      System.out.println(name + " is not a resident.");
      return null;
    }
  }

  /**
   * Tests the functionality of the House class methods.
   * 
   * @param args Command line arguments (not used)
   */
  public static void main(String[] args) {
    //Create a new House object
    House myHouse = new House("My House", "123 Main St", 2, true);
    
    //Test toString method from Building class
    System.out.println(myHouse);

    //Test hadDiningRoom method
    myHouse.hasDiningRoom();

    //Test nResidents method (initially 0)
    myHouse.nResidents();

    //Test moveIn method
    myHouse.moveIn("Alice");
    myHouse.moveIn("Bob");

    //Verify the number of residents after moving in
    System.out.println("Number of residents after moving in: " + myHouse.nResidents());

    // Attempt to move in a resident already in the house
    myHouse.moveIn("Alice");

    // Test moveOut method
    myHouse.moveOut("Alice");

    // Verify number of residents after moving out
    System.out.println("Number of residents after moving out: " + myHouse.nResidents());

    // Attempt to move out a resident not in the house
    myHouse.moveOut("Charlie");
  }
}