package cn.ljlin233.config;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * PropertiesConfig
 */
@Configuration
public class PropertiesConfig {

    @Bean
    public PropertiesFactoryBean propertiesFactoryBean() throws IOException {

        PropertiesFactoryBean factoryBean = new PropertiesFactoryBean();
        factoryBean.setLocations(new PathMatchingResourcePatternResolver().getResources("classpath:properties/*.properties"));
        factoryBean.setFileEncoding("utf-8");

        return factoryBean;
    }

    
    @Bean
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer(@Qualifier("propertiesFactoryBean") Properties properties) {
        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
        configurer.setProperties(properties);

        return configurer;
    }

    
}