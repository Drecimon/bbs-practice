package cn.ljlin233.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Controller;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * RootConfig
 */
@Configuration
// Services, Repositories
@ComponentScan( basePackages = { "cn.ljlin233"}, excludeFilters = {
        @Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class),
        @Filter(type = FilterType.ANNOTATION, value = Controller.class) })
public class RootConfig {

}