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
public class AnalyzerTest {

    public AnalyzerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Analyzer");
                try {
            Analyzer instance = new Analyzer();
        } catch (Exception e) {
            fail("Instance couldnt be initialized");
        }
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
     * Test of Analyze method, of class Analyzer.
     */
    @Test
    public void testAnalyze() {
        System.out.println("Analyze");
    }

    /**
     * Test of getHoldRank method, of class Analyzer.
     */
    @Test
    public void testGetHoldRank() {
        System.out.println("getHoldRank");
 
    }

    /**
     * Test of getHoldHighCard method, of class Analyzer.
     */
    @Test
    public void testGetHoldHighCard() {
        System.out.println("getHoldHighCard");
//        int position = 0;
//        Analyzer instance = new Analyzer();
//        int expResult = 0;
//        int result = instance.getHoldHighCard(position);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getFlopRank method, of class Analyzer.
     */
    @Test
    public void testGetFlopRank() {
        System.out.println("getFlopRank");
//        int position = 0;
//        Analyzer instance = new Analyzer();
//        int expResult = 0;
//        int result = instance.getFlopRank(position);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getflopPair method, of class Analyzer.
     */
    @Test
    public void testGetflopPair() {
        System.out.println("getflopPair");
//        int position = 0;
//        Analyzer instance = new Analyzer();
//        int expResult = 0;
//        int result = instance.getflopPair(position);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getflopTrips method, of class Analyzer.
     */
    @Test
    public void testGetflopTrips() {
        System.out.println("getflopTrips");
//        int position = 0;
//        Analyzer instance = new Analyzer();
//        int expResult = 0;
//        int result = instance.getflopTrips(position);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getflopFours method, of class Analyzer.
     */
    @Test
    public void testGetflopFours() {
        System.out.println("getflopFours");
//        int position = 0;
//        Analyzer instance = new Analyzer();
//        int expResult = 0;
//        int result = instance.getflopFours(position);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getflopFlushSuit method, of class Analyzer.
     */
    @Test
    public void testGetflopFlushSuit() {
        System.out.println("getflopFlushSuit");
//        int position = 0;
//        Analyzer instance = new Analyzer();
//        int expResult = 0;
//        int result = instance.getflopFlushSuit(position);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getflopSG method, of class Analyzer.
     */
    @Test
    public void testGetflopSG() {
        System.out.println("getflopSG");
//        int position = 0;
//        Analyzer instance = new Analyzer();
//        int expResult = 0;
//        int result = instance.getflopSG(position);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getflopHighCard method, of class Analyzer.
     */
    @Test
    public void testGetflopHighCard() {
        System.out.println("getflopHighCard");
//        int position = 0;
//        Analyzer instance = new Analyzer();
//        int expResult = 0;
//        int result = instance.getflopHighCard(position);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getTurnRank method, of class Analyzer.
     */
    @Test
    public void testGetTurnRank() {
        System.out.println("getTurnRank");
//        int position = 0;
//        Analyzer instance = new Analyzer();
//        int expResult = 0;
//        int result = instance.getTurnRank(position);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getturnPair method, of class Analyzer.
     */
    @Test
    public void testGetturnPair() {
        System.out.println("getturnPair");
//        int position = 0;
//        Analyzer instance = new Analyzer();
//        int expResult = 0;
//        int result = instance.getturnPair(position);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getturnTrips method, of class Analyzer.
     */
    @Test
    public void testGetturnTrips() {
        System.out.println("getturnTrips");
//        int position = 0;
//        Analyzer instance = new Analyzer();
//        int expResult = 0;
//        int result = instance.getturnTrips(position);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getturnFours method, of class Analyzer.
     */
    @Test
    public void testGetturnFours() {
        System.out.println("getturnFours");
//        int position = 0;
//        Analyzer instance = new Analyzer();
//        int expResult = 0;
//        int result = instance.getturnFours(position);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getturnFlushSuit method, of class Analyzer.
     */
    @Test
    public void testGetturnFlushSuit() {
        System.out.println("getturnFlushSuit");
//        int position = 0;
//        Analyzer instance = new Analyzer();
//        int expResult = 0;
//        int result = instance.getturnFlushSuit(position);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getturnSG method, of class Analyzer.
     */
    @Test
    public void testGetturnSG() {
        System.out.println("getturnSG");
//        int position = 0;
//        Analyzer instance = new Analyzer();
//        int expResult = 0;
//        int result = instance.getturnSG(position);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getturnHighCard method, of class Analyzer.
     */
    @Test
    public void testGetturnHighCard() {
        System.out.println("getturnHighCard");
//        int position = 0;
//        Analyzer instance = new Analyzer();
//        int expResult = 0;
//        int result = instance.getturnHighCard(position);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getRiverRank method, of class Analyzer.
     */
    @Test
    public void testGetRiverRank() {
        System.out.println("getRiverRank");
//        int position = 0;
//        Analyzer instance = new Analyzer();
//        int expResult = 0;
//        int result = instance.getRiverRank(position);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getriverPair method, of class Analyzer.
     */
    @Test
    public void testGetriverPair() {
        System.out.println("getriverPair");
//        int position = 0;
//        Analyzer instance = new Analyzer();
//        int expResult = 0;
//        int result = instance.getriverPair(position);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getriverTrips method, of class Analyzer.
     */
    @Test
    public void testGetriverTrips() {
        System.out.println("getriverTrips");
//        int position = 0;
//        Analyzer instance = new Analyzer();
//        int expResult = 0;
//        int result = instance.getriverTrips(position);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getriverFours method, of class Analyzer.
     */
    @Test
    public void testGetriverFours() {
        System.out.println("getriverFours");
//        int position = 0;
//        Analyzer instance = new Analyzer();
//        int expResult = 0;
//        int result = instance.getriverFours(position);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getriverFlushSuit method, of class Analyzer.
     */
    @Test
    public void testGetriverFlushSuit() {
        System.out.println("getriverFlushSuit");
//        int position = 0;
//        Analyzer instance = new Analyzer();
//        int expResult = 0;
//        int result = instance.getriverFlushSuit(position);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getriverSG method, of class Analyzer.
     */
    @Test
    public void testGetriverSG() {
        System.out.println("getriverSG");
//        int position = 0;
//        Analyzer instance = new Analyzer();
//        int expResult = 0;
//        int result = instance.getriverSG(position);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getriverHighCard method, of class Analyzer.
     */
    @Test
    public void testGetriverHighCard() {
        System.out.println("getriverHighCard");
//        int position = 0;
//        Analyzer instance = new Analyzer();
//        int expResult = 0;
//        int result = instance.getriverHighCard(position);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getriverFullHouseCards method, of class Analyzer.
     */
    @Test
    public void testGetriverFullHouseCards() {
        System.out.println("getriverFullHouseCards");
//        int Position = 0;
//        Analyzer instance = new Analyzer();
//        String expResult = "";
//        String result = instance.getriverFullHouseCards(Position);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
}
