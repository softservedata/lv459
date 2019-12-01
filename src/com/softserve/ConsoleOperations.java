package com.softserve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * The {@code ConsoleOperations} class read/print data from/into console and
 * parse numbers.
 *
 * @see java.io.BufferedReader;
 * @see java.io.IOException;
 * @version 1.0 14.11.2019
 */
public class ConsoleOperations {

    /**
     * Reader to read data from console.
     */
    private static BufferedReader br;

    static {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Read number from console using BufferedReader.
     * @return the {@code long} number from console.
     * @throws NumberFormatException if there is no number in console.
     * @throws IOException           if can’t read data from console.
     */
    public Integer readInt() {
        Integer result = 0;
        System.out.print("Enter number  ");
        try {
            result = Integer.parseInt(br.readLine());
        } catch (NumberFormatException | IOException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    /**
     * Print data into console.
     * @param arg0 int data to print
     */
    public void consolePrint(final int arg0) {
        System.out.println(arg0);
    }

    /**
     * Print data into console.
     * @param arg0 List of Integer’s to print
     */
    public void consolePrint(final List<Integer> arg0) {
        System.out.println(arg0.toString());
    }

    /**
     * Close BufferedReader.
     */
    static void close() {
        try {
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
