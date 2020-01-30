package com.softserve.edu.rest.data;

public final class LifetimeRepository {

	private LifetimeRepository () {
	}

	public static Lifetime getDefault() {
		return getTypical();
	}

	public static Lifetime getTypical() {
		return new Lifetime("300000");
	}

	public static Lifetime getExtend() {
		return new Lifetime("900000");
	}

}
