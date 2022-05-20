//package com.example.demo.controller;
//
////import java.net.http.HttpHeaders;
//
////import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.http.MediaType;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
////import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo.entity.Widget;
//import com.example.demo.service.ifs.WidgetApiService;
//import com.example.demo.vo.GetWidgetReq;
////import com.example.demo.vo.WidgetResp;
//
//@RestController
//public class WidgetApiController {
//	
////	private Logger logger = LoggerFactory.getlogger (getClass()); // slf4j
//
//	@Autowired
//	private WidgetApiService widgetApiService;
//
//	/**
//	 * ¨ú±oWidget
//	 * 
//	 * @param req
//	 * @return
//	 * @throws
//	 */
//
//
//	@PostMapping(value = "/getWidget")
//	public Widget getWidget(@RequestBody GetWidgetReq req) throws Exception {
//		
////		WidgetResp resp= new WidgetResp();
////		try {
//			String widgetId= req.getId();
//			if (!StringUtils.hasText(widgetId)) {
//				return new Widget();
//				}
////				resp.setStatus(WidgetApiRtnCode. PARAMETER_REQUIRE.getSeq());
////				resp.setMessage (WidgetApiRtnCode. PARAMETER_REQUIRE.getDefaultMessage());
////				resp.setData(new WidgetItem());
////				logger.error("parameter required!");
////				return resp;
////			}
////			resp=widgetApiService.getWidget (widgetId);
////		} catch(Exception e) {
////			logger.debug("getWidget error: " + e);
////			resp.setMessage(e.getMessage());
////		}
//		return widgetApiService.getWidget(widgetId);
//	}
//}
