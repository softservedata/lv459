package com.softserve.edu.training;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * This class was implemented to create tests of GetFirst class' methods.
 */
public class GetFirstTest {
    /**
     * Delta.
     */
    private final double delta = 0.00000001;

    /**
     * @throws Exception (mine).
     */
    @Before
    public void setUp() throws Exception {
        System.out.println("@BeforeClass done");
    }

    /**
     * @throws Exception (mine).
     */
    @After
    public void tearDown() throws Exception {
        System.out.println("@AfterClass done");
    }

    /**
     * This method tests firstAmount method.
     */
    @Test
    public void testFirstAmount0() {
        System.out.println("@testFirstAmount0 start");
        GetFirst obj = new GetFirst();
        double actual;
        double expected;
        List<Integer> integers = new ArrayList<>();
        integers.add(58);
        integers.add(96);
        integers.add(54);
        integers.add(125);
        integers.add(54);
        actual = obj.firstAmount(integers);
        expected = 1;
        Assert.assertEquals("Comparison error", expected, actual, delta);
    }

    /**
     * This method tests firstAmount method.
     */
    @Test
    public void testFirstAmount1() {
        System.out.println("@testFirstAmount1 start");
        GetFirst obj = new GetFirst();
        double actual;
        double expected;
        List<Integer> integers = new ArrayList<>();
        integers.add(85);
        integers.add(96);
        integers.add(25);
        integers.add(48);
        integers.add(52);
        actual = obj.firstAmount(integers);
        expected = 1;
        Assert.assertEquals("Comparison error", expected, actual, delta);
    }

    /**
     * This method tests secondAmount method.
     */
    @Test
    public void testSecondAmount0() {
        System.out.println("@testSecondAmount0 start");
        GetFirst obj = new GetFirst();
        double actual;
        double expected;
        List<Integer> integers = new ArrayList<>();
        integers.add(58);
        integers.add(74);
        integers.add(65);
        integers.add(26);
        integers.add(54);
        actual = obj.secondAmount(integers);
        expected = 0;
        Assert.assertEquals("Comparison error", expected, actual, delta);
    }

    /**
     * This method tests secondAmount method.
     */
    @Test
    public void testSecondAmount1() {
        System.out.println("@testSecondAmount1 start");
        GetFirst obj = new GetFirst();
        double actual;
        double expected;
        List<Integer> integers = new ArrayList<>();
        integers.add(96);
        integers.add(45);
        integers.add(12);
        integers.add(32);
        integers.add(21);
        actual = obj.secondAmount(integers);
        expected = 1;
        Assert.assertEquals("Comparison error", expected, actual, delta);
    }

    /**
     * This method tests firstAmount method.
     * Test Design Techniques: dynamic techniques
     * (error guessing, exploratory testing).
     * Equivalence Partitioning(BVA):
     * {Integer.MIN_VALUE - 1}
     * {Integer.MIN_VALUE; 0} {1} {2; Iteger.MAX_VALUE}
     * {Integer.MAX_VALUE + 1}
     * Boundary Values: Integer.MIN_VALUE,(Integer.MIN_VALUE - 1),0, 1, 2,
     * Iteger.MAX_VALUE, (Iteger.MAX_VALUE + 1).
     * ===========================================================.
     * This method tests firstAmount method.
     * Test Design Techniques: dynamic techniques
     * (error guessing, exploratory testing).
     * Equivalence Partitioning(BVA):
     * {Integer.MIN_VALUE; -1}.
     * Boundary Values:-1.
     *
     * @throws RuntimeException (Wrong input number).
     */
    @Test(expected = RuntimeException.class)
    public void testGetFactorial0() throws RuntimeException {
        System.out.println("@testGetFactorial0 start");
        GetFirst obj = new GetFirst();
        obj.getFactorial(-1);
    }

    /**
     * This method tests firstAmount method.
     * Test Design Techniques: dynamic techniques
     * (error guessing, exploratory testing).
     * Equivalence Partitioning(BVA):
     * {1}.
     * Boundary Values:1.
     */
    @Test
    public void testGetFactorial1() {
        System.out.println("@testGetFactorial1 start");
        GetFirst obj = new GetFirst();
        double actual;
        double expected;
        actual = obj.getFactorial(1);
        expected = 1;
        Assert.assertEquals("Comparison error", expected, actual, delta);
    }

    /**
     * This method tests firstAmount method.
     * Test Design Techniques: dynamic techniques
     * (error guessing, exploratory testing).
     * Equivalence Partitioning(BVA):
     * {2}.
     * Boundary Values:2.
     */
    @Test
    public void testGetFactorial2() {
        System.out.println("@testGetFactorial2 start");
        GetFirst obj = new GetFirst();
        double actual;
        double expected;
        actual = obj.getFactorial(2);
        expected = 2;
        Assert.assertEquals("Comparison error", expected, actual, delta);
    }
}
