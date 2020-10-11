package com.paladin.account.config;

import com.paladin.account.resp.RespResult;
import com.paladin.account.resp.ServiceException;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 *  @author: paladin
 *  @Description:
 *  @date: created in 2020/8/26 21:27
 */
@Configuration
public class GlobalExceptionHandler {

    @ExceptionHandler
    public void globalExceptionHandler(HttpServletRequest request, Exception e) {
        RespResult result = new RespResult();
        if (e instanceof ServiceException) {
            result.buildInternalServerError(500, request.getRequestURI() + "ServiceException", e.getMessage());
        }

        if (e instanceof NoHandlerFoundException) {
            result.buildNotFounde(500, request.getRequestURI() + "NoHandlerFoundException", e.getMessage());
        }

        result.buildInternalServerError(500, request.getRequestURI() + "ServiceException", e.getMessage());

    }
}
