package com.example.demo.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.annotation.ConditionalOnB;
import com.example.demo.entity.Person;
import com.example.demo.service.ifs.QuestionnaireService;

@Service
@ConditionalOnB
@EnableScheduling
public class QuestionnaireServiceImpl2 implements QuestionnaireService {
	
	@Scheduled(fixedRateString = "${schedule.ms}")  // 這邊的@表示頻率
	public void scheduleTest() {
		System.out.println("ConditionalOnB");
		System.out.println(new Date());
		System.out.println("====================");
	}

	@Override
	public Person getPersonById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> getPersonList() {
		// TODO Auto-generated method stub
		return null;
	}

}
