package com.tasks.demo;

import java.util.Scanner;

/**
 * This class contains Scanner for Input/Output.
 * 
 * @see java.util.Scanner;
 * 
 * @version 13.0.1 15 Oct 2019
 */

public class ConsoleOperation {
	
	public static int readNumber() {
		
		int number;
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter any number = ");
		
		try {
			String s = scan.nextLine();
			number = Integer.parseInt(s);
			//result = Double.parseDouble(br.readLine());
		} catch (NumberFormatException e) {
			// e.printStackTrace();
			throw new RuntimeException("Read Error", e);
		} finally {
			scan.close();
		}
		return number;
	}
}

