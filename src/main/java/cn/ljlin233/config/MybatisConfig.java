package cn.ljlin233.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisConfig
 */
@Configuration
@MapperScan("cn.ljlin233.user.dao.impl")
public class MybatisConfig {


}