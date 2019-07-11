package packer;

import java.util.ArrayList;
import java.util.List;

/**
 *This is the packer class, it packs all products in a manifest into boxes as
 * per business rules and gets the right address for them for the depot they are
 * being sent from.
 * 
 * @author bunta
 */
public class Packer {

    /**
     * packProduct is the only method in this class, but it really does some
     * business, packing the manifest for the customer from the depot in to a 
     * nice tidy array of boxes.
     * 
     * @param c is the customer who will be sent the products
     * @param d is the depot were the good will be sent from
     * @param m manifest of items to be packed
     * @return a list of Boxes packed per business rules
     */
    public static List<Box> packProducts(Customer c, Depot d, Manifest m) {
        List<Box> packedBoxes = new ArrayList<>();
        Box b = null;
        while (!m.isEmpty()) { // repeat until all items are packed
            if (b == null) {
                b = new Box(c,d);
            }
            Product prodToAdd = m.getHeaviestUnder(b.remainingCapacity());
            if (prodToAdd == null) {
                packedBoxes.add(b);
                b = null;
            }
            else {
                b.addProduct(prodToAdd);   
                m.removeProduct(prodToAdd);
            }  
        }
        if (b != null) {
            packedBoxes.add(b);
            //packedBoxes.add(b);
        }
        return packedBoxes;
    }
    
}
