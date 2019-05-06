package cn.ljlin233.resource.dao.impl;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import cn.ljlin233.resource.dao.BanDao;
import cn.ljlin233.resource.entity.Ban;

/**
 * BanDaoImpl
 */
public interface BanDaoImpl extends BanDao {

    @Override
    @Select("select * from res_ban")
    @Results(id = "banMap", value = {
        @Result(column = "ban_id", property = "banId"),
        @Result(column = "add_id", property = "addId"),
    })
    public List<Ban> getAllBanUser();

    @Override
    @Select("select count(id) from res_ban")
    public int getAllBanUserCount();

    @Override
    @Select("select * from res_ban limit ${start}, ${offset}")
    @ResultMap(value = "banMap")
    public List<Ban> getBanUserByPage(@Param("start") int start, @Param("offset") int offset);

    @Override
    @Insert("insert into res_ban (ban_id, add_id) values (#{banId}, #{addId})")
    public void addBanUser(Ban ban);

    @Override
    @Delete("delete from res_ban where id = #{id}")
    public void deleteBanUser(int id);
    
}