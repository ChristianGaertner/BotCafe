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
public class BotCafeTest {
    
    public BotCafeTest() {
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
     * Test of main method, of class BotCafe.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        BotCafe.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of start method, of class BotCafe.
     */
    @Test
    public void testStart() throws Exception {
        System.out.println("start");
        BotCafe instance = new BotCafe();
        instance.start();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}