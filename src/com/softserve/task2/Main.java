package com.softserve.task2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

/**
 * Main class of application.
 */
public final class Main {

    /**
     * @param args supplies command-line arguments as an array
     * of String objects.
     */
    public static void main(final String[] args) throws IOException {

        Console in = new Console();
            int number = in.input();

            Quadratic qd = new Quadratic();
            List<DataDTO> res = qd.findQuadratic(number);
            in.outValues(res);

    }
}
