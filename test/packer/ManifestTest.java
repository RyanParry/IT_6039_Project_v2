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
public class ManifestTest {
    
    public ManifestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Manifest class...");
    }
    
    
    Product a1 = new Product("Alpha1", 0, true, true);
    Product a2 = new Product("Alpha2", 2, true, true);
    Product a3 = new Product("Alpha3", 3, false, true);
    Product a4 = new Product("Alpha4", 4, true, false);
    Product a5 = new Product("AlphaBet", 24, false, false);
    
    Manifest m1 = new Manifest();
    Manifest m2 = new Manifest();
    Manifest m3 = new Manifest();
    Manifest m4 = new Manifest();
    


    /**
     * Test of getTotalWeight method, of class Manifest.
     */
    @Test
    public void testGetTotalWeight() {
        System.out.println("getTotalWeight");
        m1.addProduct(a2, 5);
        m1.addProduct(a3);
        m2.addProduct(a5);
        m3.addProduct(a3, 3);
        m3.removeProduct(a3);
        m4.addProduct(a4);
        m4.addProduct(a2, 2);
        assertEquals(13.0, m1.getTotalWeight(), 0.0001);
        assertEquals(24.0, m2.getTotalWeight(), 0.0001);
        assertEquals(6.0, m3.getTotalWeight(), 0.0001);
        assertEquals(8.0, m4.getTotalWeight(), 0.0001);
    }

    /**
     * Test of getHeaviestUnder method, of class Manifest.
     */
    @Test
    public void testGetHeaviestUnder() {
        m1.addProduct(a2, 5);
        m1.addProduct(a3);
        m2.addProduct(a5);
        m3.addProduct(a3, 3);
        m3.addProduct(a4);
        m4.addProduct(a4);
        m4.addProduct(a2, 2);
        m4.addProduct(a1, 2);
        assertEquals(a2, m1.getHeaviestUnder(2.2));
        assertEquals(a3, m1.getHeaviestUnder(3.3));
        assertEquals(null, m2.getHeaviestUnder(20.0));
        assertEquals(a4, m3.getHeaviestUnder(5.0));
        assertEquals(a3, m3.getHeaviestUnder(3.9));
        assertEquals(a2, m4.getHeaviestUnder(3.0));
        assertEquals(a4, m4.getHeaviestUnder(5.0));
        assertEquals(a1, m4.getHeaviestUnder(1.0));
        assertEquals(null, m3.getHeaviestUnder(0.5));
        m3.removeProduct(a4);
        assertEquals(a3, m3.getHeaviestUnder(6.0));
    }

    /**
     * Test of isEmpty method, of class Manifest.
     */
    @Test
    public void testIsEmpty() {
        m1.addProduct(a1);
        m3.addProduct(a3, 3);
        assertEquals(false, m1.isEmpty());
        assertEquals(true, m2.isEmpty());
        assertEquals(false, m3.isEmpty());
        assertEquals(true, m4.isEmpty());
        m4.addProduct(a2);
        assertEquals(false, m4.isEmpty());
            
    }

    /**
     * Test of containsProduct method, of class Manifest.
     */
    @Test
    public void testContainsProduct() {
        m1.addProduct(a2, 5);
        m1.addProduct(a3);
        m2.addProduct(a5);
        m3.addProduct(a3, 3);
        m3.addProduct(a4);
        m4.addProduct(a4);
        m4.addProduct(a2, 2);
        m4.addProduct(a1, 2);
        assertEquals(true, m1.containsProduct(a2));
        assertEquals(true, m1.containsProduct(a3));
        assertEquals(false, m1.containsProduct(a1));
        assertEquals(false, m1.containsProduct(a4));
        assertEquals(true, m2.containsProduct(a5));
        assertEquals(false, m2.containsProduct(a2));
        assertEquals(false, m2.containsProduct(a3));
        assertEquals(true, m3.containsProduct(a4));
        assertEquals(true, m3.containsProduct(a3));
        assertEquals(false, m3.containsProduct(a1));
        assertEquals(true, m4.containsProduct(a2));
        assertEquals(true, m4.containsProduct(a1));
        assertEquals(false, m4.containsProduct(a5));
    }

    /**
     * Test of toString method, of class Manifest.
     */
    @Test
    public void testToString() {
        System.out.println("ToString test results");
        m1.addProduct(a2, 3);
        m2.addProduct(a2);
        m3.addProduct(a2, 3);
        m3.addProduct(a2, 3);
        m4.addProduct(a5);
        assertEquals("Alpha2 x 3", m1.toString());
        assertEquals("Alpha2 x 1", m2.toString());
        assertEquals("Alpha2 x 6", m3.toString());
        assertEquals("AlphaBet x 1", m4.toString());
        m3.removeProduct(a2);
        System.out.println(m3.toString());
        assertEquals("Alpha2 x 5", m3.toString());
        m3.removeProduct(a2);
        assertEquals("Alpha2 x 4", m3.toString());
    }

    /**
     * Test of hasFragileItems method, of class Manifest.
     */
    @Test
    public void testHasFragileItems() {
        m1.addProduct(a2, 5);
        m1.addProduct(a3);
        m2.addProduct(a5);
        m3.addProduct(a3, 3);
        m3.addProduct(a4);
        m4.addProduct(a4);
        m4.addProduct(a2, 2);
        m4.addProduct(a1, 2);
        assertEquals(true, m1.hasFragileItems());
        assertEquals(false, m2.hasFragileItems());
        assertEquals(true, m3.hasFragileItems());
        assertEquals(true, m4.hasFragileItems());
    }
    
    
    public void testHasHazardousItems() {
        m1.addProduct(a2, 5);
        m1.addProduct(a3);
        m2.addProduct(a5);
        m3.addProduct(a3, 3);
        m4.addProduct(a4);
        m4.addProduct(a2, 2);
        m4.addProduct(a1, 2);
        assertEquals(true, m1.hasFragileItems());
        assertEquals(false, m2.hasFragileItems());
        assertEquals(false, m3.hasFragileItems());
        assertEquals(true, m4.hasFragileItems());
    }
}
