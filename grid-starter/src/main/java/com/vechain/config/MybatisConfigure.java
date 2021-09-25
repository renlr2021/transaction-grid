package com.vechain.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = { "classpath:config/mapper.properties" })
@MapperScan(basePackages = { "com.vechain.*.db.mapper" })
public class MybatisConfigure {
	
}
