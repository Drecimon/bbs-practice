package cn.ljlin233.user.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.ljlin233.config.RootConfig;
import cn.ljlin233.config.WebConfig;
/**
 * UserOriginServiceTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, WebConfig.class})
@WebAppConfiguration
public class UserOriginServiceTest {

    @Autowired
    private UserOriginService userOriginService;


    @Test
    public void notNull() {
        assertNotNull(userOriginService);
    }
    
    @Test
    public void getUnexistId() {
        boolean result = userOriginService.checkUserOrigin("0");
        assertEquals(false, result);
    }

}