package cn.ljlin233.introduce.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ljlin233.introduce.dao.AchievementDao;
import cn.ljlin233.introduce.entity.Achievement;
import cn.ljlin233.introduce.service.AchievementService;

/**
 * AchievementServiceImpl
 */
@Service
public class AchievementServiceImpl implements AchievementService {


    private SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private AchievementDao achievementDao;

    public AchievementServiceImpl() {}

    @Autowired
    public AchievementServiceImpl(AchievementDao achievementDao) {
        this.achievementDao = achievementDao;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addAchievement(String title, String content, Integer userId, String nickname) {
        Achievement achievement = new Achievement();
        achievement.setTitle(title);
        achievement.setContent(content);
        achievement.setUpUserId(userId);
        achievement.setUpNickname(nickname);
        String upDate = dateformat.format(new Date());
        achievement.setUpDate(upDate);

        achievementDao.addAchievement(achievement);
    }

}