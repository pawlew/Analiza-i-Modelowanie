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
public class CryptoTest {

    public CryptoTest() {
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
     * Test of encrypt method, of class Crypto.
     */
    @Test
    public void testEncrypt() throws Exception {
        System.out.println("encrypt");
        String seed = "";
        String cleartext = "";
        String expResult = "";
        String result = Crypto.encrypt(seed, cleartext);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of decrypt method, of class Crypto.
     */
    @Test
    public void testDecrypt() throws Exception {
        System.out.println("decrypt");
        String seed = "";
        String encrypted = "";
        String expResult = "";
        String result = Crypto.decrypt(seed, encrypted);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toHex method, of class Crypto.
     */
    @Test
    public void testToHex_String() {
        System.out.println("toHex");
        String txt = "";
        String expResult = "";
        String result = Crypto.toHex(txt);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fromHex method, of class Crypto.
     */
    @Test
    public void testFromHex() {
        System.out.println("fromHex");
        String hex = "";
        String expResult = "";
        String result = Crypto.fromHex(hex);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toByte method, of class Crypto.
     */
    @Test
    public void testToByte() {
        System.out.println("toByte");
        String hexString = "";
        byte[] expResult = null;
        byte[] result = Crypto.toByte(hexString);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toHex method, of class Crypto.
     */
    @Test
    public void testToHex_byteArr() {
        System.out.println("toHex");
        byte[] buf = null;
        String expResult = "";
        String result = Crypto.toHex(buf);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}