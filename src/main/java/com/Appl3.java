package com;

public class Appl3 {
	public static void main(String[] args) {
		BoxGeneric<String> box = new BoxGeneric<>();
		box.setObj("1");
		//
		//int i = (Integer) box.getObj(); // Compile Error.
		//System.out.println("i = " + i);
	}
}
