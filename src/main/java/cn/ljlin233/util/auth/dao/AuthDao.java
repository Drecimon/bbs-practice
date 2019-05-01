package cn.ljlin233.util.auth.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * AuthDao
 */
public interface AuthDao {

    @Select("select ${column} from ${tableName} where id = #{id}")
    public Integer getOwnerId(@Param("tableName") String tableName, @Param("column") String column, @Param("id") Integer id);

}