package com.example.demo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetWidgetReq {
	@JsonProperty("id")
	private String id;
	
	public GetWidgetReq() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

}
