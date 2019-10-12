package com.wj.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

//SqlSessionTemplate是MyBatis提供的持久层访问模板化的工具，
// 这个类负责管理MyBatis的SqlSession，用于调用MyBatis的SQL方法。
// 因为SqlSessionTemplate是线程安全的，可以被多个DAO所共享使用，所以项目中只建立了一个SqlSessionTemplate

//在这里使用的是mybatis注解需要的配置。
// mybatis3开始支持java注解，使用java注解可以替代xml配置文件，简化代码。
// 上面的代码中，使用@MapperScan来扫描注册mybatis数据库接口类，其中basePackages属性表明接口类所在的包，sqlSessionTemplateRef表明接口类使用的SqlSessionTemplate。
//
//@Configuration 申明这是一个配置类相当于xml配置文件，
// @Bean表示这是一个Spring管理的bean。
//@ConfigurationProperties用于装载yml的配置信息

// 提一下setMapperLocations是用于加载以xml结尾的mapper配置文件，这里注意路径就行了，根路径是resources。
// setConfigLocation是加载mybatis的配置文件mybatis-config.xml。

@Configuration
@MapperScan(basePackages = "com.wj.dao",sqlSessionTemplateRef = "dbSqlSessionTemplate")
public class DbDataSource {

    @Bean(name="dbData")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dbDataSource() {
        return DataSourceBuilder.create().build();
    }
//    public DataSource druidDataSource(){
//        return new DruidDataSource();
//    }

    @Bean(name = "dbSqlSessionFactory")
    public SqlSessionFactory dbSqlSessionFactory(@Qualifier("dbData") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        sqlSessionFactoryBean.setConfigLocation( new ClassPathResource("mybatis-config.xml"));
        System.out.println("**********"+new ClassPathResource("mybatis-config.xml").getPath());
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name="dbSqlSessionTemplate")
    public SqlSessionTemplate dbSqlSessionTemplate(@Qualifier("dbSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception{
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "dbTransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("dbData") DataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }
}
