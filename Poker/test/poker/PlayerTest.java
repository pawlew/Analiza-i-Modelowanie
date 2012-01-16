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
public class PlayerTest {
    
    public PlayerTest() {
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
     * Test of isAllIn method, of class Player.
     */
    @Test
    public void testIsAllIn() {
        System.out.println("isAllIn");
        Player instance = null;
        boolean expResult = false;
        boolean result = instance.isAllIn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAllIn method, of class Player.
     */
    @Test
    public void testSetAllIn() {
        System.out.println("setAllIn");
        boolean allIn = false;
        Player instance = null;
        instance.setAllIn(allIn);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of giveCard method, of class Player.
     */
    @Test
    public void testGiveCard() {
        System.out.println("giveCard");
        Card card = null;
        Player instance = null;
        instance.giveCard(card);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of takeCards method, of class Player.
     */
    @Test
    public void testTakeCards() {
        System.out.println("takeCards");
        Player instance = null;
        instance.takeCards();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actionFold method, of class Player.
     */
    @Test
    public void testActionFold() {
        System.out.println("actionFold");
        Player instance = null;
        instance.actionFold();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resetFoldFlag method, of class Player.
     */
    @Test
    public void testResetFoldFlag() {
        System.out.println("resetFoldFlag");
        Player instance = null;
        instance.resetFoldFlag();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actionCall method, of class Player.
     */
    @Test
    public void testActionCall() {
        System.out.println("actionCall");
        int currentBet = 0;
        Player instance = null;
        int expResult = 0;
        int result = instance.actionCall(currentBet);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addToChips method, of class Player.
     */
    @Test
    public void testAddToChips() {
        System.out.println("addToChips");
        int pot = 0;
        Player instance = null;
        instance.addToChips(pot);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of takeFromChips method, of class Player.
     */
    @Test
    public void testTakeFromChips() {
        System.out.println("takeFromChips");
        int bet = 0;
        Player instance = null;
        instance.takeFromChips(bet);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of bigBlind method, of class Player.
     */
    @Test
    public void testBigBlind() {
        System.out.println("bigBlind");
        Player instance = null;
        int expResult = 0;
        int result = instance.bigBlind();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of smallBlind method, of class Player.
     */
    @Test
    public void testSmallBlind() {
        System.out.println("smallBlind");
        Player instance = null;
        int expResult = 0;
        int result = instance.smallBlind();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlayerNum method, of class Player.
     */
    @Test
    public void testGetPlayerNum() {
        System.out.println("getPlayerNum");
        Player instance = null;
        int expResult = 0;
        int result = instance.getPlayerNum();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPlayerNum method, of class Player.
     */
    @Test
    public void testSetPlayerNum() {
        System.out.println("setPlayerNum");
        int playerNum = 0;
        Player instance = null;
        instance.setPlayerNum(playerNum);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlayerName method, of class Player.
     */
    @Test
    public void testGetPlayerName() {
        System.out.println("getPlayerName");
        Player instance = null;
        String expResult = "";
        String result = instance.getPlayerName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPlayerName method, of class Player.
     */
    @Test
    public void testSetPlayerName() {
        System.out.println("setPlayerName");
        String playerName = "";
        Player instance = null;
        instance.setPlayerName(playerName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isActionReq method, of class Player.
     */
    @Test
    public void testIsActionReq() {
        System.out.println("isActionReq");
        Player instance = null;
        boolean expResult = false;
        boolean result = instance.isActionReq();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setActionReq method, of class Player.
     */
    @Test
    public void testSetActionReq() {
        System.out.println("setActionReq");
        boolean actionReq = false;
        Player instance = null;
        instance.setActionReq(actionReq);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isFolded method, of class Player.
     */
    @Test
    public void testIsFolded() {
        System.out.println("isFolded");
        Player instance = null;
        boolean expResult = false;
        boolean result = instance.isFolded();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFolded method, of class Player.
     */
    @Test
    public void testSetFolded() {
        System.out.println("setFolded");
        boolean folded = false;
        Player instance = null;
        instance.setFolded(folded);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getChips method, of class Player.
     */
    @Test
    public void testGetChips() {
        System.out.println("getChips");
        Player instance = null;
        int expResult = 0;
        int result = instance.getChips();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setChips method, of class Player.
     */
    @Test
    public void testSetChips() {
        System.out.println("setChips");
        int chips = 0;
        Player instance = null;
        instance.setChips(chips);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isHuman method, of class Player.
     */
    @Test
    public void testIsHuman() {
        System.out.println("isHuman");
        Player instance = null;
        boolean expResult = false;
        boolean result = instance.isHuman();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHuman method, of class Player.
     */
    @Test
    public void testSetHuman() {
        System.out.println("setHuman");
        boolean isHuman = false;
        Player instance = null;
        instance.setHuman(isHuman);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isOut method, of class Player.
     */
    @Test
    public void testIsOut() {
        System.out.println("isOut");
        Player instance = null;
        boolean expResult = false;
        boolean result = instance.isOut();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOut method, of class Player.
     */
    @Test
    public void testSetOut() {
        System.out.println("setOut");
        boolean isOut = false;
        Player instance = null;
        instance.setOut(isOut);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHandRank method, of class Player.
     */
    @Test
    public void testGetHandRank() {
        System.out.println("getHandRank");
        Player instance = null;
        int expResult = 0;
        int result = instance.getHandRank();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHandRank method, of class Player.
     */
    @Test
    public void testSetHandRank() {
        System.out.println("setHandRank");
        int handRank = 0;
        Player instance = null;
        instance.setHandRank(handRank);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHighCard method, of class Player.
     */
    @Test
    public void testGetHighCard() {
        System.out.println("getHighCard");
        Player instance = null;
        int expResult = 0;
        int result = instance.getHighCard();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHighCard method, of class Player.
     */
    @Test
    public void testSetHighCard() {
        System.out.println("setHighCard");
        int highCard = 0;
        Player instance = null;
        instance.setHighCard(highCard);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastBetAmt method, of class Player.
     */
    @Test
    public void testGetLastBetAmt() {
        System.out.println("getLastBetAmt");
        Player instance = null;
        int expResult = 0;
        int result = instance.getLastBetAmt();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastBetAmt method, of class Player.
     */
    @Test
    public void testSetLastBetAmt() {
        System.out.println("setLastBetAmt");
        int lastBetAmt = 0;
        Player instance = null;
        instance.setLastBetAmt(lastBetAmt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
