package com.softserve.train2;

import com.softserve.train.Parent;

public class Child extends Parent {
	
	public int f() {
		return 2;
	}
	
	public int useF2() {
		return useF();
	}
}
