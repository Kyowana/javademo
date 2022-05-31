package com.example.demo.enums;

public enum RtnCode {
	
	SUCCESSFUL("200", "嗨成功囉"),
	PARAMETER_REQUIRE("400", "缺少必填參數");

	RtnCode(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	private String code;
	
	private String message;

	public String getCode() {
		return code;
	}

//	public void setCode(String code) {
//		this.code = code;
//	}

	public String getMessage() {
		return message;
	}

//	public void setMessage(String message) {
//		this.message = message;
//	}
	
	

}
