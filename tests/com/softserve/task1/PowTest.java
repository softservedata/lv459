package com.softserve.task1;

import com.softserve.task1.log.Pow;
import org.junit.Test;
import sun.font.TrueTypeFont;

import java.io.IOException;
import java.util.InputMismatchException;

import static org.junit.Assert.assertEquals;

public class PowTest {

    private Object IOException;

    /**
     * Test checks input value is natural or not. If it is that
     * should return true.
     *
     * TDT: Equivalence partition.
     */
    @Test
    public void test1nisNatural() {
        boolean actual;

        Pow pow1 = new Pow();
        actual = pow1.isNatural(-1);
        assertEquals(false, actual);
    }

    /**
     * Test checks input value is natural or not. If it is that
     * should return true.
     *
     * TDT: Boundary Values.
     */
    @Test
    public void test2nisNatural() {
        boolean actual;

        Pow pow1 = new Pow();
        actual = pow1.isNatural(0);
        assertEquals(false, actual);
    }

    /**
     * Test checks input value is natural or not. If it is that
     * should return true.
     *
     * TDT: Boundary Values.
     */

    @Test
    public void test3nisNatural() {
        boolean actual;

        Pow pow1 = new Pow();
        actual = pow1.isNatural(1);
        assertEquals(true, actual);
    }

    /**
     * Test checks input value is natural or not. If it is that
     * should return true.
     *
     * TDT: Equivalence partition.
     */

    @Test
    public void test4nisNatural() {
        boolean actual;

        Pow pow1 = new Pow();
        actual = pow1.isNatural(5);
        assertEquals(true, actual);
    }


    /**
     * Test checks method which calculate condition.
     * Boundary Values.
     */

    @Test(expected = java.io.IOException.class)
    public void test1findPow() throws IOException {
        int actual;
        Pow pow1 = new Pow();
        actual = pow1.findPow(-1);

    }

    @Test(expected = java.io.IOException.class)
    public void test2findPow() throws IOException {

        Pow pow1 = new Pow();
        pow1.findPow(0);

    }

    @Test(expected = java.io.IOException.class)
    public void test3findPow() throws IOException {

        Pow pow1 = new Pow();
        pow1.findPow(1);

    }

    @Test
    public void test4findPow() throws IOException {
        int actual;
        int expected = 1;

        Pow pow1 = new Pow();
        actual = pow1.findPow(16);
        assertEquals(expected, actual);

    }

    /**
     * Test checks method which calculate condition.
     * Equivalence partition.
     */
    @Test
    public void test6findPow() throws IOException {
        int actual;
        int expected = 2;

        Pow pow1 = new Pow();
        actual = pow1.findPow(17);
        assertEquals(expected, actual);

    }

}