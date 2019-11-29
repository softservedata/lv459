package com.softserve.edu;

import com.softserve.training.Calc;

public class AppCalc {
	
	public static void main(String[] args) {
		Calc calc = new Calc();
		System.out.println("5 + 5 = " + calc.add(5, 5));
		System.out.println("50 / 5 = " + calc.div(50, 5));
	}
}
