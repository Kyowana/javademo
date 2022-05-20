package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "widget_org")
@IdClass(value = WidgetOrgId.class)
public class Widget_org {
	
	@Id
	@Column(name = "widget_id")
//	@JsonProperty(name = "widget_id")
	private String widgetId;
	
	@Id
	@Column(name = "org_id")
//	@JsonProperty(name = "org_id")
	private String orgId;

	@Column(name = "org_name")
//	@JsonProperty(name = "name")
	private String orgName;

	/* constructors */
	public Widget_org() {

	}

	public Widget_org(String widgetId) {
//		super();
//		this.widgetId = widgetId;
//		this.orgId = orgId;
	}
	
	public String getWidgetId() {
		return widgetId;
	}

	public void setWidgetId(String widgetId) {
		this.widgetId = widgetId;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

}
