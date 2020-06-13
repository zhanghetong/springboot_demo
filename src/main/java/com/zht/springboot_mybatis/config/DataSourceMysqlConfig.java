package com.zht.springboot_mybatis.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = DataSourceMysqlConfig.PACKAGE, sqlSessionFactoryRef = "test1SqlSessionFactory")
@MapperScan(basePackages = DataSourceMysqlConfig.PACKAGE2, sqlSessionFactoryRef = "test2SqlSessionFactory")
public class DataSourceMysqlConfig {

    static final String PACKAGE = "com.zht.springboot_mybatis.mapper.first";
    private static final String MAPPER_LOCATION = "classpath:mapper/first/*.xml";

    @Bean(name = "test1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.test1")
    public DataSource test1DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "test1SqlSessionFactory")
    public SqlSessionFactory test1SqlSessionFactory(@Qualifier("test1DataSource") DataSource test1DataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(test1DataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(DataSourceMysqlConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }

    @Bean(name = "test1TransactionManager")
    public DataSourceTransactionManager test1TransactionManager(@Qualifier("test1DataSource") DataSource test1DataSource) {
        return new DataSourceTransactionManager(test1DataSource);
    }



    static final String PACKAGE2 = "com.zht.springboot_mybatis.mapper.second";
    private static final String MAPPER_LOCATION2 = "classpath:mapper/second/*.xml";

    @Bean(name = "test2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.test2")
    public DataSource test2DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "test2SqlSessionFactory")
    public SqlSessionFactory test2SqlSessionFactory(@Qualifier("test2DataSource") DataSource test2DataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(test2DataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(DataSourceMysqlConfig.MAPPER_LOCATION2));
        return sessionFactory.getObject();
    }

    @Bean(name = "test2TransactionManager")
    public DataSourceTransactionManager test2TransactionManager(@Qualifier("test2DataSource") DataSource test2DataSource) {
        return new DataSourceTransactionManager(test2DataSource);
    }


}
