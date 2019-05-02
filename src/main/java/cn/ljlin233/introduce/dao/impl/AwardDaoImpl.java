package cn.ljlin233.introduce.dao.impl;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.jdbc.SQL;

import cn.ljlin233.introduce.dao.AwardDao;
import cn.ljlin233.introduce.entity.Award;

/**
 * AwardDaoImpl
 */
public interface AwardDaoImpl extends AwardDao {

    @Override
    @Insert("insert into intro_award (title, content, up_userid, up_nickname, up_date) "
            + "values (#{title}, #{content}, #{upUserId}, #{nickname}, #{datetime})")
    public void addAward(Award award);


    @Override
    @Select("select * from intro_award")
    @Results(id = "awardMap", value = {
        @Result(column = "up_userid", property = "upUserId"),
        @Result(column = "up_nickname", property = "nickname"),
        @Result(column = "up_date", property = "datetime"),
        @Result(column = "visit_count", property = "visitCount"),
    })
    public List<Award> getAllAwards();


    @Override
    @Select("select * from intro_award limit ${start}, ${offset}")
    @ResultMap(value = "awardMap")
    public List<Award> getAwardsPage(@Param("start") int start, @Param("offset") int offset);

    @Override
    @Select("select * from intro_award where id = #{id}")
    @ResultMap(value = "awardMap")
    public Award getAwardById(int id);

    @Override
    @Update("update intro_award set visit_count=visit_count+1 where id = #{id}")
    public void addVisitCount(int id);

    @Override
    @Select("select count(id) from intro_award")
    public int getAwardCount();

    @Override
    @Select("select * from intro_award where locate(#{keywords}, title) > 0 limit ${start}, ${offset}")
    @ResultMap(value = "awardMap")
    public List<Award> searchAwards(@Param("keywords") String keywords, @Param("start") int start, @Param("offset") int offset);

    @Override
    @Select("select count(id) from intro_award where locate(#{keywords}, title) > 0")
    public int getSearchCount(String keywords);

    @Override
    @UpdateProvider(type = AwardDaoSQL.class, method = "updateSQL")
    public void updateAward(Award award);

    @Override
    @Delete("delete from intro_award where id = #{id}")
    public void deleteAward(int id);


    /**
     * AwardDaoSQL
     */
    class AwardDaoSQL {
    
        public String updateSQL(Award award) {
            return new SQL() {{
                UPDATE("intro_award");
                if (award.getTitle() != null) {
                    SET("title = #{title}");
                }
                if (award.getContent() != null) {
                    SET("content = #{content}");
                }
                WHERE("id = #{id}");
            }}.toString();
        }
        
    }
    
}