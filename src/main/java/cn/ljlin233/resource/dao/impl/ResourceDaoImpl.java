package cn.ljlin233.resource.dao.impl;

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

import cn.ljlin233.resource.dao.ResourceDao;
import cn.ljlin233.resource.entity.Resource;

/**
 * ResourceDaoImpl
*/
public interface ResourceDaoImpl extends ResourceDao {

    @Override
    @Select("select * from res_resource")
    @Results(id = "resourceMap", value = {
        @Result(column = "up_userid", property = "upUserId"),
        @Result(column = "up_nickname", property = "upNickname"),
        @Result(column = "up_date", property = "upDate"),
        @Result(column = "visit_count", property = "visitCount"),
        @Result(column = "download_count", property = "downloadCount"),
    })
    public List<Resource> getAllResources();

    @Override
    @Select("select count(id) from res_resource")
    public int getAllResourcesCount();

    @Override
    @Select("select * from res_resource limit ${start}, ${offset}")
    @ResultMap(value = "resourceMap")
    public List<Resource> getResourcesByPage(@Param("start") int start, @Param("offset") int offset);

    @Override
    @Select("select * from res_resource where locate(#{keywords}, title) > 0 limit ${start}, ${offset}")
    @ResultMap(value = "resourceMap")
    public List<Resource> searchResources(@Param("keywords") String keywords, @Param("start") int start, @Param("offset") int offset);

    @Override
    @Select("select count(id) from res_resource where locate(#{keywords}, title) > 0")
    public int getSearchCount(String keywords);

    @Override
    @Select("select * from res_resource where category = #{type} limit ${start}, ${offset}")
    @ResultMap(value = "resourceMap")
    public List<Resource> getResourcesByType(@Param("type") String type, @Param("start") int start, @Param("offset") int offset);

    @Override
    @Select("select count(id) from res_resource where category = #{type}")
    public int getTypeCount(String type);

    @Override
    @Select("select * from res_resource where id = #{id}")
    @ResultMap(value = "resourceMap")
    public Resource getResourceById(int id);

    @Override
    @Update("update res_resource set visit_count=visit_count+1 where id = #{id}")
    public void addVisitCount(int id);

    @Override
    @Update("update res_resource set download_count=download_count+1 where id = #{id}")
    public void addDownloadCount(int id);

    @Override
    @Insert("insert into res_resource (title, content, category, up_userid, up_nickname, up_date, url) values " + 
        "(#{title}, #{content}, #{category}, #{upUserId}, #{upNickname}, #{upDate}, #{url})")
    public void addResource(Resource resource);

    @Override
    @UpdateProvider(type = ResourceDaoSQL.class, method = "updateResourceSQL")
    public void updateResource(Resource resource);

    @Override
    @Delete("delete from res_resource where id = #{id}")
    public void deleteResource(int id);

    /**
     * ResourceDaoSQL
     */
    public class ResourceDaoSQL {
    
        public String updateResourceSQL(Resource resource) {
            return new SQL() {{

                UPDATE("res_resource");
                if (resource.getTitle() != null) {
                    SET("title = #{title}");
                }
                if (resource.getContent() != null) {
                    SET("content = #{content}");
                }
                WHERE("id = #{id}");

            }}.toString();
        }
    }

}