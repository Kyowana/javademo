package com.example.demo.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "question")
public class Question {
	
	@Id
	@Column(name = "question_id")
	@Type(type = "uuid-char")
	private UUID questionId;
//	private UUID id = UUID.randomUUID();
	
	@Column(name = "questionnaire_id")
	@Type(type = "uuid-char")
	private UUID questionnaireId;
	
	@Column(name = "options")
	private String options;
	
	@Column(name = "type")
	private int type;
	
	@Column(name = "isrequired")
	private boolean isRequired;





	public UUID getQuestionId() {
		return questionId;
	}

	public void setQuestionId(UUID questionId) {
		this.questionId = questionId;
	}

	public UUID getQuestionnaireId() {
		return questionnaireId;
	}

	public void setQuestionnaireId(UUID questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public boolean isRequired() {
		return isRequired;
	}

	public void setRequired(boolean isRequired) {
		this.isRequired = isRequired;
	}
	
	

}
