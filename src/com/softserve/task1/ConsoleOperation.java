package com.softserve.task1;

import java.util.Scanner;

/**
 * The {@code ConsoleOperation} class read data from user.
 * 
 * @see java.util.Scanner;
 * 
 * @version 13.0.1 15 Oct 2019
 */

public class ConsoleOperation {
	
	public static int readNaturalNumber() {
		
		int number;
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter any natural number = ");
		
		
		try {
			String s = scan.nextLine();
			number = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			throw new RuntimeException("Read Error", e);
		} finally {
			scan.close();
		}
		if (number <= 0) {
			throw new IllegalArgumentException("Number must be natural!");
        }
		return number;
	}
}

