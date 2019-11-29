package com.softserve.max;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleOperation {

	public double readDouble() {
		double result = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter double = ");
		try {
			String s = br.readLine();
			result = Double.parseDouble(s);
			//result = Double.parseDouble(br.readLine());
		} catch (NumberFormatException | IOException e) {
			// e.printStackTrace();
			throw new RuntimeException("Read Error", e);
		} finally {
			/*
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
		}
		return result;
	}

	public void writeDouble(double arg0, String message) {
		System.out.println(message + arg0);
	}

}
