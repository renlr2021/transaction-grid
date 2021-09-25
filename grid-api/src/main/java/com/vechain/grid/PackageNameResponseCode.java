package com.vechain.grid;

public enum PackageNameResponseCode {
	
	ERROR(9999, "example error"),

	;
	private int code;
	private String value;

	private PackageNameResponseCode(int code, String value) {
		this.code = code;
		this.value = value;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public static PackageNameResponseCode getErrorCode(int code) {
		for (PackageNameResponseCode errorCode : values()) {
			if (errorCode.getCode() == code) {
				return errorCode;
			}
		}
		return null;
	}
}
