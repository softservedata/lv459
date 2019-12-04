package com.softserve.task2;

import org.junit.Test;
import sun.plugin.javascript.navig.Array;

import java.lang.IllegalArgumentException;
import java.util.*;

import static org.junit.Assert.*;

public class QuadraticTest {

    /**
     * Test checks input value is natural or not. If it is that
     * should return true.
     */
    @Test
    public void test1nisNatural() {
        boolean actual;

        Quadratic quad = new Quadratic();
        actual = quad.isNatural(-1);
        assertEquals(false, actual);
    }

    @Test
    public void test2nisNatural() {
        boolean actual;

        Quadratic quad = new Quadratic();
        actual = quad.isNatural(0);
        assertEquals(false, actual);
    }

    /**
     * Test checks input value is natural or not. If it is that
     * should return true.
     */

    @Test
    public void test3nisNatural() {
        boolean actual;

        Quadratic quad = new Quadratic();
        actual = quad.isNatural(1);
        assertEquals(true, actual);
    }

    /**
     * Test checks if two numbers are equal or not.
     * If we put first number 1 and second the same
     * we should receive true.
     */
    @Test
    public void test1isEquals() {
        boolean actual;

        Quadratic quad = new Quadratic();
        actual = quad.isEquals(1, 1);
        assertEquals(true, actual);

    }

    /**
     * Test checks if two numbers are equal or not.
     * If we put first number 1 and second 0 for example,
     * we should receive false.
     */

    @Test
    public void test2isEquals() {
        boolean actual;

        Quadratic quad = new Quadratic();
        actual = quad.isEquals(1, 0);
        assertEquals(false, actual);

    }

    @Test(expected = IllegalArgumentException.class)
    public void test5findQuadratic() throws IllegalArgumentException {
        Quadratic qd = new Quadratic();
        qd.findQuadratic(-1);
    }

    @Test
    public void test1findQuadratic() throws IllegalArgumentException {
        List<DataDTO> actual;
        List<DataDTO> expected = new ArrayList<>();
        new Quadratic().findQuadratic(1);
    }

    /**
     * Boundary Values.
     */

    @Test
    public void test2findQuadratic() throws IllegalArgumentException {
        List<DataDTO> actual;
        List<DataDTO> expected = new ArrayList<>();
        actual = new Quadratic().findQuadratic(2);
        expected.add(new DataDTO(1, 1));
        assertEquals(expected, actual);
    }

    @Test
    public void test3findQuadratic() throws IllegalArgumentException {
        List<DataDTO> actual;
        List<DataDTO> expected = new ArrayList<>();
        actual = new Quadratic().findQuadratic(5);
        expected.add(new DataDTO(1, 2));
        expected.add(new DataDTO(2, 1));

        assertEquals(expected, actual);
    }
    /**
     * Equivalence partition.
     */
    @Test
    public void test4findQuadratic() throws IllegalArgumentException {
        List<DataDTO> actual;
        List<DataDTO> expected = new ArrayList<>();
        actual = new Quadratic().findQuadratic(50);
        expected.add(new DataDTO(1, 7));
        expected.add(new DataDTO(7, 1));
        expected.add(new DataDTO(5, 5));
        assertEquals(expected, actual);
    }

}