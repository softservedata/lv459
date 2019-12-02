package com.tasks.demo;

/*
 * Make any tests with code.
 */

public class Test {
	
	private static final Exception OutOfRangeException = null;

	public static void main(String[] args) throws Exception {
		
//		int max = 0;
//		int indexOfMax = 0;
//		int[] arr = {3, 2, 15 ,162, 232, 2, 100};
//
//		for (int i = 0; i < arr.length; i++) {
//
//		    if (arr[i] > max) {
//		        max = arr[i];
//		        indexOfMax = i;
//		    }
//		}
//		System.out.println(max);
//		System.out.println(indexOfMax);
		
		int mark = 6;
		
		if (mark < 6) {
			System.out.println("unsatisfactorily");
		} else if (mark <= 8) {
			System.out.println("satisfactorily");
		} else if (mark <= 10) {
			System.out.println("good");
		} else if (mark <= 12) {
			System.out.println("excellent");
		} else {
			throw OutOfRangeException;	
		}
	}
}
