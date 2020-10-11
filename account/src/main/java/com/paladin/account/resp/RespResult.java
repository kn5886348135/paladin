package com.paladin.account.resp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.text.MessageFormat;

/**
 * @author: paladin
 * @Description:
 * @date: created in 2020/7/31 0:25
 */
public class RespResult implements Serializable {
	private static final long serialVersionUID = -2757635913593029410L;
	public static final Logger LOGGER = LoggerFactory.getLogger(RespResult.class);

	/**
	 * 获取当前request scope的response
	 */
	private HttpServletResponse RESPONSE =
			((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();

	private ObjectMapper objectMapper = new ObjectMapper();
	public ObjectNode OBJECT_NODE = objectMapper.createObjectNode();

	private Logger logger = LoggerFactory.getLogger(RespResult.class);

	/**
	 * 请求正常完成，返回结果，http status 200
	 *
	 * @param code    业务状态码
	 * @param message 业务状态码说明
	 * @param data    返回的业务数据
	 * @throws RuntimeException
	 */
	public void buildOk(int code, String message, Object data) throws RuntimeException {
		writeResponse(HttpStatus.OK, code, message, data);
	}

	/**
	 * 坏的请求，比如参数校验失败
	 * 返回http status 400
	 *
	 * @param code    业务状态码
	 * @param message 业务状态码说明
	 * @param data    返回的业务数据
	 * @throws RuntimeException
	 */
	public void buildBadRequest(int code, String message, Object data) throws RuntimeException {
		writeResponse(HttpStatus.BAD_REQUEST, code, message, data);
	}

	/**
	 * 未授权的请求，比如登陆失败、鉴权失败等
	 * 返回http status 401
	 *
	 * @param code    业务状态码
	 * @param message 业务状态码说明
	 * @param data    返回的业务数据
	 * @throws RuntimeException
	 */
	public void buildUnAuthorized(int code, String message, Object data) throws RuntimeException {
		writeResponse(HttpStatus.UNAUTHORIZED, code, message, data);
	}

	/**
	 * 服务器禁止的请求，一般是认为这个请求有非法攻击行为
	 * 返回http status 403
	 *
	 * @param code    业务状态码
	 * @param message 业务状态码说明
	 * @param data    返回的业务数据
	 * @throws RuntimeException
	 */
	public void buildForbidden(int code, String message, Object data) throws RuntimeException {
		writeResponse(HttpStatus.FORBIDDEN, code, message, data);
	}

	/**
	 * 请求路径不存在
	 * 返回http status 404
	 *
	 * @param code    业务状态码
	 * @param message 业务状态码说明
	 * @param data    返回的业务数据
	 * @throws RuntimeException
	 */
	public void buildNotFounde(int code, String message, Object data) throws RuntimeException {
		writeResponse(HttpStatus.NOT_FOUND, code, message, data);
	}

	/**
	 * 服务器内部错误，一般是未受检异常
	 * 返回http status 500
	 *
	 * @param code    业务状态码
	 * @param message 业务状态码说明
	 * @param data    返回的业务数据
	 * @throws RuntimeException
	 */
	public void buildInternalServerError(int code, String message, Object data) throws RuntimeException {
		writeResponse(HttpStatus.NOT_FOUND, code, message, data);
	}

	private String writeResponse(HttpStatus status, int code, String message, Object data) {
		assert RESPONSE != null;
		RESPONSE.setStatus(status.value());
		RESPONSE.setContentType(MediaType.APPLICATION_JSON_VALUE);
		RESPONSE.setCharacterEncoding("UTF-8");

		String dataStr = "";
		OBJECT_NODE.put("code", code);
		OBJECT_NODE.put("message", message);
		OBJECT_NODE.putPOJO("data", data);
		try {
			dataStr = objectMapper.writeValueAsString(OBJECT_NODE.putPOJO("data", data));
		} catch (JsonProcessingException e) {
			logger.info(MessageFormat.format("buildResponse response write JsonProcessingException {0} {1} {2}",
					code + "", message, OBJECT_NODE.putPOJO("data", data).toPrettyString()));
			// 这里应该抛出什么样的异常？Exception？
			throw new RuntimeException(e);
		}

		try {
			RESPONSE.getWriter().write(dataStr);
			return null;
		} catch (IOException ioException) {
			logger.info(MessageFormat.format("buildResponse response write IOException {0} {1} {2}",
					code + "", message, OBJECT_NODE.putPOJO("data", data).toPrettyString()));
			throw new RuntimeException(ioException);
		}
	}


}
