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
public class BoxTest {
        // Test data
    Coordinates testCoordinates0 = new Coordinates(0,0);
    Coordinates testCoordinates1 = new Coordinates(3,4);
    Coordinates testCoordinates2 = new Coordinates(30,40);
    Coordinates testCoordinates3 = new Coordinates(300, 400);
    Coordinates testCoordinates4 = new Coordinates(3000, 4000);
    
    Address testAddress0 = new Address("111 Emerge Rd", "Really", "Inn Town", "D444", testCoordinates0);
    Address testAddress1 = new Address("1 First St", "Aplace", "Citadel City", "A111", testCoordinates1);
    Address testAddress2 = new Address("123 Count St", "Brooklyn", "Welling Town", "B222", testCoordinates2);
    Address testAddress3 = new Address("321 Back St", "Christly", "Holly Oaks", "C333", testCoordinates3);
    Address testAddress4 = new Address("55 Some St", "Somewhere", "Elsewhere", "E555", testCoordinates4);
    
    Depot testDepot0 = new Depot("Test Depot", testAddress0);
    Depot testDepot4 = new Depot("Test Depot", testAddress4);
    
    Customer testCustomer = new Customer("Test Customer", testAddress3);
    Customer testCustomer1 = new Customer("Test Customer", testAddress2);
    Customer testCustomer2 = new Customer("Test Customer", testAddress4);
    Customer testCustomer3 = new Customer("Test Customer", testAddress0);
    
    Box testBox1 = new Box(testCustomer, testDepot0);
    Box testBox2 = new Box(testCustomer1, testDepot4);
    Box testBox3 = new Box(testCustomer, testDepot0);
    Box testBox4 = new Box(testCustomer3, testDepot4);
    
    Product a1 = new Product("Alpha1", 0, true, true);
    Product a2 = new Product("Alpha", 2, true, true);
    Product a3 = new Product("Alpha", 3, false, true);
    Product a4 = new Product("Alpha", 4, true, false);
    Product a5 = new Product("Alpha", 24, false, false);
   
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Box class...");
    }
    


    /**
     * Test of toString method, of class Box.
     */
    @Test
    public void testToString() {
        testBox1.addProduct(a3);
        System.out.println("To String Test Are....");
        System.out.println(testBox1.toString());
        assertEquals("Test Customer\n321 Back St\nChristly\nHolly Oaks\nC333\n"
                + "Alpha x 1\nFRAGILE", testBox1.toString());
        testBox2.addProduct(a4);
        assertEquals("Test Customer\n123 Count St\nBrooklyn\nWelling Town\nB222\n"
                + "Alpha x 1\nHAZARD", testBox2.toString());
        testBox3.addProduct(a4, 4);
        assertEquals("Test Customer\n321 Back St\nChristly\nHolly Oaks\nC333\n"
                + "Alpha x 4\nHAZARD\nHEAVY", testBox3.toString());
        System.out.println(testBox1.toString());
        testBox4.addProduct(a1, 2);
        testBox4.addProduct(a2, 8);
        assertEquals("Test Customer\n111 Emerge Rd\nReally\nInn Town\nD444\n"
                + "Alpha1 x 2\nAlpha x 8\nFRAGILE\nHAZARD\nHEAVY", testBox4.toString());
    }

    /**
     * Test of getWeight method, of class Box.
     */
    @Test
    public void testGetWeight() {
        testBox1.addProduct(a3, 3);
        testBox2.addProduct(a2);
        testBox3.addProduct(a4, 4);
        testBox4.addProduct(a1, 3);
        assertEquals(9.0, testBox1.getWeight(), 0.0001);
        assertEquals(2.0, testBox2.getWeight(), 0.0001);
        assertEquals(16.0, testBox3.getWeight(), 0.0001);
        assertEquals(0.0, testBox4.getWeight(), 0.0001);
    }

    /**
     * Test of canFit method, of class Box.
     */
    @Test
    public void testCanFit_Product() {
        assertEquals(true, testBox1.canFit(a2));
        assertEquals(true, testBox1.canFit(a3));
        assertEquals(true, testBox1.canFit(a4));
        assertEquals(false, testBox1.canFit(a5));
    }

    /**
     * Test of canFit method, of class Box.
     */
    @Test
    public void testCanFit_Product_int() {
        assertEquals(false, testBox1.canFit(a2, 11));
        assertEquals(true, testBox1.canFit(a2, 9));
        assertEquals(false, testBox1.canFit(a3, 7));
        assertEquals(true, testBox1.canFit(a4, 2));
    }

    /**
     * Test of remainingCapacity method, of class Box.
     */
    @Test
    public void testRemainingCapacity() {
        testBox1.addProduct(a3, 3);
        testBox2.addProduct(a2);
        testBox3.addProduct(a1);
        testBox4.addProduct(a4, 5);
        assertEquals(11.0, testBox1.remainingCapacity(), 0.0001);
        assertEquals(18.0, testBox2.remainingCapacity(), 0.0001);
        assertEquals(20.0, testBox3.remainingCapacity(), 0.0001);
        assertEquals(0.0, testBox4.remainingCapacity(), 0.0001);
    }

    /**
     * Test of isFragile method, of class Box.
     */
    @Test
    public void testIsFragile() {
        testBox1.addProduct(a3, 3);
        testBox2.addProduct(a2);
        testBox3.addProduct(a1);
        testBox4.addProduct(a4, 5);
        assertEquals(true, testBox1.isFragile());
        assertEquals(true, testBox2.isFragile());
        assertEquals(true, testBox3.isFragile());
        assertEquals(false, testBox4.isFragile());
    }

    /**
     * Test of isHazardous method, of class Box.
     */
    @Test
    public void testIsHazardous() {
        testBox1.addProduct(a3, 3);
        testBox2.addProduct(a2);
        testBox3.addProduct(a1);
        testBox4.addProduct(a4, 5);
        assertEquals(false, testBox1.isHazardous());
        assertEquals(true, testBox2.isHazardous());
        assertEquals(true, testBox3.isHazardous());
        assertEquals(true, testBox4.isHazardous());

    }
    
}
