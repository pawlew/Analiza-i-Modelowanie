/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dyrek
 */
public class LoginDialogTest {

    public LoginDialogTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testLoginDialog() {
        PokerApp appInstance = new PokerApp();
        java.awt.Frame a = new java.awt.Frame();
        try {
            LoginDialog instance = new LoginDialog(a, false);
        } catch (Exception e) {
            fail("The test fails");
        }
        try {
            LoginDialog instance = new LoginDialog(a, true);
        } catch (Exception e) {
            fail("The test fails");
        }



    }
}
