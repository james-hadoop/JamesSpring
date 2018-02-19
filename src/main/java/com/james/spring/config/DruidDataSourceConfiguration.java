package com.james.spring.config;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@MapperScan(basePackages = "com.james.spring.dao.mapper")
public class DruidDataSourceConfiguration {
    @Bean(name = "druidDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        DataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }

    // @Bean(name = "druidSqlSessionFactory")
    // public SqlSessionFactory sqlSessionFactory(@Qualifier("druidDataSource")
    // DataSource dataSource) throws Exception {
    // SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
    // sessionFactoryBean.setDataSource(dataSource);
    // sessionFactoryBean.setMapperLocations(new
    // PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml"));
    // return sessionFactoryBean.getObject();
    // }
}
