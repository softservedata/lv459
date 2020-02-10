package com;

public class BoxWrapper {
	
	private Box box;

	public BoxWrapper() {
		box = new Box();
		box.setObj("");
	}
	
	public String getObj() {
		return (String) box.getObj();
	}

	public void setObj(String obj) {
		box.setObj(obj);
	}

}
