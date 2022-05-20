package com.example.demo.service.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonDao;
import com.example.demo.service.ifs.QuestionnaireService;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {
	
	@Autowired
	private PersonDao personDao;

	// 滑鼠指到class名稱上自動生成Override
	@Override
	public Person getPersonById(UUID id) {
		Optional<Person> personOp = personDao.findById(id);
		if (!personOp.isPresent())
			return new Person();
			//return null;
		
		return personOp.get();
	}

}
