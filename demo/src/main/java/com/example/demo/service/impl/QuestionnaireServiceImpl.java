package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonDao;
import com.example.demo.service.ifs.QuestionnaireService;

@Service
@EnableScheduling  // �o�����O�̦�schedule�n����
public class QuestionnaireServiceImpl implements QuestionnaireService {
	
	@Autowired
	private PersonDao personDao;

	// �ƹ�����class�W�٤W�۰ʥͦ�Override
	@Override
	public Person getPersonById(UUID id) {
		Optional<Person> personOp = personDao.findById(id);
		if (!personOp.isPresent())
			return new Person();
			//return null;
		
		return personOp.get();
	}
	
	@Override
	public List<Person> getPersonList(){
		ArrayList<Person> arr = new ArrayList<Person>();
		arr.trimToSize();  // �׾㦹ArrayList��Ҫ��O�C����e�j�p���e�q
		List<Person> list = new ArrayList<>();  // ArrayList<Person>
		// List�O�����A�L�knew�@�ӷs����
//		list.trimToSize // ��list���ɵL����k
		list = personDao.findAll();
		if (list.isEmpty())
			return new ArrayList<>();
		
		
		
//		for (int i = 0; i < list.size(); i++) {
//			
//		}
		
		// for each
		for (Person item : list) {
			System.out.println(item.getId());
		}
		
		// Lambda (after Java 8)
		list.forEach(item -> {
			System.out.println(item.getId());
		});
		return list;
	}
	
//	@Scheduled(fixedRate = 3000)  // 3s
	@Scheduled(fixedRateString = "${schedule.ms}")  // �o�䪺@����W�v
	public void scheduleTest() {
		System.out.println(new Date());
		System.out.println("====================");
	}

}
