/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packer;

import java.util.List;
import java.util.ArrayList;
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
public class PackerTest {
    
    
    
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Packer Tests");
    }
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
    Address testAddress10 = new Address("1", "2", "3", "4", testCoordinates0);
    
    Depot testDepot0 = new Depot("Test Depot", testAddress0);
    Depot testDepot4 = new Depot("Test Depot", testAddress4);
    
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
     * Test of packProducts method, of class Packer.
     */
    @Test
    public void testPackProducts() {
        m1.addProduct(a1);
        Customer c1 = new Customer("J", testAddress10);
        Box b1 = new Box(c1, testDepot0);
        b1.addProduct(a1);
        List<Box> bL = new ArrayList<>();
        bL.add(b1);
        assertEquals(b1.toString(), Packer.packProducts(c1, testDepot0, m1).get(0).toString());
        //System.out.println(Packer.packProducts(c1, testDepot0, m1));
    }
    
}
