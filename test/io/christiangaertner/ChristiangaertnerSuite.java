/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package io.christiangaertner;

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
@Suite.SuiteClasses({io.christiangaertner.github.GithubSuite.class})
public class ChristiangaertnerSuite {

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