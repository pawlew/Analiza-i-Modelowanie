/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package poker;

import java.awt.Window;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dyrek
 */
public class PokerAppTest {

    public PokerAppTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of startup method, of class PokerApp.
     */
    @Test
    public void testStartup() {
        System.out.println("startup");
        PokerApp instance = new PokerApp();
        instance.startup();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of configureWindow method, of class PokerApp.
     */
    @Test
    public void testConfigureWindow() {
        System.out.println("configureWindow");
        Window root = null;
        PokerApp instance = new PokerApp();
        instance.configureWindow(root);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getApplication method, of class PokerApp.
     */
    @Test
    public void testGetApplication() {
        System.out.println("getApplication");
        PokerApp expResult = null;
        PokerApp result = PokerApp.getApplication();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class PokerApp.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        PokerApp.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}