package cn.ljlin233.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisConfig
 */
@Configuration
@MapperScan(basePackages = {"cn.ljlin233.user.dao.impl", "cn.ljlin233.introduce.dao.impl", "cn.ljlin233.util.auth.dao"})
public class MybatisConfig {


}