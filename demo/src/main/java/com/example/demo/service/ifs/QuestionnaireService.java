package com.example.demo.service.ifs;

import java.util.List;
import java.util.UUID;

import com.example.demo.entity.Person;

public interface QuestionnaireService {
	
	public Person getPersonById(UUID id);
	
	public List<Person> getPersonList();

}
