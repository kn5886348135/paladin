package com.paladin.account.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paladin.account.resp.RespResult;
import com.paladin.account.resp.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author: paladin
 * @Description:
 * @date: created in 2020/8/26 21:27
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	public static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	public static final ObjectMapper objectMapper = new ObjectMapper();

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public void globalExceptionHandler(HttpServletRequest request, Exception e) throws JsonProcessingException {
		RespResult result = new RespResult();
		Enumeration<String> urlParamNames = request.getParameterNames();
		StringBuffer urlParams = new StringBuffer();

		while (urlParamNames.hasMoreElements()) {
			String urlParamName = urlParamNames.nextElement();
			urlParams.append(urlParamName).append(" ").append(request.getParameter(urlParamName)).append(System.lineSeparator());
		}


		String paramMap = objectMapper.writeValueAsString(request.getParameterMap());

		LOGGER.info("request url {},request method {}, url request params {}, request params map {}, exception {}",
				request.getRequestURI(), request.getMethod(), urlParams.toString(), paramMap, e.getMessage());

		if (e instanceof ServiceException) {
			result.buildInternalServerError(500, request.getRequestURI() + " ServiceException ", e.getMessage());
		}else if (e instanceof NoHandlerFoundException) {
			result.buildNotFounde(500, request.getRequestURI() + " NoHandlerFoundException ", e.getMessage());
		}else {
			result.buildInternalServerError(500, request.getRequestURI() + " ServiceException ", e.getMessage());
		}

	}
}
