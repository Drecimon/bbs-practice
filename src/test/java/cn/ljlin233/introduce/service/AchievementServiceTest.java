package cn.ljlin233.introduce.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import cn.ljlin233.config.RootConfig;
/**
 * HomeControllerTest
 */
import cn.ljlin233.config.WebConfig;
import cn.ljlin233.introduce.entity.Achievement;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, WebConfig.class})
@WebAppConfiguration
/**
 * AchievementServiceTest
 */
@Transactional
@Rollback(true)
public class AchievementServiceTest {

    @Autowired
    private AchievementService achievementService;

    @Test
    public void testAddAchievement() {
        achievementService.addAchievement("title", "content", 1);
    }

    //@Test
    public void testGetAchievement() {
        List<Achievement> all = achievementService.getAllAchievements();
        String expect = "[Achievement [content=content, title=title, upDate=null, upNickname=null, upUserId=null, visitCount=null]]"; 
        assertEquals(expect, all.toString());
    }
    
}