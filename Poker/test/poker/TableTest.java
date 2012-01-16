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
public class TableTest {
    
    public TableTest() {
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
     * Test of getsActions method, of class Table.
     */
    @Test
    public void testGetsActions() {
        System.out.println("getsActions");
        Table instance = new Table();
        String expResult = "";
        String result = instance.getsActions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setsActions method, of class Table.
     */
    @Test
    public void testSetsActions() {
        System.out.println("setsActions");
        String sActions = "";
        Table instance = new Table();
        instance.setsActions(sActions);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of givePot method, of class Table.
     */
    @Test
    public void testGivePot() {
        System.out.println("givePot");
        Table instance = new Table();
        int expResult = 0;
        int result = instance.givePot();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addToPot method, of class Table.
     */
    @Test
    public void testAddToPot() {
        System.out.println("addToPot");
        int n = 0;
        Table instance = new Table();
        instance.addToPot(n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of decActionsReq method, of class Table.
     */
    @Test
    public void testDecActionsReq() {
        System.out.println("decActionsReq");
        Table instance = new Table();
        instance.decActionsReq();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCommCards method, of class Table.
     */
    @Test
    public void testAddCommCards() {
        System.out.println("addCommCards");
        Card c = null;
        Table instance = new Table();
        instance.addCommCards(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clearCommCards method, of class Table.
     */
    @Test
    public void testClearCommCards() {
        System.out.println("clearCommCards");
        Table instance = new Table();
        instance.clearCommCards();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addBurnCard method, of class Table.
     */
    @Test
    public void testAddBurnCard() {
        System.out.println("addBurnCard");
        Card c = null;
        Table instance = new Table();
        instance.addBurnCard(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clearBurnCards method, of class Table.
     */
    @Test
    public void testClearBurnCards() {
        System.out.println("clearBurnCards");
        Table instance = new Table();
        instance.clearBurnCards();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPot method, of class Table.
     */
    @Test
    public void testGetPot() {
        System.out.println("getPot");
        Table instance = new Table();
        int expResult = 0;
        int result = instance.getPot();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPot method, of class Table.
     */
    @Test
    public void testSetPot() {
        System.out.println("setPot");
        int pot = 0;
        Table instance = new Table();
        instance.setPot(pot);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHotSeat method, of class Table.
     */
    @Test
    public void testGetHotSeat() {
        System.out.println("getHotSeat");
        Table instance = new Table();
        int expResult = 0;
        int result = instance.getHotSeat();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHotSeat method, of class Table.
     */
    @Test
    public void testSetHotSeat() {
        System.out.println("setHotSeat");
        int hotSeat = 0;
        Table instance = new Table();
        instance.setHotSeat(hotSeat);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isGameStatus method, of class Table.
     */
    @Test
    public void testIsGameStatus() {
        System.out.println("isGameStatus");
        Table instance = new Table();
        boolean expResult = false;
        boolean result = instance.isGameStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGameStatus method, of class Table.
     */
    @Test
    public void testSetGameStatus() {
        System.out.println("setGameStatus");
        boolean gameStatus = false;
        Table instance = new Table();
        instance.setGameStatus(gameStatus);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDealer method, of class Table.
     */
    @Test
    public void testGetDealer() {
        System.out.println("getDealer");
        Table instance = new Table();
        int expResult = 0;
        int result = instance.getDealer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nextDealer method, of class Table.
     */
    @Test
    public void testNextDealer() {
        System.out.println("nextDealer");
        Table instance = new Table();
        int expResult = 0;
        int result = instance.nextDealer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSmall method, of class Table.
     */
    @Test
    public void testGetSmall() {
        System.out.println("getSmall");
        Table instance = new Table();
        int expResult = 0;
        int result = instance.getSmall();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBig method, of class Table.
     */
    @Test
    public void testGetBig() {
        System.out.println("getBig");
        Table instance = new Table();
        int expResult = 0;
        int result = instance.getBig();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirstBet method, of class Table.
     */
    @Test
    public void testGetFirstBet() {
        System.out.println("getFirstBet");
        Table instance = new Table();
        int expResult = 0;
        int result = instance.getFirstBet();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDealer method, of class Table.
     */
    @Test
    public void testSetDealer() {
        System.out.println("setDealer");
        int dealer = 0;
        Table instance = new Table();
        instance.setDealer(dealer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlayerActionsReq method, of class Table.
     */
    @Test
    public void testGetPlayerActionsReq() {
        System.out.println("getPlayerActionsReq");
        Table instance = new Table();
        int expResult = 0;
        int result = instance.getPlayerActionsReq();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPlayerActionsReq method, of class Table.
     */
    @Test
    public void testSetPlayerActionsReq() {
        System.out.println("setPlayerActionsReq");
        int playerActionsReq = 0;
        Table instance = new Table();
        instance.setPlayerActionsReq(playerActionsReq);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRound method, of class Table.
     */
    @Test
    public void testGetRound() {
        System.out.println("getRound");
        Table instance = new Table();
        int expResult = 0;
        int result = instance.getRound();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRound method, of class Table.
     */
    @Test
    public void testSetRound() {
        System.out.println("setRound");
        int round = 0;
        Table instance = new Table();
        instance.setRound(round);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentBet method, of class Table.
     */
    @Test
    public void testGetCurrentBet() {
        System.out.println("getCurrentBet");
        Table instance = new Table();
        int expResult = 0;
        int result = instance.getCurrentBet();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentBet method, of class Table.
     */
    @Test
    public void testSetCurrentBet() {
        System.out.println("setCurrentBet");
        int currentBet = 0;
        Table instance = new Table();
        instance.setCurrentBet(currentBet);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrevBet method, of class Table.
     */
    @Test
    public void testGetPrevBet() {
        System.out.println("getPrevBet");
        Table instance = new Table();
        int expResult = 0;
        int result = instance.getPrevBet();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrevBet method, of class Table.
     */
    @Test
    public void testSetPrevBet() {
        System.out.println("setPrevBet");
        int prevBet = 0;
        Table instance = new Table();
        instance.setPrevBet(prevBet);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
