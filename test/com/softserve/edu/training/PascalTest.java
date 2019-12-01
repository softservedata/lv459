package com.softserve.edu.training;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * This class was implemented to create test for Pascal class.
 */
public class PascalTest {

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
     * test for generatePascal method.
     */
    @Test
    public void testGeneratePascal0() {
        Pascal obj = new Pascal();
        List<List<Integer>> actual = obj.generatePascal(2);
        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();
        one.add(1);
        expected.add(one);
        two.add(1);
        two.add(1);
        expected.add(two);
        Assert.assertThat("Comparison error", actual,
                CoreMatchers.is(equalTo(expected)));
    }
}
