package cn.ljlin233.announce.dao.impl;

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

import cn.ljlin233.announce.dao.AnnounceDao;
import cn.ljlin233.announce.entity.Announce;

/**
 * AnnounceDaoImpl
 */
public interface AnnounceDaoImpl extends AnnounceDao {

    @Override
    @Insert("insert into anno_announce (title, content, up_userid, up_nickname, up_date, visit_count, save_path) values" + 
        "(#{title}, #{content}, #{upUserId}, #{upUserNickname}, #{upDate}, #{visitCount}, #{savePath})")
    public void addAnnounce(Announce announce);


    @Override
    @Update("update anno_announce set visit_count=visit_count+1 where id = #{id}")
    public void addVisitCount(int id);


    @Override
    @Delete("delete from anno_announce where id = #{id}")
    public void deleteAnnounce(int id);


    @Override
    @Select("select * from anno_announce")
    @Results(id = "announceMap", value = {
        @Result(column = "up_userid", property = "upUserId"),
        @Result(column = "up_nickname", property = "upUserNickname"),
        @Result(column = "up_date", property = "upDate"),
        @Result(column = "visit_count", property = "visitCount"),
        @Result(column = "save_path", property = "savePath"),
    })
    public List<Announce> getAllAnnounces();

    @Override
    @Select("select count(id) from anno_announce")
    public Integer getAllAnnouncesCount();


    @Override
    @Select("select * from anno_announce where id = #{id}")
    @ResultMap(value = "announceMap")
    public Announce getAnnounceById(int id);



    @Override
    @Select("select * from anno_announce where id in (select announce_id from anno_scope where department_id = #{departmentId}) limit ${start}, ${offset}")
    @ResultMap(value = "announceMap")
    public List<Announce> getAnnouncesByDepartment(@Param("departmentId") int departmentId, @Param("start") int start, @Param("offset") int offset);



    @Override
    @Select("select * from anno_announce limit ${start}, ${offset}")
    @ResultMap(value = "announceMap")
    public List<Announce> getAnnouncesByPage(int start, int offset);



    @Override
    @Select("select count(id) from anno_announce where id in (select announce_id from anno_scope where department_id = #{departmentId}) limit ${start}, ${offset}")
    public Integer getDepartmentAnnounceCount(int departmentId);


    @Override
    @Select("select count(id) from anno_announce where locate(#{keywords}, title) > 0" )
    public Integer getSearchCount(String keywords);


    @Override
    @Select("select * from anno_announce where locate(#{keywords}, title) > 0  limit ${start}, ${offset}" )
    public List<Announce> searchAnnounce(@Param("keywords") String keywords, @Param("start") int start, @Param("offset") int offset);


    @Override
    @UpdateProvider(type = AnnounceDaoSQL.class, method = "updateAnnounceSQL")
    public void updateAnnounce(Announce announce);
    
    
    /**
     * AnnounceDaoSQL
     */
    public class AnnounceDaoSQL {
    
        public String updateAnnounceSQL(Announce announce) {
            return new SQL() {{

                UPDATE("anno_announce");
                if (announce.getTitle() != null) {
                    SET("title = #{title}");
                }
                if (announce.getContent() != null) {
                    SET("content = #{content}");
                }
                if (announce.getSavePath()!= null) {
                    SET("save_path = #{savePath}");
                }
                WHERE("id = #{id}");

            }}.toString();
        }
    }

}