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
public class BotConversationTest {
    
    public BotConversationTest() {
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
     * Test of addBot method, of class BotConversation.
     */
    @Test
    public void testAddBot() {
        System.out.println("addBot");
        Bot b = null;
        BotConversation instance = null;
        instance.addBot(b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of run method, of class BotConversation.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        BotConversation instance = null;
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessage method, of class BotConversation.
     */
    @Test
    public void testGetMessage() {
        System.out.println("getMessage");
        BotConversation instance = null;
        BotConversation.Message expResult = null;
        BotConversation.Message result = instance.getMessage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}