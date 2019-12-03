package com.softserve.academy;

import java.util.InputMismatchException;
import java.util.Scanner;

/** Class for making input and receiving result of calculation from main
 * method.
 */
public class InOut {

    private int inputNumber;

    public int getInputNumber() {
        return inputNumber;
    }

    public void setInputNumber(int inputNumber) {
        this.inputNumber = inputNumber;
    }

    /**
     * Sends number for main method.
     * @return integer.
     */
    public int inputNumber() {

        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Your number: ");

            try {
                inputNumber = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect input");
            }
        } while (inputNumber != -9 && inputNumber <= 0 );

        return inputNumber;
    }

    /**
     * Receives result of calculations and sends to console.
     * @param numberDTO - input DTO.
     */
    public void outputResult(NumberDTO numberDTO) {
        System.out.println(numberDTO.toString());
    }
}
