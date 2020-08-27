package com.paladin.account.config;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

/**
 *  @author: paladin
 *  @Description:
 *  @date: created in 2020/8/26 21:43
 */
//@Configuration
//@EnableSwagger2
//@EnableKnife4j
//@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {

    @Bean(value = "defaultApi2")
    public Docket defaultApi2(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(new ApiInfo("Api Documentation", "Api Documentation",
                "1.0", "urn:tos", new Contact("", "", ""), "Apache 2.0", "http://www.apache" +
                ".org/licenses/LICENSE-2.0", new ArrayList<>()))
                .groupName("2.x版本").select().apis(RequestHandlerSelectors.basePackage("com.paladin.account"))
                .paths(PathSelectors.any())
                .build();
    }
}
