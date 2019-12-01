package com.softserve.task3;

import java.util.List;
import java.util.Scanner;

/**
 * <h1>ConsoleOperations</h1>
 * <p>The class makes console operations.</p>
 * Date      15.09.2019
 */
public class ConsoleOperation {
    /**
     * <h3>This method gets number from user</h3>
     * @return number entered by user.
     */
    int getNaturalNumberFromUser() {
       Scanner scanner = new Scanner(System.in);
       System.out.println("Input your number: ");
       int number = scanner.nextInt();
       if (number < 0) {
           throw new IllegalArgumentException("Number must be natural!");
       }
       return number;
   }

    /**
     * <h3>This method prints list of Mersenne .</h3>
     * @param number is number entered by user.
     * @param list is  that is printed.
     * @return list of Mersenne numbers that are smaller than number.
     */
     List<Integer> printMersenneNumbers(int number, List<Integer> list) {
       System.out.println("The Mersenne numbers smaller than " + number + " are: " + list);
        return list;
    }
}

