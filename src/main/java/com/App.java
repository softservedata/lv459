package com;

public class App {
	public static void main(String[] args) {
		Box box = new Box();
		//box.setObj(1);
		box.setObj("1");
		//
		int i = (Integer) box.getObj(); // Runtime Error. // Code Smells
		System.out.println("i = " + i);
	}
}
