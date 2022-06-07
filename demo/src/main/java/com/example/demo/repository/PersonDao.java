package com.example.demo.repository;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Person;

@Repository
public interface PersonDao extends JpaRepository<Person, UUID> {
	
	@Transactional  // 對資料庫做增刪修(交易)
	@Modifying  // 刪修
	@Query("update Person p set p.email = :inputEmail, p.createTime = :inputCreateTime where p.id = :inputId")  // 表的名稱要大寫 // 對應的是entity名稱
	public void updateById(
			@Param("inputId") UUID id,
			@Param("inputEmail") String email,
			@Param ("inputCreateTime") Date ctime);

}
