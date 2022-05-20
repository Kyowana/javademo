package com.example.demo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.New1;

@Repository
public interface New1Dao extends JpaRepository<New1, Integer> {
	// 這裡Integer要全寫 (是個類別，不是用Entity型態)

}
