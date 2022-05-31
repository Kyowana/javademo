package com.example.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import com.example.demo.entity.Answer;
import com.example.demo.entity.Person;
import com.example.demo.entity.Question;
import com.example.demo.repository.AnswerDao;
import com.example.demo.repository.PersonDao;
import com.example.demo.repository.QuestionDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
		Answer item = answerDao.findByPersonId(UUID.fromString("5605cd5f-6669-46dc-9057-7a7d3f7c2d22"));
		UUID id = item.getPersonId();
		Person personItem = null;
		Optional<Person> personOp = personDao.findById(id);
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
		personOp = personDao.findById(id);
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
	
	@SuppressWarnings("unchecked")
	@Test
	public void controllerTest(){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		Map<String, Object> map = new LinkedHashMap();
		map.put("id", "53625451-ba08-4167-9a30-cb06c142a51b");
		// map to string
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String reqBodyStr = objectMapper.writeValueAsString(map);
			ResultActions result = mockMvc.perform(post("/getAnswer").headers(headers).content(reqBodyStr));
			String responseString = result.andReturn().getResponse().getContentAsString();
			// string to map
			JacksonJsonParser jsonParser = new JacksonJsonParser();
			Map<String, Object> answerData = (Map<String, Object>) jsonParser.parseMap(responseString).get("answer_data");
			Assert.notEmpty(answerData, "answerData is Empty");
			System.out.println(answerData.toString());
		} catch (JsonProcessingException e) {
			System.out.println("reqBody parser error: " + e.getMessage());
		} catch (Exception e) {
			
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void controllerTest2() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		Map<String, Object> map = new LinkedHashMap();
		map.put("person_id", "5605cd5f-6669-46dc-9057-7a7d3f7c2d21");
		// map to string
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String reqBodyStr = objectMapper.writeValueAsString(map);
			ResultActions result = mockMvc.perform(post("/getAnswers").headers(headers).content(reqBodyStr));
			String responseString = result.andReturn().getResponse().getContentAsString();
			// string to map
			JacksonJsonParser jsonParser = new JacksonJsonParser();
			List<Map<String, Object>> answerDataList = (List<Map<String, Object>>) jsonParser.parseMap(responseString).get("answer_data_list");
			for (Map<String, Object> item : answerDataList) {
				System.out.println(item.toString());
			}
			Assert.notEmpty(answerDataList, "answerDataList is Empty");
		} catch (JsonProcessingException e) {
			System.out.println("reqBody parser error: " + e.getMessage());
		} catch (Exception e) {
			
		}
	}
	
	@Test
	public void connectionTest() {
		// set headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		// set requestBody
		Map<String, String> reqBodyMap = new LinkedHashMap<>();
		reqBodyMap.put("id", "53625451-ba08-4167-9a30-cb06c142a51b");
		
		// map to string
		ObjectMapper objectMapper = new ObjectMapper();
		String reqBodyString = "";
		try {
			reqBodyString = objectMapper.writeValueAsString(reqBodyMap);
		} catch (Exception e) {
			System.out.println("ObjectMapper.writeValueAsString error: " + e.getMessage());
		}
		String targerURL = "http://localhost:8083/getAnswer";  // 隨便找個網頁
		
		HttpEntity<String> requestBody = new HttpEntity<>(reqBodyString, headers);
		try {
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.postForEntity(targerURL, requestBody, String.class);
			String respStr = response.getBody();
			if(!StringUtils.hasText(respStr)) {
				System.out.println("Call API error: Response is empty");
			} else {
				System.out.println(respStr);
			}
		} catch (HttpClientErrorException | HttpServerErrorException e) {
			System.out.println("Call API http error: " + e.getResponseBodyAsString());
		}
		
	}
	
	@Test
	@Transactional  // 會更動到DB的內容
	public void transTest() {
		List<Person> list = new ArrayList<>();
		Person item = new Person();
		item.setAge("20");
		list.add(item);
//		personDao.save(list);
	}
	


}
