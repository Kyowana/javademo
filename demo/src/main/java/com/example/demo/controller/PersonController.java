package com.example.demo.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Person;
import com.example.demo.service.ifs.QuestionnaireService;
import com.example.demo.vo.GetPersonReq;
import com.example.demo.vo.PersonResp;

@RestController  // @Controller + @ResponseBody
public class PersonController {
	
	@Autowired
	private QuestionnaireService questionnaireService;
	
	@PostMapping(value = "/getPerson")  // HttpMethod POST
	public PersonResp getPersonById(@RequestBody GetPersonReq req) {
		String id = req.getId();
//		PersonResp personResp = new PersonResp();
		//if (id != null && id != "" && id != " ")
		if (!StringUtils.hasText(id)) {
			return new PersonResp(HttpStatus.BAD_REQUEST.toString(), HttpStatus.BAD_REQUEST.getReasonPhrase(), new Person());
//			personResp.setStatusCode(HttpStatus.BAD_REQUEST.toString());  // 錯誤請求
//			personResp.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
//			personResp.setPersonData(new Person());			
//			return personResp;
		}
		// call service --> controller 相關邏輯
		Person personItem = questionnaireService.getPersonById(UUID.fromString(id));
//		personResp.setStatusCode(HttpStatus.OK.toString());
//		personResp.setMessage(HttpStatus.OK.getReasonPhrase());
//		personResp.setPersonData(personItem);
		return new PersonResp(HttpStatus.OK.toString(), HttpStatus.OK.getReasonPhrase(), personItem);
	}

}
