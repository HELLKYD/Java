package com.elbarto.lexical;

public class LSToken {
	private String type;
	private Object value;

	public LSToken(String type, Object value) {
		this.type = type;
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public String printType() {
		return "type: " + this.type + " value: " + this.value.toString();
	}

}
