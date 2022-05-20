package com.example.demo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetWidgetByOrgIdReq {
	
	@JsonProperty("org_id")
	private String orgId;
	
	public GetWidgetByOrgIdReq() {
		
	}
	
	public String getOrgId() {
		return orgId;
	}
	
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

}
