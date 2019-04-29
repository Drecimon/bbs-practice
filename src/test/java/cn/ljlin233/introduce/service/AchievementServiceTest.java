package cn.ljlin233.introduce.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import cn.ljlin233.config.RootConfig;
/**
 * HomeControllerTest
 */
import cn.ljlin233.config.WebConfig;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, WebConfig.class})
@WebAppConfiguration
/**
 * AchievementServiceTest
 */
public class AchievementServiceTest {

    @Autowired
    private AchievementService achievementService;

    @Test
    public void testAchievement() {
        achievementService.addAchievement("title", "content", 1, "noone");
    }
    
}