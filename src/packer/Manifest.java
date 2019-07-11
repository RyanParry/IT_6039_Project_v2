package packer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 *This is a class of manifest, creates a liste of items and keys them with their
 * quantities and creates and ordered set by the weight of the products in the
 * list.
 * 
 * @author I.M.Bad
 */
public class Manifest {
    
    // This tracks the quantity if each product in the manifest
    private Map<Product, Integer> quantities;
    // This keeps a list of all products ordered by weight
    private Set<Product> byWeight;

    /**
     * This the constructor, items have to be added to the manifest through 
     * the addProduct functions and removed by the removeProduct function.
     */
    public Manifest() {
        quantities = new HashMap<>();
        byWeight = new TreeSet<>(new ProductWeightComparator());
    }
    
    /**
     * Adds one product to the manifest
     * 
     * @param p is the product being added
     */
    public void addProduct(Product p) {
        addProduct(p,1);
    }
    
    /**
     * This adds multiple product to the manifest
     * 
     * @param p are the products being added
     * @param quantity is the amount of product to be added to the manifest
     */
    public void addProduct(Product p, int quantity) {
        if (quantities.containsKey(p)) {
            quantities.put(p,quantities.get(p) + quantity);
        }
        else {
            quantities.put(p,quantity);
            if(!byWeight.add(p)) {
                System.out.println("Couldn't add to Set");
            }
        }
    }
    
    /**
     * This removes a product from the manifest if it is the manifest, otherwise
     * console logs that it cant be do that.  If it is the last the product type
     * in the manifest (quantity = 1) it will be removed from the byWeight set.
     * 
     * @param p is the product removed from manifest
     */
    public void removeProduct(Product p) {
        if (quantities.containsKey(p) && quantities.get(p) > 0) {
            if (quantities.get(p) == 1) {
                quantities.remove(p);
                byWeight.remove(p);
            }
             else {
            quantities.put(p,quantities.get(p) - 1);
            }
        }
        else {
            System.out.println("Could not remove Product");
        }
    }
   
    
    /**
     * Gets the total weight of all items in the manifest
     * 
     * @return the total weight of all items in the manifest in kg
     */
    public double getTotalWeight() {
        double weight = 0;
        for (Product p : quantities.keySet()) {
            weight = weight + (quantities.get(p) * p.getWeight());
        }
        return weight;
    }
    
    /**
     * Returns the heaviest product in the manifest under a given weight
     * 
     * @param weight a double for kg that the return must be under
     * @return the heaviest product in the manifest under a given weight in kg
     */
    public Product getHeaviestUnder(double weight) {
        for (Product p : byWeight) {
            if (p.getWeight() <= weight) {
                return p;
            }
        }
        return null;
    }
    
    /**
     * This is a boolean if any items are left in a manifest, the items may
     * still remain in the list but if the quantities are 0 then the it will
     * considered empty
     * 
     * @return true if there are any items with a quantity greater than 0 in the
     * manifest, else false
     */
    public boolean isEmpty() {
        int itemsLeft = 0;
        for (Product p : quantities.keySet()) {
            itemsLeft = itemsLeft + quantities.get(p);
        }
        if(itemsLeft > 0){
            return false;
        }
        else {
            return true;
        }
    }
    
    /**
     * This tells whether a particular item is in the manifest, the must be more
     * than 0 items in the manifest for it to return true.
     * 
     * @param p is the product to see if is in the manifest
     * @return true if there 1 or in the manifest, else false
     */
    public boolean containsProduct(Product p) {
        return quantities.containsKey(p) && quantities.get(p) > 0;
    }
    
    /**
     * This builds a string with all item in the manifest and there quantities
     * the items are order so that tests can predict the expected results
     * 
     * @return a string of all items in manifest and their quantities
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        List<String> itemsOrdered = new ArrayList<>();
        //creates an order the products so tests can be predictive
        for (Product p : quantities.keySet()) {
            itemsOrdered.add(p.getName() + " x " + quantities.get(p) + "\n");
            Collections.sort(itemsOrdered);
        }
        for (String s : itemsOrdered){
                result.append(s);
            }
        //Collections.sort(itemsOrdered);
        if (result.length() >= 1){
            return result.substring(0, result.length()-1);
        }
        else {
            return result.substring(0, result.length());
        }
        
    }
    
    /**
     * Tells you if a fragile item is in the manifest
     * 
     * @return true if there is a fragile item in the manifest, else false
     */
    public boolean hasFragileItems() {
        for (Product p : quantities.keySet()) {
            if (p.isFragile()) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Tells you if a hazardous item is in the manifest
     * 
     * @return true if there is a hazardous item in the manifest, else false
     */
    public boolean hasHazardousItems() {
        for (Product p : quantities.keySet()) {
            if (p.isHazardous()) {
                return true;
            }
        }
        return false;
    }
}

