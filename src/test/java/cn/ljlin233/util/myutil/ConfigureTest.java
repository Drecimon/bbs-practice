package cn.ljlin233.util.myutil;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.ljlin233.config.RootConfig;
import cn.ljlin233.config.WebConfig;

/**
 * ConfigureTest
 */
//@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration(classes = { RootConfig.class, WebConfig.class })
// @WebAppConfiguration
public class ConfigureTest {

    @Test
    public void testConfigure() throws Exception {
        Configure config = new Configure("properties/jdbc.properties");
        assertEquals("local", config.getValue("env"));
    }

}