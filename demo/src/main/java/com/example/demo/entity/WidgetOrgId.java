package com.example.demo.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class WidgetOrgId implements Serializable {
	
	private String widgetId;

	private String orgId;

	public WidgetOrgId() {

	}
	
	public WidgetOrgId(String widgetId, String orgId) {
		super();
		this.widgetId = widgetId;
		this.orgId = orgId;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((widgetId == null) ? 0 : widgetId.hashCode());
		result = prime * result + ((orgId == null) ? 0 : orgId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WidgetOrgId other = (WidgetOrgId) obj;
		if (widgetId == null) {
			if (other.widgetId != null)
				return false;
		} else if (!widgetId.equals(other.widgetId))
			return false;
		if (orgId == null) {
			if (other.orgId != null)
				return false;
		} else if (!orgId.equals(other.orgId))
			return false;
		return true;
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

}
