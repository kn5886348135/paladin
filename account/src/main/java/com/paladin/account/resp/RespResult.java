package com.paladin.account.resp;

import lombok.Builder;
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
@Builder
public class RespResult implements Serializable {

	private static final long serialVersionUID = -2757635913593029410L;

	private static final Logger LOGGER = LoggerFactory.getLogger(RespResult.class);

	private Integer code;

	private String message;

	/**
	 * 无参构造方法
	 */
	public RespResult() {
	}

	public RespResult(Integer code, String message) {
		this.code = code;
		this.message = message;
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
}
