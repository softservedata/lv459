package com.softserve.edu.opencart.data;

public final class ApplicationStatus {

	private static volatile ApplicationStatus instance = null;
	//
	// TODO for multiThread
	private boolean isLogged;

	private ApplicationStatus() {
		isLogged = false;
	}

	public static ApplicationStatus get() {
		if (instance == null) {
			synchronized (ApplicationStatus.class) {
				if (instance == null) {
					instance = new ApplicationStatus();
				}
			}
		}
		return instance;
	}

	public boolean isLogged() {
		return isLogged;
	}

	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}

}
