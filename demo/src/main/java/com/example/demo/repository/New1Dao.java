package com.example.demo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.New1;

@Repository
public interface New1Dao extends JpaRepository<New1, Integer> {
	// �o��Integer�n���g (�O�����O�A���O��Entity���A)

}
