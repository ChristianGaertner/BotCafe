/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package io.christiangaertner.github.botcafe.ui;

import io.christiangaertner.github.botcafe.BotConversation;
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
public class ChatDisplayerTest {
    
    public ChatDisplayerTest() {
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
     * Test of addMessage method, of class ChatDisplayer.
     */
    @Test
    public void testAddMessage_BotConversationMessage() {
        System.out.println("addMessage");
        BotConversation.Message msg = null;
        ChatDisplayer instance = null;
        instance.addMessage(msg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addMessage method, of class ChatDisplayer.
     */
    @Test
    public void testAddMessage_String_String() {
        System.out.println("addMessage");
        String name = "";
        String msg = "";
        ChatDisplayer instance = null;
        instance.addMessage(name, msg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addMessage method, of class ChatDisplayer.
     */
    @Test
    public void testAddMessage_String() {
        System.out.println("addMessage");
        String txt = "";
        ChatDisplayer instance = null;
        instance.addMessage(txt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}