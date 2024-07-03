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
public class PlayerTest {
    
    public PlayerTest() {
    }
    // Test if the player name is set properly. I set the player name and get it to see if it works fine. 
    // I set the player name to "Test" and it should return "Test".
    @Test
    public void testPlayerName() {
        Player p = new Player();
        String expect = "Test";
        p.setName("Test");
        assertEquals(expect, p.getName());
    }
    // Tested the player name it's working fine.
    
    
    // if we create an Player object and try to get name and tries, name should be "" and tries should 0.
    @Test
    public void testEmptyPlayerObject() {
        Player p = new Player();
        String expect = "";
        int expected_tries = 0;
        assertEquals(expect, p.getName());
        assertEquals(expected_tries, p.getTries());
    }
    // it Passed the test it's giving the expected results.
    
    
    // Negative tries can't be set.
    @Test
    public void testSetTries() {
        Player p = new Player();
        int expected = 0;
        p.setTries(-1);
        assertEquals(expected , p.getTries());
    }
    
}
