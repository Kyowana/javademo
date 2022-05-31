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
@EnableScheduling  // 這個類別裡有schedule要執行
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
	
	@Override
	public List<Person> getPersonList(){
		ArrayList<Person> arr = new ArrayList<Person>();
		arr.trimToSize();  // 修整此ArrayList實例的是列表的當前大小的容量
		List<Person> list = new ArrayList<>();  // ArrayList<Person>
		// List是介面，無法new一個新物件
//		list.trimToSize // 用list接時無此方法
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
	@Scheduled(fixedRateString = "${schedule.ms}")  // 這邊的@表示頻率
	public void scheduleTest() {
		System.out.println(new Date());
		System.out.println("====================");
	}

}
