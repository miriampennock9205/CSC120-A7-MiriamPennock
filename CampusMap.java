
import java.util.ArrayList;
/**
 * Represents a map of the campus, containing various buildings.
 * Provides functionality to add and remove buildings,
 * display a directory, and demonstrate subclass-specific methods.
 */
public class CampusMap {

    ArrayList<Building> buildings;

    /**
    * Constructs an empty campus map.
    * Initializes an empty list of buildings.
    */    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     *
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     *
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    /**
    * Returns a string representation of the campus map, 
    * including a directory of all buildings and their addresses.
    *
    * @return A formatted string of the campus map.
    */
    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i++) {
            mapString += "\n  " + (i + 1) + ". " + this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    /**
     * Demonstrates the functionality of the CampusMap class,
     * including adding buildings, using subclass-specific methods, 
    * and displaying a directory of buildings.
    *
    * @param args Command line arguments (not used).
    */
    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();

        // Adding various Building instances
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));

        // Adding at least one of each subclass
        Library neilson = new Library("Neilson Library", "7 Neilson Dr", 4, true);
        House talbot = new House("Talbot House", "1 Paradise Rd", 3, true);
        Cafe compass = new Cafe("Compass Cafe", "2 Elm St");

        myMap.addBuilding(neilson);
        myMap.addBuilding(talbot);
        myMap.addBuilding(compass);

        // Adding additional buildings to reach at least 10 total
        myMap.addBuilding(new House("King House", "8 College Ln", 4, false));
        myMap.addBuilding(new House("Chapin House", "3 Chapin Way", 3, true));
        myMap.addBuilding(new Library("Young Library", "12 Prospect St", 2, false));
        myMap.addBuilding(new Cafe("Campus Cafe", "5 Elm St"));
        myMap.addBuilding(new Building("College Hall", "10 Elm St", 5));
        myMap.addBuilding(new Building("Seelye Hall", "3 Seelye Dr", 3));

        // Display the map
        System.out.println(myMap);

        // Example usage of subclass-specific methods to demonstrate constructors and functionality
        neilson.addTitle("The Odyssey");
        talbot.addResident("Jane Doe");
        compass.sellCoffee("latte");

        // Show options for each building
        for (Building building : myMap.buildings) {
            building.showOptions();
        }
    }

}
