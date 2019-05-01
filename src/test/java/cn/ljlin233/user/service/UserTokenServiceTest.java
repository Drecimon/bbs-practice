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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, WebConfig.class})
@WebAppConfiguration
/**
 * UserTokenServiceTest
 */
public class UserTokenServiceTest {

    @Autowired
    private UserTokenService userTokenService;

    @Test
    public void testNotNull() {
        assertNotNull(userTokenService);
    }

    //@Test
    public void testUserToken() {
        Integer userId = userTokenService.getUserid("be9046aa6edb44939f28a2dc0de84aae");
        assertEquals("1", userId.toString());
    }
    
}