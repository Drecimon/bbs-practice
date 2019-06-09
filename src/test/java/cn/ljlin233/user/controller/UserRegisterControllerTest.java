package cn.ljlin233.user.controller;

import java.io.UnsupportedEncodingException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import cn.ljlin233.config.RootConfig;
import cn.ljlin233.config.WebConfig;
import cn.ljlin233.util.verification.dao.VerificationDao;

/**
 * UserLoginControllerTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootConfig.class, WebConfig.class })
@WebAppConfiguration
@Transactional
@Rollback(true)
public class UserRegisterControllerTest {

    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @Autowired
    private VerificationDao verificationDao;

    @Before
    public void beforeTest() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.ctx).build();
    }

    @Test
    public void testRegister() throws UnsupportedEncodingException, Exception {

        verificationDao.addVerification("12345", "1234");
        //System.out.println(verificationService.checkVerification("12345", "1234"));

        RequestBuilder request = MockMvcRequestBuilders.post("/api/user")
                .param("account", "5")
                .param("password", "123")
                .param("role", "student")
                .param("email", "1329540850@qq.com")
                .param("verId", "12345")
                .param("verCode", "1234");

        String result = mockMvc.perform(request).andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }
    
}