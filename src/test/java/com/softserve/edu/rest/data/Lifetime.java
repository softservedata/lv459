package com.softserve.edu.rest.data;

public class Lifetime {
	
	private long time;
	
	public Lifetime(long time) {
		this.time = time;
	}

	public Lifetime(String text) {
		time = Long.parseLong(text); 
	}

	public long getTime() {
		return time;
	}

	public String getTimeAsText() {
		return String.valueOf(time);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if ((obj == null)
			|| (getClass() != obj.getClass())) {
			return false;
		}
		Lifetime other = (Lifetime) obj;
		if (time != other.time) {
			return false;
		}
		return true;
	}
	
	
}
