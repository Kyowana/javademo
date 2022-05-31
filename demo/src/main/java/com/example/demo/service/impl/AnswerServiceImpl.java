package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Answer;
import com.example.demo.repository.AnswerDao;
import com.example.demo.service.ifs.AnswerService;

@Service
public class AnswerServiceImpl implements AnswerService{
	
	@Autowired
	private AnswerDao answerDao;

	@Override
	public Answer getAnswerById(UUID id) {
		Optional<Answer> answerOp = answerDao.findById(id);
		if (!answerOp.isPresent())
			return new Answer();
		
		return answerOp.get();
	}

	@Override
	public List<Answer> getAnswerByPersonId(UUID questionId) {
		List<Answer> list = new ArrayList<>();
		list = answerDao.findAllByPersonId(questionId);
		if (list.isEmpty())
			return new ArrayList<>();
//		for (Answer item : list) {
//			item.getAnswer();
//		}
		return list;
	}

	@Override
	public List<Answer> getAnswers() {
		List<Answer> list = new ArrayList<>();
		list = answerDao.findAll();
		if (list.isEmpty())
			return new ArrayList<>();

		return list;
	}
	
	

}
