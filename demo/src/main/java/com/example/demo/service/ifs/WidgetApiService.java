package com.example.demo.service.ifs;

import java.sql.SQLException;

import com.example.demo.entity.Widget;

public interface WidgetApiService {
	
	// �i�b�������w�q��k(�S����{�A�bimpl�~��@)
	public String getWidgetUrl(String url);
	
	
	
	
	
//	public Widget getWidget(String widgetId) throws SQLException;
	public Widget getWidgets();
	public Widget getWidgetByOrgId(String orgId) throws SQLException;
//	public SaveWidget saveWidget (SaveWidgetReq req) throws SerialException, SQLException;
	public Widget deleteWidget(String widgetId);
//	public OrgResp getOrgList (String ticket) throws Exception;

}
