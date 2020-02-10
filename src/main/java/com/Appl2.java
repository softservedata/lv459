package com;

public class Appl2 {
	public static void main(String[] args) {
		BoxWrapper box = new BoxWrapper();
		box.setObj("1");
		//
		//int i = (Integer) box.getObj(); // Compile Error.
		//System.out.println("i = " + i);
	}
}
