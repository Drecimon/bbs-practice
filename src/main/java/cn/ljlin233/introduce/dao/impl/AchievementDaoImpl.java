package cn.ljlin233.introduce.dao.impl;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.jdbc.SQL;

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


    @Override
    @Select("select * from intro_achievement limit ${start}, ${offset}")
    @Results({
        @Result(column = "up_userid", property = "upUserId"),
        @Result(column = "up_nickname", property = "upNickname"),
        @Result(column = "up_date", property = "upDate"),
        @Result(column = "visit_count", property = "visitCount"),
    })
    public List<Achievement> getAchievementsPage(@Param("start") int start, @Param("offset") int offset);


    @Override
    @Select("select * from intro_achievement where locate(#{keywords}, title) > 0 limit ${start}, ${offset}")
    @Results({
        @Result(column = "up_userid", property = "upUserId"),
        @Result(column = "up_nickname", property = "upNickname"),
        @Result(column = "up_date", property = "upDate"),
        @Result(column = "visit_count", property = "visitCount"),
    })
    public List<Achievement> searchAchievements(@Param("keywords") String keywords, @Param("start") int start, @Param("offset") int offset);


    @Override
    @Select("select * from intro_achievement where id = #{id}")
    @Results({
        @Result(column = "up_userid", property = "upUserId"),
        @Result(column = "up_nickname", property = "upNickname"),
        @Result(column = "up_date", property = "upDate"),
        @Result(column = "visit_count", property = "visitCount"),
    })
    public Achievement getAchievementById(int id);


    @Override
    @Update("update intro_achievement set visit_count=visit_count+1 where id = #{id}")
    public void addVisitCount(int id);

    @Override
    @Select("select count(id) from intro_achievement")
    public int getAchievementCount();

    @Select("select count(id) from intro_achievement where locate(#{keywords}, title) > 0")
    @Override
    public int getSearchCount(String keywords);

    @Override
    @UpdateProvider(type = AchievementDaoSQL.class, method = "updateSQL")
    public void updateAchievement(Achievement achievement);


    @Override
    @Delete("delete from intro_achievement where id = #{id}")
    public void deleteAchievement(int id);

    /**
     * InnerAchievementDaoImpl
     */
    class AchievementDaoSQL {
    
        public String updateSQL(Achievement achievement) {
            return new SQL() {{
                UPDATE("intro_achievement");
                if (achievement.getTitle() != null) {
                    SET("title = #{title}");
                }
                if (achievement.getContent() != null) {
                    SET("content = #{content}");
                }
                WHERE("id = #{id}");
            }}.toString();
        }
    }

}