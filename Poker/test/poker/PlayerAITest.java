/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author dyrek
 */
public class PlayerAITest {
    
    public PlayerAITest() {
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
     * Test of PlayerAI1 method, of class PlayerAI.
     */
    @Test
    public void testPlayerAI1() {
        System.out.println("PlayerAI1");
        int playerPos = 0;
        Analyzer myAnalyzer = null;
        Table myTable = null;
        int[] expResult = null;
        int[] result = PlayerAI.PlayerAI1(playerPos, myAnalyzer, myTable);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of preFlop method, of class PlayerAI.
     */
    @Test
    public void testPreFlop() {
        System.out.println("preFlop");
        int pos = 0;
        ArrayList<Card> hand = null;
        int currBet = 0;
        int[] expResult = null;
        int[] result = PlayerAI.preFlop(pos, hand, currBet);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of postFlop method, of class PlayerAI.
     */
    @Test
    public void testPostFlop() {
        System.out.println("postFlop");
        int currentHandRank = 0;
        int currBet = 0;
        int[] expResult = null;
        int[] result = PlayerAI.postFlop(currentHandRank, currBet);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
