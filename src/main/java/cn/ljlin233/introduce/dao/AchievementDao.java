package cn.ljlin233.introduce.dao;

import java.util.List;

import cn.ljlin233.introduce.entity.Achievement;

/**
 * AchievementDao
 */
public interface AchievementDao {

    public void addAchievement(Achievement achievement);

    public List<Achievement> getAllAchievements();
    
    public List<Achievement> getAchievementsPage(int start, int offset);

    public Achievement getAchievementById(int id);

    public void addVisitCount(int id);

    public int getAchievementCount();

    public List<Achievement> searchAchievements(String keywords, int start, int offset);

    public int getSearchCount(String keywords);

    public void updateAchievement(Achievement achievement);

    public void deleteAchievement(int id);
}