package packer;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the customer class it has the info on the customer and can call the 
 * closest address to the depot.
 *
 * @author I.M.Bad
 */
public class Customer {
    
    private String name;
    private List<Address> addresses;

    /**
     * This the constructor for new Customers
     * 
     * @param name is the customer mane
     * @param address is the first address in the customers array of addresses
     */
    public Customer(String name, Address address) {
        addresses = new ArrayList<>();
        this.name = name;
        this.addresses.add(address);
    }
    
    /**
     * This adds more address to the customers array of addresses
     * 
     * @param address is the new address being added
     */
    public void addAddress(Address address) {
        this.addresses.add(address);
    }
    
    /**
     * This return the customers name as a string
     * 
     * @return the customers name as a string
     */
    public String getName() {
        return name;
    }

    /**
     * This gets the customers address that is closest to a depot.
     * 
     * @param d is the depot
     * @return Address that is closest to the depot
     */
    public Address getClosestAddressTo(Depot d) {
        double bestDistance = Double.MAX_VALUE;
        Address bestAddress = null;
        for (Address a : addresses) {
            double distance = a.getCoordinates().companyDistanceTo(d.getCoordinates());
            if (distance < bestDistance) {
                bestDistance = distance;
                bestAddress = a;
            }
        }
        return bestAddress;
    }

    /**
     * This returns the customers name as string
     * 
     * @return a string of the customers name
     */
    public String toString() {
        return this.getName();
    }
}
