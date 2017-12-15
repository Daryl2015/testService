package com.me.testService.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = { "environment.dev" })
public class DevDataSourceConfig {
    private static final Logger logger = LoggerFactory.getLogger(DevDataSourceConfig.class);
    /**
     * 用户名密码登陆
     */
    @Bean
    @ConfigurationProperties(prefix = "test.datasource")
    public DataSource dataSource() {
        logger.info("DevDataSourceConfig doing.");
        return DataSourceBuilder.create().build();
    }
}
