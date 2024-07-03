/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author
 */
public class ShipTest {
    
    public ShipTest() {
    }

    
    /**
     * Test ship sunk. Ship is sunk when it's health gets 0. We'll create a ship and intentionally set the health to 
     * zero to check if sunk functionality is working fine. It should return true. We'll also check if ship doesn't 
     * sunk with health greater than 0. In that it should return false.
    **/
    @Test
    public void testIsSunk() {
        Ship s = new Ship(2,2,4,'V');
        boolean expected = false;
        assertEquals(expected, s.isSunk());
        s.setHealth(0);
        expected = true;
        assertEquals(expected, s.isSunk());
    }
    
    /**
     * For testing hit method. We'll create a ship (x = 2, y=2, length = 4, orientation = v). We'll hit the 
     * coordinate (2,3) it should return true. As it's a hit. We'll also test the failed scenario we'll hit 
     * coordinate (2,6) it should return false. As it's a miss.
    **/
    @Test
    public void testIsHit(){
        Ship s = new Ship(2,2,4,'V');
        boolean expected = true;
        assertEquals(expected, s.isHit(2, 3));
        expected = false;
        assertEquals(expected, s.isHit(2, 6));
    }
    
    /**
     * We'll test if the ship is created correctly. We'll create a ship (x = 2, y=2, length = 4, orientation = v)
     * we'll get it's attribute one by one to verify if they are correct. It's x value should be 2 and y should be 2 
     * Length should be 4 and health should be 4. isSunk should return false.
     **/
    @Test
    public void testShipCreation(){
        Ship s = new Ship(2,2,4,'V');
        int expected = 2;
        assertEquals(expected, s.getHeadX());
        expected = 2;
        assertEquals(expected, s.getHeadY());
        expected = 4;
        assertEquals(expected, s.getLength());
        expected = 4;
        assertEquals(expected, s.getHealth());
        expected = 3;
        s.isHit(2, 2);
        assertEquals(expected, s.getHealth());
        assertEquals(false, s.isSunk());
    }

    
}
