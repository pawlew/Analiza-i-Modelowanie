/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author dyrek
 */
public class PlayControllerTest {
    
    public PlayControllerTest() {
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
     * Test of getAction method, of class PlayController.
     */
    @Test
    public void testGetAction() {
        System.out.println("getAction");
        Table table = null;
        PlayController instance = null;
        int[] expResult = null;
        int[] result = instance.getAction(table);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setChips method, of class PlayController.
     */
    @Test
    public void testSetChips() {
        System.out.println("setChips");
        int chips = 0;
        PlayController instance = null;
        instance.setChips(chips);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showTurnDialog method, of class PlayController.
     */
    @Test
    public void testShowTurnDialog() {
        System.out.println("showTurnDialog");
        PlayController instance = null;
        int expResult = 0;
        int result = instance.showTurnDialog();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addInfo method, of class PlayController.
     */
    @Test
    public void testAddInfo() {
        System.out.println("addInfo");
        String info = "";
        PlayController instance = null;
        instance.addInfo(info);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTableCard method, of class PlayController.
     */
    @Test
    public void testAddTableCard() {
        System.out.println("addTableCard");
        Card card = null;
        PlayController instance = null;
        instance.addTableCard(card);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clearTableCards method, of class PlayController.
     */
    @Test
    public void testClearTableCards() {
        System.out.println("clearTableCards");
        PlayController instance = null;
        instance.clearTableCards();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addHandCard method, of class PlayController.
     */
    @Test
    public void testAddHandCard() {
        System.out.println("addHandCard");
        Card card = null;
        PlayController instance = null;
        instance.addHandCard(card);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clearHand method, of class PlayController.
     */
    @Test
    public void testClearHand() {
        System.out.println("clearHand");
        PlayController instance = null;
        instance.clearHand();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPot method, of class PlayController.
     */
    @Test
    public void testSetPot() {
        System.out.println("setPot");
        int pot = 0;
        PlayController instance = null;
        instance.setPot(pot);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clearInfo method, of class PlayController.
     */
    @Test
    public void testClearInfo() {
        System.out.println("clearInfo");
        PlayController instance = null;
        instance.clearInfo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateState method, of class PlayController.
     */
    @Test
    public void testUpdateState() {
        System.out.println("updateState");
        Table t = null;
        PlayController instance = null;
        instance.updateState(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
