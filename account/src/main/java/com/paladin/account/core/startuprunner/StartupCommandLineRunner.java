package com.paladin.account.core.startuprunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author: paladin
 * @Description:
 * @date: created in 2020/8/27 23:22
 */
@Component
@Order(value = -1)
public class StartupCommandLineRunner implements CommandLineRunner {
	private static final Logger LOGGER = LoggerFactory.getLogger(StartupCommandLineRunner.class);

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("服务器启动成功！<<<<使用CommandLineRunner接口");
	}

}
