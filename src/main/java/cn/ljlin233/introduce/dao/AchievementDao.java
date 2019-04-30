package cn.ljlin233.introduce.dao;

import java.util.List;

import cn.ljlin233.introduce.entity.Achievement;

/**
 * AchievementDao
 */
public interface AchievementDao {

    public void addAchievement(Achievement achievement);

    public List<Achievement> getAllAchievements();
    
}