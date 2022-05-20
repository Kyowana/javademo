package com.example.demo.repository;

import com.example.demo.entity.Widget_org;
import com.example.demo.entity.WidgetOrgId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WidgetOrgDao extends JpaRepository<Widget_org, WidgetOrgId> {

}
