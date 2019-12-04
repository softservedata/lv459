package com.softserve.task1;

import com.softserve.task1.log.Pow;

import java.io.IOException;
import java.util.InputMismatchException;

/**
 * Main class of application.
 */
public final class Main {

    /**
     * Constructor.
     */
    private Main() {
    }

    /**
     * @param args supplies command-line arguments as an array
     * of String objects.
     */
    public static void main(final String[] args) throws Exception {
        Console mv = new Console();

            int number = mv.input();

            Pow pow1 = new Pow();
            int res = pow1.findPow(number);
            mv.output(res);


    }


}

