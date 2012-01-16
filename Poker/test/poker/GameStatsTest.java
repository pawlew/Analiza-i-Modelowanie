/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.util.Date;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author dyrek
 */
public class GameStatsTest {
    
    public GameStatsTest() {
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
     * Test of createStats method, of class GameStats.
     */
    @Test
    public void testCreateStats() throws Exception {
        System.out.println("createStats");
        GameStats instance = null;
        instance.createStats();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadStats method, of class GameStats.
     */
    @Test
    public void testLoadStats() throws Exception {
        System.out.println("loadStats");
        GameStats instance = null;
        instance.loadStats();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class GameStats.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        GameStats instance = null;
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreated method, of class GameStats.
     */
    @Test
    public void testGetCreated() {
        System.out.println("getCreated");
        GameStats instance = null;
        Date expResult = null;
        Date result = instance.getCreated();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVictory method, of class GameStats.
     */
    @Test
    public void testGetVictory() {
        System.out.println("getVictory");
        GameStats instance = null;
        int expResult = 0;
        int result = instance.getVictory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRounds method, of class GameStats.
     */
    @Test
    public void testGetRounds() {
        System.out.println("getRounds");
        GameStats instance = null;
        int expResult = 0;
        int result = instance.getRounds();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxRounds method, of class GameStats.
     */
    @Test
    public void testGetMaxRounds() throws Exception {
        System.out.println("getMaxRounds");
        int userId = 0;
        int expResult = 0;
        int result = GameStats.getMaxRounds(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxVictory method, of class GameStats.
     */
    @Test
    public void testGetMaxVictory() throws Exception {
        System.out.println("getMaxVictory");
        int userId = 0;
        int expResult = 0;
        int result = GameStats.getMaxVictory(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAvgRounds method, of class GameStats.
     */
    @Test
    public void testGetAvgRounds() throws Exception {
        System.out.println("getAvgRounds");
        int userId = 0;
        double expResult = 0.0;
        double result = GameStats.getAvgRounds(userId);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAvgVictory method, of class GameStats.
     */
    @Test
    public void testGetAvgVictory() throws Exception {
        System.out.println("getAvgVictory");
        int userId = 0;
        double expResult = 0.0;
        double result = GameStats.getAvgVictory(userId);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllRounds method, of class GameStats.
     */
    @Test
    public void testGetAllRounds() throws Exception {
        System.out.println("getAllRounds");
        int userId = 0;
        int expResult = 0;
        int result = GameStats.getAllRounds(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllVictory method, of class GameStats.
     */
    @Test
    public void testGetAllVictory() throws Exception {
        System.out.println("getAllVictory");
        int userId = 0;
        int expResult = 0;
        int result = GameStats.getAllVictory(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllGames method, of class GameStats.
     */
    @Test
    public void testGetAllGames() throws Exception {
        System.out.println("getAllGames");
        int userId = 0;
        GameStats[] expResult = null;
        GameStats[] result = GameStats.getAllGames(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toArray method, of class GameStats.
     */
    @Test
    public void testToArray() {
        System.out.println("toArray");
        GameStats instance = null;
        Object[] expResult = null;
        Object[] result = instance.toArray();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
