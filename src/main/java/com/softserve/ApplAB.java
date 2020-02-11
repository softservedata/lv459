package com.softserve;

import com.softserve.edu.ClassA;
import com.softserve.edu.ClassB;

public class ApplAB {
    public static void main(String[] args) {
        System.out.println("The Start.");
        //
//        System.out.println("Test ClassA.");
//        ClassA a;
//        a = new ClassA();
//        System.out.println("a.i = " + a.i);
//        a.m1();
//        a.m2();
//        a.m3();
//        a.m4();
//        a.m6();
//        a.m7();
        //a.m8(); // error
        //
        System.out.println("Test ClassB.");
        ClassA b; //= null;
        //System.out.println("b.i = " + b.i); // error not init 
        b = new ClassB();
        System.out.println("b.i = " + b.i); // from A, fields not virtual; Architecture Error; Fields must be private 
        b.m1();
        b.m2();
        b.m3();
        b.m4();
        //b.m5(); // Compile ERROR
        //((ClassB) b).m5(); // Code Smell
//        if (b instanceof ClassB) {
//        	((ClassB) b).m5(); // No Runtime Error
//        }
        //b.m6(); // Running from ClassA
        //ClassB.m6();
        //b.m8(); // Error for other package
        //((ClassB) b).m8();
        //
//        System.out.println("Test_0 ClassB.");
//        ClassB b0;
//        b0 = new ClassB();
//        System.out.println("b0.i = " + b0.i); // from B 
//        b0.m1();
//        b0.m2();
//        b0.m3();
//        b0.m4();
//        b0.m5();
//        b0.m6();
//        b0.m8();
        //
        System.out.println("The End.");
    }
}
