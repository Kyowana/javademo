package com.example.demo.repository;

//import java.util.Date;
//import java.util.List;
//import java.util.Set;

import com.example.demo.entity.Widget;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WidgetDao extends JpaRepository<Widget, String> {
	
	
//	public List<Widget> findByOrderByEndTimeDesc();
//
//	public List<Widget> findAllByIdInAndStartTimeLessThanEqualAndEndTimeGreaterThanEqual(Set<String> widgetIds,
//			Date datel, Date datel2);
//
//	public List<Widget> findBystartTimeAndEndTime(Date startTime, Date endTime);
	

}
