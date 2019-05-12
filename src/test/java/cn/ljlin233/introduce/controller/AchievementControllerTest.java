package cn.ljlin233.introduce.controller;

import static org.junit.Assert.assertNotEquals;

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
 * AchievementControllerTest
 */
public class AchievementControllerTest {

    @Autowired
    WebApplicationContext ctx;

    private MockMvc mockMvc;

    @Before
    public void beforeTest() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.ctx).build();
    }


    public String getLoginToken() throws Exception {
        RequestBuilder login = MockMvcRequestBuilders.post("/api/login")
                                                    .param("identifier", "126@qq.com")
                                                    .param("credential", "123");

        String loginResult = mockMvc.perform(login).andReturn().getResponse().getContentAsString();
        JSONObject json = new JSONObject(loginResult);
        String token =  json.getString("token");
        
        return token;
    }


    @Test
    public void testGetAllAchievement() throws Exception {

        String token = getLoginToken();
        RequestBuilder request = MockMvcRequestBuilders.get("/api/achievements").header("token", token);
        String result = mockMvc.perform(request).andReturn().getResponse().getContentAsString();

        assertNotEquals(0, result.length());

    }

    @Test
    public void testGetAchievementByPage() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders.get("/api/achievements?page=1");
        String result = mockMvc.perform(request).andReturn().getResponse().getContentAsString();
        //System.out.println(result);
        assertNotEquals(0, result.length());

    }


    @Test
    public void testGetAchievementById() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders.get("/api/achievements?id=1");
        String result = mockMvc.perform(request).andReturn().getResponse().getContentAsString();
        //System.out.println(result);
        assertNotEquals(0, result.length());

    }

    @Test
    public void testSearchAchievement() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders.get("/api/achievements").param("search", "hello").param("page", "1");
        String result = mockMvc.perform(request).andReturn().getResponse().getContentAsString();
        //System.out.println(result);
        assertNotEquals(0, result.length());

    }


    @Test
    public void updateAchievement() throws Exception {

        String token = getLoginToken();
        RequestBuilder request = MockMvcRequestBuilders.put("http://IP/api/achievements?id=1").param("content", "update content").header("token", token);
        String result = mockMvc.perform(request).andReturn().getResponse().getContentAsString();
        System.out.println(result);

    }

}