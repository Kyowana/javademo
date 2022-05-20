package com.example.demo;

import java.util.List;
import java.util.Optional;
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

import com.example.demo.entity.Answer;
import com.example.demo.entity.Person;
import com.example.demo.entity.Question;
import com.example.demo.repository.AnswerDao;
import com.example.demo.repository.PersonDao;
import com.example.demo.repository.QuestionDao;

@WebAppConfiguration //要使用 web 環境模擬測試
@SpringBootTest(classes = DemoApplication.class) //為找到@SpringBootApplication主配置類別來啟動Spring Boot應用程式環境
@TestInstance(TestInstance.Lifecycle.PER_CLASS) //為了可以使用@BeforeAll 和 @AfterAll
public class AnswerTest {
	
	@Autowired
	private WebApplicationContext wac;
	
	@Autowired
	private PersonDao personDao;
	
	@Autowired
	private AnswerDao answerDao;
	
	@Autowired
	private QuestionDao questionDao;
	
	private MockMvc mockMvc;
	
	@BeforeAll
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
	
	//@BeforeEach  // 註解掉 就不會跑這整段
//	public void beforeEach() {
//		// save
//		Answer item = new Answer();
//		item.setPersonId("5605cd5f-6669-46dc-9057-7a7d3f7c2d21");
//		item.setQuestionId(UUID.randomUUID().toString());
//		item.setAnswer("hello");
//		answerDao.save(item);
//	}
	
	@Test
	public void daoTest() {
		// select
		List<Answer> list = answerDao.findAll();
		System.out.println(list.size());
		Assert.notEmpty(list, "list is empty");
	}
	
	@Test
	public void personDaoTest() {
		// 1. select(find)
//		List<Answer> list = answerDao.findAll();
//		Answer answer;
//		for (Answer item : list) {
//			// 用Answer裡的personId去尋找Person表裡的id
//			UUID uuid = item.getPersonId();
//			if (uuid == UUID.fromString("5605cd5f-6669-46dc-9057-7a7d3f7c2d21")) {
//				answer = item;
//			}		
//		}
		// 用Answer裡的personId去尋找Person表裡的id
		Answer item = answerDao.findByPersonId("5605cd5f-6669-46dc-9057-7a7d3f7c2d22");
		String idString = item.getPersonId();
		Person personItem = null;
		Optional<Person> personOp = personDao.findById(UUID.fromString(idString));
		if (!personOp.isPresent()) {  // isPresent是給Optional用的
			// 若不存在
			Assert.isNull(personOp, "op is null");
		} else {
			personItem = personOp.get();
			System.out.println(personItem.getName());
		}
		
		// 2. update
		personItem.setName("C02");
		personItem.setEmail("c02@gmail.com");
		
		// 3. save
		personDao.save(personItem);
		
		// 4. check
		personOp = personDao.findById(UUID.fromString(idString));
		if (!personOp.isPresent()) {
			Assert.isNull(personOp, "op is null");
			return;
		}
		personItem = personOp.get();
		System.out.println(personOp.get().getName());
		Assert.isTrue(personItem.getName().equalsIgnoreCase("c02"), "Name is not equal"); // equalsIgnoreCase無視大小寫
	}
	
	
	@Test
	public void daoTest1() {
		// select
		List<Question> list = questionDao.findAll();
		System.out.println(list.size());
		Assert.notEmpty(list, "list is empty");
	}
	
	@Test
	public void questionDaoTest() {
		// 用Answer表裡的questionId去尋找Question表裡的questionId
		Answer item = answerDao.findByQuestionId(UUID.fromString("586c8055-60dd-4430-b5e5-28c1f3b96fcc"));
		if (item == null) {
			return;
		}
		UUID uuid = item.getQuestionId();  // 若上一行找不到會報null exception，應做null判斷
		Optional<Question> questionOp = questionDao.findByQuestionId(uuid);
		if (!questionOp.isPresent()) {
			// 若不存在
			Assert.isNull(questionOp, "op is null");
		} else {
			Question questionItem = questionOp.get();
			System.out.println(questionItem.getQuestionnaireId());
		}
		
	}

}
