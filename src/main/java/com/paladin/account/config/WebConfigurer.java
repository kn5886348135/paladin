package com.paladin.account.config;

import com.paladin.account.resp.RespResult;
import com.paladin.account.resp.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *  @author: paladin
 *  @Description:
 *  @date: created in 2020/8/26 20:42
 */
public class WebConfigurer extends WebMvcConfigurationSupport {

    public static final Logger LOGGER = LoggerFactory.getLogger(WebConfigurer.class);

    // 自定义消息转换器
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        super.configureMessageConverters(converters);
//        FastJsonHttpMessageConverter4 converter = new FastJsonHttpMessageConverter4();
//        converter.setSupportedMediaTypes(getSupportedMediaTypes());
//        FastJsonConfig config = new FastJsonConfig();
//        config.setSerializerFeatures(
//                // String null -> ""
//                SerializerFeature.WriteNullStringAsEmpty,
//                // Number null -> 0
//                SerializerFeature.WriteNullNumberAsZero,
//                //禁止循环引用
//                SerializerFeature.DisableCircularReferenceDetect
//        );
//        converter.setFastJsonConfig(config);
//        converter.setDefaultCharset(Charset.forName("UTF-8"));
//        converters.add(converter);
    }

    private List<MediaType> getSupportedMediaTypes(){
        List<MediaType> supportedMediaTYpes = new ArrayList<>();
        supportedMediaTYpes.add(MediaType.APPLICATION_JSON);
        supportedMediaTYpes.add(MediaType.APPLICATION_JSON_UTF8);
        supportedMediaTYpes.add(MediaType.APPLICATION_ATOM_XML);
        supportedMediaTYpes.add(MediaType.APPLICATION_FORM_URLENCODED);
        supportedMediaTYpes.add(MediaType.APPLICATION_OCTET_STREAM);
        supportedMediaTYpes.add(MediaType.APPLICATION_PDF);
        supportedMediaTYpes.add(MediaType.APPLICATION_RSS_XML);
        supportedMediaTYpes.add(MediaType.APPLICATION_XHTML_XML);
        supportedMediaTYpes.add(MediaType.APPLICATION_XML);
        supportedMediaTYpes.add(MediaType.IMAGE_GIF);
        supportedMediaTYpes.add(MediaType.IMAGE_JPEG);
        supportedMediaTYpes.add(MediaType.IMAGE_PNG);
        supportedMediaTYpes.add(MediaType.TEXT_EVENT_STREAM);
        supportedMediaTYpes.add(MediaType.TEXT_HTML);
        supportedMediaTYpes.add(MediaType.TEXT_MARKDOWN);
        supportedMediaTYpes.add(MediaType.TEXT_PLAIN);
        supportedMediaTYpes.add(MediaType.TEXT_XML);
        return supportedMediaTYpes;
    }

    // 配置全局异常处理
    @Override
    protected void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        super.configureHandlerExceptionResolvers(exceptionResolvers);
        exceptionResolvers.add(getHandlerExceptionResolver());
    }

    /**
     * 创建异常处理
     * @return
     */
    private HandlerExceptionResolver getHandlerExceptionResolver(){
        HandlerExceptionResolver handlerExceptionResolver = new HandlerExceptionResolver(){
            @Override
            public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
                                                 Object handler, Exception e) {
                getResuleByHeandleException(request, handler, e);
                return new ModelAndView();
            }
        };
        return handlerExceptionResolver;
    }

    /**
     * 根据异常类型确定返回数据
     * @param request
     * @param handler
     * @param e
     * @return
     */
    private RespResult getResuleByHeandleException(HttpServletRequest request, Object handler, Exception e){
        RespResult result = new RespResult();
        if (e instanceof ServiceException) {
            result.buildInternalServerError(500, request.getRequestURI() + "ServiceException", e.getMessage());
        }

        if (e instanceof NoHandlerFoundException) {
            result.buildNotFounde(500, request.getRequestURI() + "NoHandlerFoundException", e.getMessage());
        }

        result.buildInternalServerError(500, request.getRequestURI() + "ServiceException", e.getMessage());
        return null;
    }
}
