/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package poker;

import java.sql.Connection;
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
public class DatabaseTest {

    public DatabaseTest() {
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

    /**
     * Test of connect method, of class Database.
     */
    @Test
    public void testConnect() throws Exception {
        System.out.println("connect");
        try {
             Database.connect();
        } catch (Exception e) {
            fail("The test fails");
        }
    }

    /**
     * Test of getConnection method, of class Database.
     */
    @Test
    public void testGetConnection() {
        System.out.println("getConnection");
        Connection result = Database.getConnection();
        assertNotNull(result);
    }

}