package com.paladin.account.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.paladin.account.resp.RespResult;
import com.paladin.account.resp.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 全局异常捕获
 *
 * @author: paladin
 * @Description:
 * @date: created in 2020/8/26 21:27
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(BindException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public RespResult bindExceptionHandler(BindException bindException) {
		List<String> message = new ArrayList<>();
		for (ObjectError objectError : bindException.getAllErrors()) {
			message.add(objectError.getDefaultMessage());
		}
		return new RespResult().message(message.stream().collect(Collectors.joining(", ")));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public RespResult methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException methodArgumentNotValidException) {
		List<String> message = new ArrayList<>();
		for (ObjectError objectError : methodArgumentNotValidException.getAllErrors()) {
			message.add(objectError.getDefaultMessage());
		}
		return new RespResult().message(message.stream().collect(Collectors.joining(", ")));
	}

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public RespResult constraintViolationExceptionExceptionHandler(ConstraintViolationException constraintViolationException) {
		Set<ConstraintViolation<?>> sets = constraintViolationException.getConstraintViolations();
		// interpolatedMessage和messageTemplate有什么区别？
		List<String> list = new ArrayList<>();
		for (ConstraintViolation<?> set : sets) {
			list.add(set.getMessageTemplate());
		}
		return new RespResult().message(list.stream().collect(Collectors.joining(", ")));
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public RespResult httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException httpMessageNotReadableException) {
		// TODO: 2022/2/12
		// 如何将message中的类、方法信息去掉？可能有些场景没有冒号，所以用冒号分割并不严谨
		return new RespResult().message(httpMessageNotReadableException.getMessage());
	}

	@ExceptionHandler(MethodNotAllowedException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public RespResult methodNotAllowedExceptionHandler(MethodNotAllowedException methodNotAllowedException) {
		return new RespResult().message(methodNotAllowedException.getMessage());
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public RespResult methodArgumentTypeMismatchExceptionHandler(MethodArgumentTypeMismatchException methodArgumentTypeMismatchException) {
		return new RespResult().message(methodArgumentTypeMismatchException.getMessage());
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public RespResult httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException httpRequestMethodNotSupportedException) {
		return new RespResult().message(httpRequestMethodNotSupportedException.getMessage());
	}

	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public RespResult httpMediaTypeNotSupportedExceptionHandler(HttpMediaTypeNotSupportedException httpMediaTypeNotSupportedException) {
		return new RespResult().message(httpMediaTypeNotSupportedException.getMessage());
	}

	@ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public RespResult httpMediaTypeNotAcceptableExceptionHandler(HttpMediaTypeNotAcceptableException httpMediaTypeNotAcceptableException) {
		return new RespResult().message(httpMediaTypeNotAcceptableException.getMessage());
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public RespResult missingServletRequestParameterExceptionHandler(MissingServletRequestParameterException missingServletRequestParameterException) {
		return new RespResult().message(missingServletRequestParameterException.getMessage());
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public RespResult noHandlerFoundExceptionHandler(NoHandlerFoundException noHandlerFoundException) {
		return new RespResult().message(noHandlerFoundException.getMessage());
	}

	@ExceptionHandler(NumberFormatException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public RespResult numberFormatExceptionHandler(NumberFormatException numberFormatException) {
		// TODO: 2022/2/12 没有验证
		return new RespResult().message(numberFormatException.getMessage());
	}

	@ExceptionHandler(HttpMessageConversionException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public RespResult httpMessageConversionExceptionHandler(HttpMessageConversionException httpMessageConversionException) {
		// TODO: 2022/2/12 没有验证
		return new RespResult().message(httpMessageConversionException.getMessage());
	}

	@ExceptionHandler(MaxUploadSizeExceededException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public RespResult maxUploadSizeExceededExceptionHandler(MaxUploadSizeExceededException maxUploadSizeExceededException) {
		// TODO: 2022/2/12 没有验证
		return new RespResult().message(maxUploadSizeExceededException.getMessage());
	}

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public RespResult globalExceptionHandler(Exception exception) throws JsonProcessingException {
		if (exception instanceof ServiceException) {
			ServiceException serviceException = (ServiceException) exception;
			return new RespResult().message(serviceException.getMessage());
		} else if (exception instanceof SQLException) {
			return new RespResult().message("SQL异常");
		} else {
			return new RespResult().message(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		}
	}
}
