package com.paladin.account.resp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 可以统一封装返回的数据结构，比如包含code、message、data。
 * 当前项目考虑status code为200时返回结果在body，异常情况已经封装好code、message，所以暂时不实现这个接口。
 * {@link ResponseBodyAdvice}的实现可以参考 {@link WebMvcAutoConfiguration} requestMappingHandlerAdapter方法
 * {@link org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter}
 * {@link org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter} handle()
 * {@link org.springframework.web.method.support.HandlerMethodReturnValueHandlerComposite} handleReturnValue
 * {@link org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor} handleReturnValue
 * {@link org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyAdviceChain}
 *
 * @author: paladin
 * @Description:
 * @date: created in 2022/2/11 19:55
 */
@RestControllerAdvice(basePackages = "com.paladin.account.controller")
public class CustomResponseBodyAdvice<T> implements ResponseBodyAdvice<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomResponseBodyAdvice.class);

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true || (AnnotatedElementUtils.hasAnnotation(returnType.getContainingClass(), ResponseBody.class) || returnType.hasMethodAnnotation(ResponseBody.class));
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        return body;
    }
}
