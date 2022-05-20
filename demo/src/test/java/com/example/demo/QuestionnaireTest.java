package com.example.demo;

import java.util.Date;
import java.util.List;
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

@WebAppConfiguration // 要使用 web 環境模擬測試
@SpringBootTest(classes = DemoApplication.class) // 為找到@SpringBootApplication主配置類別來啟動Spring Boot應用程式環境
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // 為了可以使用@BeforeAll 和 @AfterAll
//@TestPropertySource("classpath:application-test.properties")
public class QuestionnaireTest {

	// mockMvc 是基於 webApplicationContext 所建立的物件，可以用來編寫 web 應用的整合測試
	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private PersonDao personDao;

	@Autowired
	New1Dao new1;
	
	@Autowired
	private QuestionnaireService questionnaireService;

	// 實現對 http 請求的模擬，主要是用來測試 controller
	private MockMvc mockMvc;

	@BeforeAll
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

//		@BeforeEach  // 註解掉 就不會跑這整段
	public void beforeEach() {
		// save 在run之前把資料塞進去
		Person item = new Person();
		item.setName("C01");
		item.setEmail("c01@gmail.com");
		item.setMobile("0900000000");
		item.setAge("20");
		// Date date = new Date(); // 若為了使所有欄位時間一致
		item.setCreateTime(new Date()); // java.util // 給出當下時間
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
		Assert.notNull(item, "Person item is null"); // 錯誤訊息
		// print 兩個欄位
		System.out.println(item.getName());
		System.out.println(item.getEmail());
	}

}
