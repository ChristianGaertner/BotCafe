/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package io.christiangaertner.github.botcafe.voice;

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
public class GoogleVoiceTest {
    
    public GoogleVoiceTest() {
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
     * Test of read method, of class GoogleVoice.
     */
    @Test
    public void testRead() {
        System.out.println("read");
        String txt = "";
        GoogleVoice instance = null;
        instance.read(txt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}