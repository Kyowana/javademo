package com.example.demo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetAnswerReq {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("person_id")
	private String personId;

	public GetAnswerReq() {
		
	}
	



	public String getPersonId() {
		return personId;
	}




	public void setPersonId(String personId) {
		this.personId = personId;
	}




	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	
	

}
