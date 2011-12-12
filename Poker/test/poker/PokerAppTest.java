/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.awt.Window;
import junit.framework.TestCase;

/**
 *
 * @author dyrek
 */
public class PokerAppTest extends TestCase {

    public PokerAppTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {

        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of startup method, of class PokerApp.
     */
    public void testStartup() {
        System.out.println("startup");
        PokerApp instance = new PokerApp();
        try {
            instance.startup();
        } catch (Exception e) {
            fail("The test fails");
        }

    }

    /**
     * Test of configureWindow method, of class PokerApp.
     */
    public void testConfigureWindow() {
        System.out.println("configureWindow");
        Window root = null;
        PokerApp instance = new PokerApp();

        try {
            instance.configureWindow(root);
        } catch (Exception e) {
            fail("The test fails");
        }

    }

    /**
     * Test of getApplication method, of class PokerApp.
     */
    public void testGetApplication() {
        System.out.println("getApplication");
        PokerApp result = PokerApp.getApplication();
        assertNotNull(result);

    }

    /**
     * Test of main method, of class PokerApp.
     */
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        try {
            PokerApp.main(args);
        } catch (Exception e) {
            fail("The test fails");
        }
    }
}
