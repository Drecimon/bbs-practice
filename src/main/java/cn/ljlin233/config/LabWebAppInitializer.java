package cn.ljlin233.config;

import javax.servlet.Filter;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.HttpPutFormContentFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * LabWebAppInitializer
 */
public class LabWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // SpringApplicationContext
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {RootConfig.class};
    }
    
    // SpringMVCApplicationContext
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
		return new Filter[] {new CORSFilter(), new HttpPutFormContentFilter()};
	}

    
    @Override
    protected void customizeRegistration(Dynamic registration) {
            
        registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");

    }

}