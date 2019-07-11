package packer;

/**
 *This is class for the different product that may be sent
 * 
 * @author I.M.Bad
 */
public class Product {

    private String name;
    private int weight;
    private boolean hazardous;
    private boolean fragile;

    /**
     * This is the construct, it takes the parameters and makes a product
     * 
     * @param name is the product name
     * @param weight is the product weight in kg
     * @param hazardous is whether the product is hazardous
     * @param fragile is whether the product is fragile
     */
    public Product(String name, int weight, boolean hazardous, boolean fragile) {
        this.name = name;
        this.weight = weight;
        this.hazardous = hazardous;
        this.fragile = fragile;
    }

    /**
     * This gets the weight
     * 
     * @return the weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * This gets the name
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * This gets whether the product is Hazardous
     * 
     * @return the hazardous
     */
    public boolean isHazardous() {
        return hazardous;
    }

    /**
     * This gets whether the product is fragile
     * 
     * @return the fragile
     */
    public boolean isFragile() {
        return fragile;
    }

    /**
     * This returns a string of the products name
     * 
     * @return product name
     */
    public String toString() {
        return this.getName();
    }
    
    /**
     * This determines if the product is the same as a product it is being
     * compared to by using the products name.
     * 
     * @param o is the other object it being compared to
     * @return true if product have the same name else false
     */
    public boolean equals(Object o) {
        if (!(o instanceof Product)) {
            return false;
        }
        Product p = (Product)o;
        return p.getName().equals(this.getName());
    }
    
}
