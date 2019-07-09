/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ryan
 */
public class ProductWeightComparatorTest {
    
    public ProductWeightComparatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    Product a1 = new Product("Alpha1", 0, true, true);
    Product a2 = new Product("Alpha2", 2, true, true);
    Product a3 = new Product("Alpha3", 3, false, true);
    Product a4 = new Product("Alpha4", 4, true, false);
    Product a5 = new Product("AlphaBet", 24, false, false);
    

    /**
     * Test of compare method, of class ProductWeightComparator.
     */
    @Test
    public void testCompare() {
        //arrertEquals(1, ProductWeightComparator.compare(a1, a2));
        
    }
    
}
