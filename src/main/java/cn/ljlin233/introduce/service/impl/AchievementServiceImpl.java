package cn.ljlin233.introduce.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ljlin233.introduce.dao.AchievementDao;
import cn.ljlin233.introduce.entity.Achievement;
import cn.ljlin233.introduce.service.AchievementService;
import cn.ljlin233.user.entity.UserInfo;
import cn.ljlin233.user.service.UserInfoService;
import cn.ljlin233.util.exception.entity.DataCheckedException;
import cn.ljlin233.util.exception.entity.SystemException;

/**
 * AchievementServiceImpl
 */
@Service
public class AchievementServiceImpl implements AchievementService {

    private SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private AchievementDao achievementDao;

    private UserInfoService userInfoService;

    public AchievementServiceImpl() {
    }

    @Autowired
    public AchievementServiceImpl(AchievementDao achievementDao, UserInfoService userInfoService) {
        this.achievementDao = achievementDao;
        this.userInfoService = userInfoService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addAchievement(String title, String content, Integer userId) {

        if (title == null || title.length() == 0) {
            throw new DataCheckedException("标题不能为空!");
        }
        if (content == null || content.length() == 0) {
            throw new DataCheckedException("内容不能为空!");
        }
        UserInfo userInfo = userInfoService.getUserInfo(userId);
        if (userId == null) {
            throw new DataCheckedException("账号不存在!");
        }

        Achievement achievement = new Achievement();
        achievement.setTitle(title);
        achievement.setContent(content);
        achievement.setUpUserId(userId);
        achievement.setUpNickname(userInfo.getNickname());
        String upDate = dateformat.format(new Date());
        achievement.setUpDate(upDate);
        try {
            achievementDao.addAchievement(achievement);
        } catch (Exception e) {
            throw new SystemException("服务器存储文章失败", e.getMessage());
        }

    }

    @Override
    public List<Achievement> getAllAchievements() {

        List<Achievement> all = null;

        try {
            all = achievementDao.getAllAchievements();
        } catch (Exception e) {
            throw new SystemException("服务器获取所有研究成果失败!", e.getMessage());
        }
    
        return all;
    }

}