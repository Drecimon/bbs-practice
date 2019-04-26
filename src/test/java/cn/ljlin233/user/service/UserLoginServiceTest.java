package cn.ljlin233.user.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.ljlin233.config.RootConfig;
import cn.ljlin233.config.WebConfig;
import cn.ljlin233.user.entity.UserToken;
/**
 * UserLoginServiceTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, WebConfig.class})
@WebAppConfiguration
public class UserLoginServiceTest {

    @Autowired
    private UserLoginService userLoginService;


    @Test
    public void testUserLogin() {
        String identifier = "123451";
        String credential = "123";

        UserToken userToken = userLoginService.userLogin(identifier, credential);

        assertNotNull(userToken);

    }
    
}