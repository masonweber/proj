/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mason
 */
public class TesterTest {

    public TesterTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAdd() {
        Tester tester = new Tester();

        int a = 1;
        int b = 2;
        assertTrue(tester.add(a, b) == 3);
        assertFalse(tester.add(b, a) == 1);
    }

    @Test
    public void testSub() {
        Tester tester = new Tester();

        int a = 1;
        int b = 2;
        assertTrue(tester.sub(a, b) == -1);
        assertFalse(tester.sub(b, a) == -1);
    }

    @Test
    public void testMult() {
        Tester tester = new Tester();

        int a = 1;
        int b = 2;
        assertTrue(tester.mult(a, b) == 2);
        assertFalse(tester.mult(b, a) == -2);
    }

    @Test
    public void testDiv() {
        Tester tester = new Tester();

        int a = 1;
        int b = 2;
        assertTrue(tester.div(a, b) == 0);
        assertFalse(tester.div(b, a) == 0);
    }

    @Test
    public void testMod() {
        Tester tester = new Tester();

        int a = 1;
        int b = 2;
        assertTrue(tester.mod(a, b) == 1);
        assertFalse(tester.mod(b, a) == 1);
    }
}
