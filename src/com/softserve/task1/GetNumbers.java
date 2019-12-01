package com.softserve.task1;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * <h1>GetNumbers</h1>
 * <p>The class is used to get numbers from user.</p>
 * Date      15.09.2019.
 *
 */
public class GetNumbers {
    /**
     * <h3>This method gets number from user.</h3>
     * @return list of numbers.
     */
    public List<Integer> getNumbersFromUser() {
     Scanner scanner = new Scanner(System.in);
     List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            System.out.println("Input number: ");
            int n = scanner.nextInt();
         if (n > 0) {
                 arrayList.add(n);
         } else {
             throw new IllegalArgumentException("Number must be natural!");
           }
        }
          return arrayList;
    }
}
