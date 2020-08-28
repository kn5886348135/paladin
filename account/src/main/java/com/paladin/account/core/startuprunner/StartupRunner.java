package com.paladin.account.core.startuprunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *  @author: paladin
 *  @Description:
 *  @date: created in 2020/8/27 23:21
 */
@Component
@Order(value = 1)
public class StartupRunner implements ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(StartupRunner.class);

    @Override
    public void run(ApplicationArguments var1) throws Exception{
        logger.info("服务器启动成功！<<<<使用ApplicationRunner接口");
    }

}
