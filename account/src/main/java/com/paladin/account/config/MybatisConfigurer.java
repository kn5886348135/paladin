package com.paladin.account.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author: paladin
 * @Description:
 * @date: created in 2020/7/30 22:49
 */
@Configuration
//@MapperScan("com.paladin.account.mapper*")
public class MybatisConfigurer {

//	@Bean
//	public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) throws Exception {
//		SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
//		factory.setDataSource(dataSource);
//		factory.setTypeAliasesPackage("com.paladin.account.entity");
//		// 添加XML目录
//		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//		factory.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
//		return factory.getObject();
//	}

//	@Bean
//	public MapperScannerConfigurer mapperScannerConfigurer() {
//		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
//		mapperScannerConfigurer.setBasePackage("com.paladin.account.mapper*");
//		return mapperScannerConfigurer;
//	}

}
