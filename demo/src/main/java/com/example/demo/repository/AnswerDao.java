package com.example.demo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Answer;
import com.example.demo.entity.Question;

@Repository  // @=annotation
public interface AnswerDao extends JpaRepository<Answer, UUID> {
	
	public Answer findByPersonId(String personId);
	public Answer findByQuestionId(UUID questionId);

}
