package com.paladin.account.resp;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.Serializable;

/**
 * 统一返回结果
 *
 * @author: paladin
 * @Description:
 * @date: created in 2020/7/31 0:25
 */
@Data
public class RespResult<T> implements Serializable {

	private static final long serialVersionUID = -2757635913593029410L;

	private static final Logger LOGGER = LoggerFactory.getLogger(RespResult.class);

	private Integer code;

	private String message;

	private T data;

	/**
	 * 无参构造方法
	 */
	public RespResult() {
	}

	/**
	 * 创建对象
	 *
	 * @return RestResult
	 */
	public static RespResult build() {
		return new RespResult();
	}

	/**
	 * 设置code
	 *
	 * @param code 业务状态码
	 * @return RespResult
	 */
	public RespResult code(Integer code) {
		this.code = code;
		return this;
	}

	/**
	 * 设置message
	 *
	 * @param message message
	 * @return RespResult
	 */
	public RespResult message(String message) {
		this.message = message;
		return this;
	}

	/**
	 * 设置data
	 *
	 * @param data data
	 * @return RespResult
	 */
	public RespResult data(T data) {
		this.data = data;
		return this;
	}

	/**
	 * 请求正常完成，返回结果，http status 200
	 *
	 * @param data body数据
	 * @return RespResult
	 */
	public RespResult success(T data) {
		return build().data(data);
	}
}
