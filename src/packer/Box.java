package packer;

/**
 *This is the box class
 * 
 * @author I.M.Bad
 */
public class Box {

    private Manifest contents;
    private Customer customer;
    private Depot depot;
    
    /**
    *This is the box constructor, contents only change when products are
    * added of removed from the box.
    * @param customer the box belongs
    * @param depot the box will be sent from
    * 
    */

    public Box(Customer customer, Depot depot) {
        this.customer = customer;
        this.depot = depot;
        contents = new Manifest();
    }
    
    /**
     * This adds a product to the box
     * @param product that is being added
     */
    public void addProduct(Product product) {
        if (canFit(product)) {
            contents.addProduct(product, 1);
        }
    }

    /**
     * This adds multiple of the same product to the box
     * @param product that is being added
     * @param quantity of the product being added
     */
    public void addProduct(Product product, int quantity) {
        if (canFit(product, quantity));
        {
            contents.addProduct(product, quantity);
        }
    }
    
    /**
     * This creates a string with all the information required for the label as
     * per clients requirements, the last /n is remove at the end by 
     * using label.length()-1
     * 
     * @return String is the string will all information required
     */
    public String getLabel() {
        StringBuilder label = new StringBuilder();
        label.append(customer);
        label.append("\n");
        label.append(customer.getClosestAddressTo(depot));
        label.append("\n");
        label.append(contents.toString());
        label.append("\n");
        if (this.isFragile()) {
            label.append("FRAGILE\n");
        }
        if (this.isHazardous()) {
            label.append("HAZARD\n");
        }
        if (contents.getTotalWeight() > 15) {
            label.append("HEAVY\n");
        }
        return label.substring(0, label.length()-1);
    }
    
    /**
     * This calls the string created in label
     * 
     * @return String with the label info
     */
    public String toString() {
        return getLabel();
    }
    
    /**
     * This gets the Weight of all items in the box from the manifest of the 
     * contents of the box
     * @return Double is the weight of products in the box
     */
    public double getWeight() {
        return contents.getTotalWeight();
    }

    /**
     * This takes a product and determines if it can fit in the box
     * @param p the product that might fit in the box
     * @return true it will fit else false
     */
    public boolean canFit(Product p) {
        return canFit(p, 1);
    }
    
    /**
     * This takes multiple products and determines if they can fit in the box
     * 
     * @param p the product that might fit in the box
     * @param quantity of the product trying to fit in the box
     * @return true it will fit else false
     */
    public boolean canFit(Product p, int quantity) {
        return (p.getWeight() * quantity) < 20;
    }

    /**
     * This is the amount of weight left left before the box weighs 20kg
     * 
     * @return double of kilograms that could still be put in box
     */
    public double remainingCapacity() {
        return 20 - this.getWeight();
    }

    /**
     * This returns a boolean when a fragile product is in the box.
     * 
     * @return true if a fragile item had been packed else false
     */
    public boolean isFragile() {
        return contents.hasFragileItems();
    }

    /**
     * This returns a boolean when a hazardous product is in the box.
     * 
     * @return true if a hazardous item has been packed else false.
     */
    public boolean isHazardous() {
        return contents.hasHazardousItems();
    }
}
