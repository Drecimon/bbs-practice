package cn.ljlin233.introduce.service;

import java.util.List;

import cn.ljlin233.introduce.entity.Achievement;

/**
 * AchievementService
 */
public interface AchievementService {

    
    public void addAchievement(String title, String content, Integer userId);

    public List<Achievement> getAllAchievements();
}