package com.softserve.max;

public class Appl {
	public static void main(String[] args) {
		ConsoleOperation conopr = new ConsoleOperation();
		Maximum max = new Maximum();
		//
		double agr0 = conopr.readDouble();
		double agr1 = conopr.readDouble();
		double maxArg2 = max.getMax(agr0, agr1);
		conopr.writeDouble(maxArg2, "maximum is: ");
		//
		/*
		conopr.writeDouble(
				max.getMax(conopr.readDouble(), conopr.readDouble()),
				"maximum is: ");
		*/
	}
}
