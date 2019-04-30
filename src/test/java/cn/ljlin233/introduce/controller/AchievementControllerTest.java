package cn.ljlin233.introduce.controller;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import cn.ljlin233.config.RootConfig;
import cn.ljlin233.config.WebConfig;
import cn.ljlin233.introduce.service.AchievementService;


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
    private AchievementController achievementController;

    @Autowired
    private AchievementService achievementService;

    @Test
    public void notNull() {
        assertNotNull(achievementController);
        assertNotNull(achievementService);
    }

    //@Test
    public void testController() throws Exception {

        achievementService.addAchievement("title", "content", 1);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(achievementController).build();

        RequestBuilder request = null;

        String except = "[{\"id\":9,\"title\":\"title\",\"content\":\"content\",\"upUserId\":null,\"upNickname\":null,\"upDate\":null,\"visitCount\":null}]";
        
        request = get("/api/achievements");
        
        mockMvc.perform(request).andExpect(content().string(except));

    }
    
}