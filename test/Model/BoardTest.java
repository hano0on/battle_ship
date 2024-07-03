/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author
 */
public class BoardTest {
    
    public BoardTest() {
    }
    
    
    /**
     * This function randomly Place all the ships and it return true in case all ship placed successfully.
     * for counter we'll check the total ships on the board it should be 5.
     */
    @Test
    public void testPlaceRandomlyAllShips() {
        Board b = new Board();
        boolean expect = true;
        assertEquals(expect, b.placeRandomlyAllShips());
        int expected_ships = 5;
        assertEquals(expected_ships, b.getShipsOnBoard());
    }

    /**
     * Let test the placement of the ship. Place the ship (x = 2, y=2, length = 4, orientation = v)
     * which is a valid placement it should return return true and we'll verify by getting ships on board.
     */
    @Test
    public void testPlaceShip() {
        Ship s = new Ship(2,2,4,'V');
        Board b = new Board();
        boolean expResult = true;
        boolean result = b.placeShip(s);
        assertEquals(expResult, result);
        int expected_ship = 1;
        assertEquals(expected_ship, b.getShipsOnBoard());
    }

    /**
     * Place a ship and than attack part of the ship. It should return true if ship hits.
     */
    @Test
    public void testAttack() {
        Ship s = new Ship(2,2,4,'V');
        Board b = new Board();
        boolean expResult = true;
        b.placeShip(s);
        assertEquals(expResult, b.attack(2,5));
    }


    
}
