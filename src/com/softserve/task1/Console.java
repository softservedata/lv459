package com.softserve.task1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <h1>Inout</h1>
 * <p>Class to input data and output result.</p>
 */
class Console {

    /**
     * <h3>This method for read console data.</h3>
     * @return my input number.
     */
    int input() {
        Scanner n = new Scanner(System.in);
        System.out.print("Enter any number > 1: ");
        int number = n.nextInt();
        if (number < 1) throw new InputMismatchException();
        return number;
    }

    /**
     * <h3>This method to output result.</h3>
     * @param number supplies number to output.
     * @return return result.
     */
    public int output(final int number) {
        System.out.println("The k is: " + number);
        return number;

    }
}
