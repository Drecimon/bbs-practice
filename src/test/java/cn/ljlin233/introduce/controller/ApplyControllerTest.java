package cn.ljlin233.introduce.controller;

import org.json.JSONObject;
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


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, WebConfig.class})
@WebAppConfiguration
@Transactional
@Rollback(true)
/**
 * ApplyControllerTest
 */
public class ApplyControllerTest {

    @Autowired
    WebApplicationContext ctx;

    private MockMvc mockMvc;

    @Before
    public void beforeTest() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.ctx).build();
    }


    public String getLoginToken() throws Exception {
        RequestBuilder login = MockMvcRequestBuilders.post("/api/login")
                                                    .param("identifier", "123@qq.com")
                                                    .param("credential", "123");

        String loginResult = mockMvc.perform(login).andReturn().getResponse().getContentAsString();
        JSONObject json = new JSONObject(loginResult);
        String token =  json.getString("token");
        
        return token;
    }

    @Test
    public void testAddApply() throws Exception {

        String token = getLoginToken();
        RequestBuilder request = MockMvcRequestBuilders.post("/api/applys").header("token", token)
                .param("userId", "1")
                .param("departmentId", "1")
                .param("username", "ha")
                .param("applyType", "student");
        String result = mockMvc.perform(request).andReturn().getResponse().getContentAsString();

        System.out.println(result);

    }

    @Test
    public void getUnhandleApply() throws Exception {

        String token = getLoginToken();
        RequestBuilder request = MockMvcRequestBuilders.get("/api/applys/unhandle").param("page", "1")
                .header("token", token);

        String result = mockMvc.perform(request).andReturn().getResponse().getContentAsString();

        System.out.println(result);

    }


}