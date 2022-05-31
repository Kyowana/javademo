package com.example.demo.service.ifs;

import java.util.List;
import java.util.UUID;

import com.example.demo.entity.Answer;

public interface AnswerService {
	
	public Answer getAnswerById(UUID id);
	
	public List<Answer> getAnswerByPersonId(UUID questionId);
	
	public List<Answer> getAnswers();

}
