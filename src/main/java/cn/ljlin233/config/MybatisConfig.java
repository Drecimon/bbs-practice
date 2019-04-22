package cn.ljlin233.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisConfig
 */
@Configuration
@MapperScan("cn.ljlin233.user.dao.impl")
public class MybatisConfig {


}