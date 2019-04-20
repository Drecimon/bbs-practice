package cn.ljlin233.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * DataSourceConfig
 */
@Configuration
public class DataSourceConfig {

    
    @Bean
    public ComboPooledDataSource dataSource() {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            ds.setDriverClass("com.mysql.cj.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/hdu_laboratory?serverTimezone=GMT%2B8");
            ds.setUser("root");
            ds.setPassword("ljldmysql.");
            ds.setInitialPoolSize(3);
            ds.setMaxPoolSize(10);
            ds.setMinPoolSize(3);
            ds.setAcquireIncrement(3);            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }    


    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(ComboPooledDataSource dataSource ) {
        
        SqlSessionFactoryBean sfb = new SqlSessionFactoryBean();
        sfb.setDataSource(dataSource);
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        sfb.setConfiguration(configuration);
        return sfb;
    }




}