package com.example.demo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Person;

@Repository
public interface PersonDao extends JpaRepository<Person, UUID> {
	
//	@Transactional
//	@Query("update person p set p.email = :inputEmail where p.id = :inputId")
//	public void updateById(
//			@Param("inputId") UUID id,
//			@Param("inputEmail") String email);

}
