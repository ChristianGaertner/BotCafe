/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package io.christiangaertner.github.botcafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Christian
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({io.christiangaertner.github.botcafe.BotTest.class, io.christiangaertner.github.botcafe.BotCafeTest.class, io.christiangaertner.github.botcafe.ui.UiSuite.class, io.christiangaertner.github.botcafe.voice.VoiceSuite.class, io.christiangaertner.github.botcafe.BotConversationTest.class})
public class BotcafeSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}