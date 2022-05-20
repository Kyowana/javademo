package com.example.demo.service.impl;

import java.sql.SQLException;
import java.util.Optional;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Widget;
import com.example.demo.repository.WidgetDao;
import com.example.demo.repository.WidgetOrgDao;
import com.example.demo.service.ifs.WidgetApiService;

@Service // 託管 Service下在實作的地方
public class WidgetApiServiceImpl implements WidgetApiService {
	
	@Override
	public String getWidgetUrl(String url) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Autowired
//	private WidgetDao widgetDao;
//
//	@Autowired
//	private WidgetOrgDao widgetOrgDao;
	
//	@Override
//	public Widget getWidget(String widgetId) throws SQLException {
//		Optional<Widget> op = widgetDao.findById(widgetId);
//		if (!op.isPresent()) {
//			return new Widget();
//		}
//		return op.get();
//	}
	
	

	@Override
	public Widget getWidgets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Widget getWidgetByOrgId(String orgId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Widget deleteWidget(String widgetId) {
		// TODO Auto-generated method stub
		return null;
	}

	

//	private Logger logger = LoggerFactory.getlogger (getClass()); // slf4j

//	@Value("${healthplus.url]")
//	private String url;
//
//	@Autowired
//	private WidgetDao widgetDao;
//
//	@Autowired
//	private WidgetOrgDao widgetOrgDao;

//	@Override
//	public WidgetResp getWidget(String widgetId) throws SQLException {Optional<Widget> widgetOp = getWidgetDao().findById(widgetId);
//	WidgetResp resp = new WidgetResp();
//	resp.setStatus (WidgetApiRtnCode.SUCCESSFUL.getSeq());
//	resp.setMessage (WidgetApiRtnCode.SUCCESSFUL.getDefaultMessage());
//	
//	if (!widgetOp.isPresent()) {
//	resp.setData (new WidgetItem());
//	return resp;
//	Widget widget = widgetop.get();
//	List<WidgetOrg> widgetOrgList = getWidgetOrgDao().findByWidgetId(widgetId);
//	}
}
