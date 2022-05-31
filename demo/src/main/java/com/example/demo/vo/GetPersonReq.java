package com.example.demo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetPersonReq {
	
	@JsonProperty("id")
	private String id;
	
	public GetPersonReq() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

}
