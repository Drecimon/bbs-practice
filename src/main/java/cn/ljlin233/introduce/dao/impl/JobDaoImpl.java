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

import cn.ljlin233.introduce.dao.JobDao;
import cn.ljlin233.introduce.entity.Job;


/**
 * JobDaoImpl
 */
public interface JobDaoImpl extends JobDao {

    @Override
    @Insert("insert into intro_job (title, content, up_userid, up_nickname, up_date) "
            + "values (#{title}, #{content}, #{upUserId}, #{upNickname}, #{upDate})")
    public void addJob(Job job);


    @Override
    @Select("select * from intro_job")
    @Results({
        @Result(column = "up_userid", property = "upUserId"),
        @Result(column = "up_nickname", property = "upNickname"),
        @Result(column = "up_date", property = "upDate"),
        @Result(column = "visit_count", property = "visitCount"),
    })
    public List<Job> getAllJobs();


    @Override
    @Select("select * from intro_job limit ${start}, ${offset}")
    @Results({
        @Result(column = "up_userid", property = "upUserId"),
        @Result(column = "up_nickname", property = "upNickname"),
        @Result(column = "up_date", property = "upDate"),
        @Result(column = "visit_count", property = "visitCount"),
    })
    public List<Job> getJobsPage(@Param("start") int start, @Param("offset") int offset);


    @Override
    @Select("select * from intro_job where locate(#{keywords}, title) > 0 limit ${start}, ${offset}")
    @Results({
        @Result(column = "up_userid", property = "upUserId"),
        @Result(column = "up_nickname", property = "upNickname"),
        @Result(column = "up_date", property = "upDate"),
        @Result(column = "visit_count", property = "visitCount"),
    })
    public List<Job> searchJobs(@Param("keywords") String keywords, @Param("start") int start, @Param("offset") int offset);


    @Override
    @Select("select * from intro_job where id = #{id}")
    @Results({
        @Result(column = "up_userid", property = "upUserId"),
        @Result(column = "up_nickname", property = "upNickname"),
        @Result(column = "up_date", property = "upDate"),
        @Result(column = "visit_count", property = "visitCount"),
    })
    public Job getJobById(int id);


    @Override
    @Update("update intro_job set visit_count=visit_count+1 where id = #{id}")
    public void addVisitCount(int id);

    @Override
    @Select("select count(id) from intro_job")
    public int getJobCount();

    @Select("select count(id) from intro_job where locate(#{keywords}, title) > 0")
    @Override
    public int getSearchCount(String keywords);

    @Override
    @UpdateProvider(type = JobDaoSQL.class, method = "updateSQL")
    public void updateJob(Job job);


    @Override
    @Delete("delete from intro_job where id = #{id}")
    public void deleteJob(int id);

    /**
     * InnerJobDaoImpl
     */
    class JobDaoSQL {
    
        public String updateSQL(Job job) {
            return new SQL() {{
                UPDATE("intro_job");
                if (job.getTitle() != null) {
                    SET("title = #{title}");
                }
                if (job.getContent() != null) {
                    SET("content = #{content}");
                }
                WHERE("id = #{id}");
            }}.toString();
        }
    }
    
}