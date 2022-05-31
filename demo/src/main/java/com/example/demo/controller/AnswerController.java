package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Answer;
import com.example.demo.enums.RtnCode;
import com.example.demo.service.ifs.AnswerService;
import com.example.demo.vo.AnswerResp;
import com.example.demo.vo.GetAnswerReq;

@RestController
public class AnswerController {

	private Logger logger = LoggerFactory.getLogger(getClass());// slf4j
	
	@Autowired
	private AnswerService answerService;

	@PostMapping(value = "/getAnswer")
	public AnswerResp getAnswerById(@RequestBody GetAnswerReq req) {
		String id = req.getId();
		AnswerResp answerResp = new AnswerResp();
		try {
			if (!StringUtils.hasText(id)) {
				answerResp = new AnswerResp(HttpStatus.BAD_REQUEST.toString(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
						new Answer());
				return answerResp;
			}

			Answer answerItem = answerService.getAnswerById(UUID.fromString(id));
			answerResp = new AnswerResp(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), answerItem);
			logger.info("log info: " + id);
			throw new Exception("exception test");
//			return answerResp;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		} finally {
			System.out.println("不管怎樣一定會執行");
		}
		return answerResp;

	}

	@PostMapping(value = "/getAnswers")
	public AnswerResp getAnswersByPersonId(@RequestBody GetAnswerReq req) {
		String personId = req.getPersonId();
		if (!StringUtils.hasText(personId)) {
			return new AnswerResp(HttpStatus.BAD_REQUEST.toString(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
					new ArrayList<>());
		}
		List<Answer> list = answerService.getAnswerByPersonId(UUID.fromString(personId));
		return new AnswerResp(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), list);

	}
	
	@GetMapping(value = "/getAllAnswers")
	public AnswerResp getAllAnswers() {

		List<Answer> list = answerService.getAnswers();
		return new AnswerResp(list);

	}

}
