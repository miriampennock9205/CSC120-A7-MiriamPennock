/**
 * Represents a cafe with inventory for coffee, sugar, cream and cups.
 * Extends the Building class
 */
public class Cafe extends Building{
    /**The number of ounces of coffee in stock*/
    private int nCoffeeOunces;
    /** The number of sugar packets in stock */
    private int nSugarPackets;
    /** The number of "splashes" of cream in stock */
    private int nCreams;
    /** The number of cups in stock */
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
     * Sells a coffee with a specified size, sugar packets, and cream, updating inventory.
     * If inventory is insufficient, prints an error message.
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
    
    /**
     * Restocks the cafe's inventory by adding specfied amounts of coffee, sugar, cream, and cups.
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

    }
    
}
