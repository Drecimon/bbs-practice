package cn.ljlin233.introduce.dao.impl;

import org.apache.ibatis.annotations.Insert;

import cn.ljlin233.introduce.dao.AchievementDao;
import cn.ljlin233.introduce.entity.Achievement;

/**
 * AchievementDaoImpl
 */
public interface AchievementDaoImpl extends AchievementDao {

    @Override
    @Insert("insert into intro_achievement (title, content, up_userid, up_nickname, up_date) " +
        "values (#{title}, #{content}, #{upUserId}, #{upNickname}, #{upDate})")
    public void addAchievement(Achievement achievement);

    
    
}