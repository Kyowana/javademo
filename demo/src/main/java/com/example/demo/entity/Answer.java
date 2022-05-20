package com.example.demo.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "answer")
public class Answer {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@Type(type = "uuid-char")
	//private int id;
	private UUID id = UUID.randomUUID();
	
	@Column(name = "person_id")
	private String personId;
	
	@Column(name = "question_id")
	@Type(type = "uuid-char")
	private UUID questionId;
//	private String questionId;
	
	@Column(name = "answer")
	private String answer;

	
	public void setQuestionId(UUID questionId) {
		this.questionId = questionId;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

//	public String getQuestionId() {
//		return questionId;
//	}
//
//	public void setQuestionId(String questionId) {
//		this.questionId = questionId;
//	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public UUID getQuestionId() {
		return questionId;
	}
	
	

}
