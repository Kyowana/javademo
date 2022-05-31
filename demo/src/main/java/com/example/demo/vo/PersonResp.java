package com.example.demo.vo;

import com.example.demo.entity.Person;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonResp {

	@JsonProperty("status_code") // §Ç¦C¤Æ
	private String statusCode;

	private String message;

	@JsonProperty("person_data")
	private Person personData;

	public PersonResp() {

	}

	// «Øºc¤l
	public PersonResp(String statusCode, String message, Person personData) {
		this.statusCode = statusCode;
		this.message = message;
		this.personData = personData;

	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Person getPersonData() {
		return personData;
	}

	public void setPersonData(Person personData) {
		this.personData = personData;
	}

}
