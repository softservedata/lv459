package com;

public class BoxWrapper {
	
	private Box box;

	public BoxWrapper() {
		box = new Box();
		box.setObj(new String());
	}
	
	public String getObj() {
		return (String) box.getObj(); // Code Ok.
	}

	public void setObj(String obj) {
		box.setObj(obj);
	}

}
