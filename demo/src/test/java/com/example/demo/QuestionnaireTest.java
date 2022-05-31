package com.example.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.entity.New1;
import com.example.demo.entity.Person;
import com.example.demo.repository.New1Dao;
import com.example.demo.repository.PersonDao;
import com.example.demo.service.ifs.QuestionnaireService;
import com.example.demo.service.impl.QuestionnaireServiceImpl;

@WebAppConfiguration // �n�ϥ� web ���Ҽ�������
@SpringBootTest(classes = DemoApplication.class) // �����@SpringBootApplication�D�t�m���O�ӱҰ�Spring Boot���ε{������
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // ���F�i�H�ϥ�@BeforeAll �M @AfterAll
//@TestPropertySource("classpath:application-test.properties")
public class QuestionnaireTest {

	// mockMvc �O��� webApplicationContext �ҫإߪ�����A�i�H�Ψӽs�g web ���Ϊ���X����
	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private PersonDao personDao;

	@Autowired
	New1Dao new1;
	
	@Autowired
	private QuestionnaireService questionnaireService;

	// ��{�� http �ШD�������A�D�n�O�ΨӴ��� controller
	private MockMvc mockMvc;

	@BeforeAll
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

//		@BeforeEach  // ���ѱ� �N���|�]�o��q
	public void beforeEach() {
		// save �brun���e���ƶ�i�h
		Person item = new Person();
		item.setName("C01");
		item.setEmail("c01@gmail.com");
		item.setMobile("0900000000");
		item.setAge("20");
		// Date date = new Date(); // �Y���F�ϩҦ����ɶ��@�P
		item.setCreateTime(new Date()); // java.util // ���X��U�ɶ�
		personDao.save(item);
	}

	@Test
	public void daoTest() {
		// select
		List<Person> list = personDao.findAll();
		System.out.println(list.size()); // sysout alt+/ (as tab*2)
		Assert.notEmpty(list, "list is empty");
	}

	@Test
	public void new1Test() {
		for (int i = 0; i < 2; i++) {
			New1 item1 = new New1();
			// UUID uuid = UUID.randomUUID();
			item1.setName("D01");
			new1.save(item1);
		}
	}
	
	@Test
	public void serviceTest() {
		// 1. select(find)
		Person item = questionnaireService.getPersonById(UUID.fromString("5605cd5f-6669-46dc-9057-7a7d3f7c2d22"));
		Assert.notNull(item, "Person item is null"); // ���~�T��
		// print ������
		System.out.println(item.getName());
		System.out.println(item.getEmail());
	}
	
	@Test
	public void serviceListTest() {
		List<Person> list = questionnaireService.getPersonList();
		Assert.notEmpty(list, "list is empty");
	}
	
	@Test
	public void collectionTest() {
		List<String> list = new ArrayList<>();
		list.add("ABC");
		list.add("ABC");
		System.out.println(list);
		// Set �����\��������(�۰ʧR������)
		Set<String> set = new HashSet<>();
		set.add("SSS");
		set.add("SSS");
		System.out.println(set);
		// Map
		Map<String, Integer> map = new HashMap<>();
		map.put("A", 10);
		map.put("B", 20);
		System.out.println(map);
		for (Map.Entry<String, Integer> item : map.entrySet()) {  // Map.Entry item
			System.out.println("key: " + item.getKey());
			System.out.println("value: " + item.getValue());
		}
	}

}
