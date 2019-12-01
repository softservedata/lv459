package com.softserve.edu.training;

import java.util.ArrayList;

/**
 * Class GetFirst was designed to get answers of 2 tasks.
 */
public class GetFirst {
    /**
     * @param myArray is the array, user enters.
     * @return the amount of numbers, satisfying the first task.
     */
    int firstAmount(final ArrayList<Integer> myArray) {
        Output output = new Output();
        double result = 0.0;
        int index = 0;
        for (int i = 1; i < myArray.size() - 1; i++) {
            result = (myArray.get(i - 1) + myArray.get(i + 1)) / 2;
            if (result > myArray.get(i)) {
                index++;
            }
        }
        output.out("First task number: ");
        return index;
    }

    /**
     * @param myArray is the array, user enters.
     * @return the amount of numbers, satisfying the second task.
     */
    int secondAmount(final ArrayList<Integer> myArray) {
        Output output = new Output();
        int index = 0;
        double res1 = 0.0;
        double res2 = 0.0;
        for (int i = 0; i < myArray.size(); i++) {
            res1 = Math.pow(2, i);
            res2 = getFactorial(i);
            if (myArray.get(i) > res1 && myArray.get(i) < res2) {
                index++;
            }
        }
        output.out("Second task number: ");
        return index;
    }

    /**
     * @param number is a variable, user prints to
     *               get the factorial of the number.
     * @return factorial of the number.
     */
    double getFactorial(final int number) {
        double fact = 1;
        for (int i = 2; i <= number; i++) {
            fact = fact * i;
        }
        return fact;
    }

    /**
     * @param number is the user's input
     * @return the array, user prints.
     */
    ArrayList<Integer> fillArray(final int number) {
        Output output = new Output();
        Input scan = new Input();
        ArrayList<Integer> myArray = new ArrayList<>();
        output.out("Enter your elements: ");
        for (int i = 0; i < number; i++) {
            myArray.add(i, scan.input());
        }
        output.out("Your array is: " + myArray);
        return myArray;
    }
}
