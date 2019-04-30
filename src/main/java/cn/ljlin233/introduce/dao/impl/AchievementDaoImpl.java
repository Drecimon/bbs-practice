package cn.ljlin233.introduce.dao.impl;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import cn.ljlin233.introduce.dao.AchievementDao;
import cn.ljlin233.introduce.entity.Achievement;

/**
 * AchievementDaoImpl
 */
public interface AchievementDaoImpl extends AchievementDao {

    @Override
    @Insert("insert into intro_achievement (title, content, up_userid, up_nickname, up_date) "
            + "values (#{title}, #{content}, #{upUserId}, #{upNickname}, #{upDate})")
    public void addAchievement(Achievement achievement);


    @Override
    @Select("select * from intro_achievement")
    @Results({
        @Result(column = "up_userid", property = "upUserId"),
        @Result(column = "up_nickname", property = "upNickname"),
        @Result(column = "up_date", property = "upDate"),
        @Result(column = "visit_count", property = "visitCount"),
    })
    public List<Achievement> getAllAchievements();

}