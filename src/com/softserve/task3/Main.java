
package com.softserve.task3;

import java.util.ArrayList;
import java.util.List;

/**
 * Main class of application.
 */
public class Main {
    /**
     * @param args supplies command-line arguments as an array
     * of String objects.
     */
    public static void main(final String[] args) {
        Console in = new Console();
        int number = in.input();

        QuadraticIf qd = new QuadraticIf();
        List<DataDTO> res = qd.findQuadratic(number);
        in.outValues(res);
    }
}