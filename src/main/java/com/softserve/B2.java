package com.softserve;

public class B2 extends A {

}

/*
class A {
	public void m3() {...}
}

class B extends A {
	private void m3() {...}
	void m4() {... m3(); }  // m3() from B
}


B b = new B();
// Architecture Error
b.m3(); // m3() from A
*/
