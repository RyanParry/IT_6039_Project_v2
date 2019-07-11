package packer;

/**
 *This is the Depot class, it builds the clients depot.
 * 
 * @author I.M.Bad
 */
public class Depot {
    private String name;
    private Address address;

    /**
     * This is the constructor for the depot
     * 
     * @param name is the name of the depot
     * @param address is the address of the depot, coordinates will be in the
     * address
     */
    public Depot(String name, Address address) {
        this.name = name;
        this.address = address;
    }
    
    /**
     * This gets the name
     * 
     * @return a string of the depot name
     */
    public String getName() {
        return name;
    }
    
    /**
     * This get the coordinates from the address of the depot
     * 
     * @return the coordinates of the depot
     */
    public Coordinates getCoordinates() {
        return this.address.getCoordinates();
    }
    
    /**
     * This returns a string of the depots name
     * 
     * @return string of the depots name
     */
    public String toString() {
        return this.getName();
    }
    
}
