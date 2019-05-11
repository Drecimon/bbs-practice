package cn.ljlin233.introduce.dao.impl;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.jdbc.SQL;

import cn.ljlin233.introduce.dao.ApplyDao;
import cn.ljlin233.introduce.entity.Apply;

/**
 * ApplyDaoImpl
 */
public interface ApplyDaoImpl extends ApplyDao {


    @Override
    @Insert("insert into intro_apply (user_id, username, apply_type, department_id, apply_status) values (#{userId}, #{username}, #{applyType}, #{departmentId}), #{applyStatus}")
    public void addApplys(Apply apply);


    @Override
    @Select("select * from intro_apply where id = #{id}")
    public Apply getApplyById(int id);


    @Override
    @Update("update intro_apply set apply_status = #{applyStatus} where id = #{id}")
    public void updateApply(Apply apply);
    
    @Override
    @Select("select * from intro_apply where user_id = #{userId}")
    public List<Apply> getApplyByUserId(int userId);

    @Override
    @SelectProvider(type = ApplyDaoSQL.class, method = "selectSQL" )
    public List<Apply> getUnhandleApply(List<Integer> departmentIds, int start, int offset);

    
    class ApplyDaoSQL {

        public String selectSQL(List<Integer> departmentIds) {

            return new SQL() {{

                SELECT("intro_apply");
                for (Integer departmentId : departmentIds) {
                    WHERE("department_id = #{departmentId}");
                    OR();
                }
                
            }}.toString();
        }

    }

}