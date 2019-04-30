package cn.ljlin233.user.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import cn.ljlin233.config.RootConfig;
import cn.ljlin233.config.WebConfig;


/**
 * UserLoginControllerTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, WebConfig.class})
@WebAppConfiguration
public class UserLoginControllerTest {

    @Autowired
    private UserLoginController userLoginController;

    @Test
    public void notNull() {
        assertNotNull(userLoginController);
    }

    //@Test
    public void testLogin() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userLoginController).build();

        RequestBuilder request = null;
        String except = "{\"userId\":4,\"userToken\":\"e386b6058e604313af9a48456ff5a147\",\"userRole\":[\"student\",\"teacher\",\"admin\",\"root\"]}";
        
        request = post("/api/login")
                .param("identifier", "4")
                .param("credential", "123");

        mockMvc.perform(request).andExpect(content().string(except));

    }
    
}