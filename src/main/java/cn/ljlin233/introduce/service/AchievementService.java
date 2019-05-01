package cn.ljlin233.introduce.service;

import java.util.List;

import cn.ljlin233.introduce.entity.Achievement;

/**
 * AchievementService
 */
public interface AchievementService {

    
    public void addAchievement(String title, String content, Integer userId);

    public List<Achievement> getAllAchievements();

    public List<Achievement> getAchievementsPage(int page, int pageNum);

    public Achievement getAchievementById(int id);

    public void addVisitCount(int id);

    public int getAchievementCount();

    public List<Achievement> searchAchievements(String keywords, int page, int pageNum);

    public int getSearchCount(String keywords);

    public void updateAchievement(Achievement achievement);

    public void deleteAchievement(int id);

}