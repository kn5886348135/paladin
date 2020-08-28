package com.paladin.account.config;

import com.paladin.account.resp.RespResult;
import com.paladin.account.resp.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

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

    /**
     * TODO  修改为自己的需求
     */
    private static final String IZATION = "CHUCHEN";

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

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
//        super.addInterceptors(registry);
        registry.addInterceptor(new HandlerInterceptorAdapter() {
            /**
             * This implementation always returns {@code true}.
             * @param request
             * @param response
             * @param handler
             */
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//                return super.preHandle(request, response, handler);
                String ization = request.getHeader("ization");
                if (IZATION.equals(ization)) {
                    return true;
                } else {
//                    RetResult<Object> result = new RetResult<>();
//                    result.setCode(RetCode.UNAUTHORIZED).setMsg("签名认证失败");
//                    responseResult(response, result);
//                    return false;
                    return true;
                }
            }
        }).addPathPatterns("/");
    }

//    private void responseResult(HttpServletResponse response, RetResult<Object> result) {
//        response.setCharacterEncoding("UTF-8");
//        response.setHeader("Content-type", "application/json;charset=UTF-8");
//        response.setStatus(200);
//        try {
//            response.getWriter().write(JSON.toJSONString(result, SerializerFeature.WriteMapNullValue));
//        } catch (IOException ex) {
//            LOGGER.error(ex.getMessage());
//        }

    private CorsConfiguration buildConfig() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        //请求方法    config.addAllowedMethod(HttpMethod.GET);
        config.addAllowedMethod(HttpMethod.POST);
        config.addAllowedMethod(HttpMethod.PUT);
        config.addAllowedMethod(HttpMethod.DELETE);
        config.addAllowedMethod(HttpMethod.OPTIONS);
        return config;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        //处理全部请求路径
        configSource.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(configSource);
    }

}
