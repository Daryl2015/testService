package com.me.testService.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置文件配置environment.production则走这个类
 * 配置文件中test.datasource开头的配置数据库参数
 */
//@EnableTransactionManagement
@Configuration
@ConditionalOnProperty(name = { "environment.production" })
public class DataSourceConfig {
    private static final Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);
    @Value("${test.datasource.dsname}")
    private String dsname;
    /**
     * 用户名密码登陆
     */
    @Bean
    @ConfigurationProperties(prefix = "test.datasource")
    public DataSource dataSource() {
        logger.info("DataSourceConfig doing.");
        return DataSourceBuilder.create().build();
    }
}
