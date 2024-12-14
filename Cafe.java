
/**
 * Represents a cafe with inventory for coffee, sugar, cream and cups.
 * Extends the Building class
 */
public class Cafe extends Building {

    /**
     * The number of ounces of coffee in stock
     */
    private int nCoffeeOunces;
    /**
     * The number of sugar packets in stock
     */
    private int nSugarPackets;
    /**
     * The number of "splashes" of cream in stock
     */
    private int nCreams;
    /**
     * The number of cups in stock
     */
    private int nCups;

    /**
     * Constructs a Cafe object with specified inventory levels.
     *
     * @param name The name of the cafe
     * @param address The address of the cafe
     * @param nFloors The number of floors in the cafe building
     * @param nCoffeeOunces The number of floors in the cafe building
     * @param nSugarPackets The initial stock of sugar packets
     * @param nCreams The inital stock of cream splashes
     * @param nCups The inital stock of cups
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Constructs a cafe object with a default number of floors and default
     * stock levels.
     *
     * @param name The name of the cafe
     * @param address The address of the cafe
     */
    public Cafe(String name, String address) {
        this(name, address, 1, 1000, 500, 200, 300);  // Default stock levels
    }

    /**
     * Displays the available options for the Cafe, including options from the
     * superclass and additional Cafe-specific options.
     */
    @Override
    public void showOptions() {
        super.showOptions();
        System.out.println(" + sellCoffee() \n + restock()");
    }

    /**
     * Sells a coffee with a specified size, sugar packets, and cream, updating
     * inventory. If inventory is insufficient, prints an error message.
     *
     * @param size The size of the coffee in ounces
     * @param nSugarPackets The number of sugar packets requested
     * @param nCreams The number of cream splashes requested
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (nCoffeeOunces >= size && nSugarPackets <= this.nSugarPackets && nCreams < this.nCreams && nCups > 0) {
            this.nCoffeeOunces -= size; //Reduce coffee stock
            this.nSugarPackets -= nSugarPackets; //Reduce sugar stock
            this.nCreams -= nCreams; //Reduce cream stock
            this.nCups -= 1; //Reduce cup stock
            System.out.println("Coffee sold!");
        } else {
            System.out.println("Cannot complete sale: not enough stock.");
        }
    }

    // Overloaded sellCoffee to sell by type
    public void sellCoffee(String type) {
        if (type.equalsIgnoreCase("espresso")) {
            sellCoffee(2, 1, 1);
        } else if (type.equalsIgnoreCase("latte")) {
            sellCoffee(8, 2, 3);
        }
    }

    /**
    * Overrides the goToFloor method to indicate that the Cafe does not have multiple floors
    * accessible to guests. This method throws an exception to prevent the invalid operation.
    *
    * @param floor The floor number (ignored in this implementation)
    * @throws UnsupportedOperationException if an attempt is made to access a different floor
    */
    @Override
    public void goToFloor(int floor) {
        throw new UnsupportedOperationException("This cafe doesn't have more than one floor for guests.");
    }

    /**
     * Restocks the cafe's inventory by adding specfied amounts of coffee,
     * sugar, cream, and cups.
     *
     * @param nCoffeeOunces The number of coffee ounces to add
     * @param nSugarPackets The number of sugar packets to add
     * @param nCreams The number of cream splashes to add
     * @param nCups The number of cups to add
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    /**
     * Restocks the cafe's inventory by adding the same amount to each item.
     *
     * @param quantity The amount to add to each inventory item
     */
    private void restock(int quantity) {
        this.nCoffeeOunces += quantity;
        this.nSugarPackets += quantity;
        this.nCreams += quantity;
        this.nCups += quantity;
        System.out.println("Restocked all items by " + quantity + " units.");
    }

    /**
     * Tests the functionality of the Cafe class methods.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {

        //Create a new Cafe object with inital stock
        Cafe myCafe = new Cafe("Campus Cafe", "100 Green St, Northampton, MA", 1, 100, 50, 30, 20);

        //Test toString method from Building class
        System.out.println(myCafe);

        //Example of selling coffee (which is 12 ounces, has 2 sugar packets and 1 cream)
        myCafe.sellCoffee(12, 2, 1);

        //Check inventory after sale
        System.out.println("After sale:");
        System.out.println("Coffee Ounces: " + myCafe.nCoffeeOunces);
        System.out.println("Sugar Packets: " + myCafe.nSugarPackets);
        System.out.println("Creams: " + myCafe.nCreams);
        System.out.println("Cups: " + myCafe.nCups);

        //Example of restocking (adding 50 ounces of coffee, 20 packets of sugar, 15 creams, 10 cups)
        myCafe.restock(50, 20, 15, 10);

        //Check inventory after sale
        System.out.println("After sale:");
        System.out.println("Coffee Ounces: " + myCafe.nCoffeeOunces);
        System.out.println("Sugar Packets: " + myCafe.nSugarPackets);
        System.out.println("Creams: " + myCafe.nCreams);
        System.out.println("Cups: " + myCafe.nCups);
        myCafe.goToFloor(2);

    }

}
