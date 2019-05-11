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
@MapperScan(basePackages = {"cn.ljlin233.user.dao.impl", "cn.ljlin233.introduce.dao.impl", "cn.ljlin233.util.auth.dao", 
    "cn.ljlin233.announce.dao.impl", "cn.ljlin233.resource.dao.impl"})
public class MybatisConfig {


    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(ComboPooledDataSource dataSource ) {
        
        SqlSessionFactoryBean sfb = new SqlSessionFactoryBean();
        sfb.setDataSource(dataSource);
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();

        configuration.addInterceptor(new PageInterceptor());
        
        sfb.setConfiguration(configuration);
        return sfb;
    }

}