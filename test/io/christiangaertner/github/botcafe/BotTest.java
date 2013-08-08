/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package io.christiangaertner.github.botcafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Christian
 */
public class BotTest {
    
    public BotTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of toString method, of class Bot.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Bot instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNextMessage method, of class Bot.
     */
    @Test
    public void testGetNextMessage() throws Exception {
        System.out.println("getNextMessage");
        String lastMessage = "";
        Bot instance = null;
        String expResult = "";
        String result = instance.getNextMessage(lastMessage);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Bot.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String n = "";
        Bot instance = null;
        instance.setName(n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}