package com.example.demo.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, UUID> {
	
	public Optional<Question> findByQuestionId(UUID questionId);

}
