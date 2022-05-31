package com.example.demo.vo;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.Answer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AnswerResp {
	
	@JsonProperty("status_code") // て
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String statusCode;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String message;

	@JsonProperty("answer_data")
	@JsonInclude(JsonInclude.Include.NON_NULL)  // 璝ンnull玥ぃ陪ボ
	private Answer answerData;
	
	@JsonProperty("answer_data_list")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<Answer> answerDataList = new ArrayList<>();
	
	// ⊿盿把计篶よ猭 (ぃ糶璝穦ㄏノΤ盿把计篶よ猭碞惠璶よ猭)
	public AnswerResp() {
		
	}
	
	// Τ盿把计篶よ猭
	public AnswerResp(String statusCode, String message, Answer answerData) {
		this.statusCode = statusCode;
		this.message = message;
		this.answerData = answerData;

	}
	
	public AnswerResp(String statusCode, String message, List<Answer> answerDataList) {
		this.statusCode = statusCode;
		this.message = message;
		this.answerDataList = answerDataList;
//		answerDataList = new ArrayList<>();
//		for (Answer item : answerDataList) {
//			this.answerDataList.add(item);
//		}

	}
	
	public AnswerResp(List<Answer> answerDataList) {
		this.answerDataList = answerDataList;
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

	public Answer getAnswerData() {
		return answerData;
	}

	public void setAnswerData(Answer answerData) {
		this.answerData = answerData;
	}

	public List<Answer> getAnswerDataList() {
		return answerDataList;
	}

	public void setAnswerDataList(List<Answer> answerDataList) {
		this.answerDataList = answerDataList;
	}
	
	

}
