package cn.ljlin233.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;



/**
 * DataSourceConfig
 */
@Configuration
@EnableTransactionManagement
public class DataSourceConfig {


    @Value("${mysqlConnectionURL}")
    private String mysqlConnectionURL;

    @Value("${mysqlUsername}")
    private String mysqlUsername;

    @Value("${mysqlPassword}")
    private String mysqlPassword;


    @Bean
    public ComboPooledDataSource dataSource() {
        ComboPooledDataSource ds = new ComboPooledDataSource();

        try {
            ds.setDriverClass("com.mysql.cj.jdbc.Driver");
            ds.setJdbcUrl(this.mysqlConnectionURL);
            ds.setUser(this.mysqlUsername);
            ds.setPassword(this.mysqlPassword);
            ds.setInitialPoolSize(3);
            ds.setMaxPoolSize(10);
            ds.setMinPoolSize(3);
            ds.setAcquireIncrement(3);
            ds.setMaxIdleTime(3600);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    // 事务
    @Bean
    public DataSourceTransactionManager transactionManager(ComboPooledDataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);

        return dataSourceTransactionManager;
    }
}