package com.vechain.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.druid.pool.DruidDataSource;
import com.vechain.datasource.ds.DynamicDataSourceRegister;

@Configuration
@ConditionalOnClass(DruidDataSource.class)
@Import(value = { DynamicDataSourceRegister.class })
@PropertySource(value = { "classpath:config/database.properties" })
public class DatabaseConfigure {

}
