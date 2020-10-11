package com.paladin.account.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;

/**
 * @author: paladin
 * @Description:
 * @date: created in 2020/8/26 21:26
 */
public class RequestUtil {
	/**
	 * 获取当前request scope的response
	 */
	private static final HttpServletRequest request =
			((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
	public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	public static final ObjectNode OBJECT_NODE = OBJECT_MAPPER.createObjectNode();


	public static String getAllRequestParam() {
		Map<String, String[]> paramMap = request.getParameterMap();
		String queryString = request.getQueryString();
		String url = request.getRequestURI();
		JsonNode node = OBJECT_NODE.put("queryString", queryString);
		OBJECT_NODE.putPOJO("paramMap", paramMap);
		OBJECT_NODE.put("url", url);
		return OBJECT_NODE.toPrettyString();
	}

}
