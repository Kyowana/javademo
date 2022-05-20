package com.example.demo.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "person")
public class Person {

	@Id
	@Column(name = "id")
	@Type(type = "uuid-char")
	private UUID id = UUID.randomUUID();

	@Column(name = "name")
	private String name; // 若沒給初始值，為null (型別大寫可取得null) (字串沒有小寫)

//	private Integer intt; // null
//	private int inttt; // 0

//	private boolean boo; // false
//	private Boolean booo; // null

	@Column(name = "mobile")
	private String mobile;

	@Column(name = "email")
	private String email;

	@Column(name = "age")
	private String age;

	@Column(name = "create_time")
	private Date createTime;

	@Column(name = "questionnaire_iD")
	@Type(type = "uuid-char")
	private UUID questionnaireID = UUID.randomUUID();
	// private String questionnaireID;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public UUID getQuestionnaireID() {
		return questionnaireID;
	}

	public void setQuestionnaireID(UUID questionnaireID) {
		this.questionnaireID = questionnaireID;
	}

}
