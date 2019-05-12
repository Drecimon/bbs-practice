package cn.ljlin233.introduce.dao.impl;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.jdbc.SQL;

import cn.ljlin233.introduce.dao.ApplyDao;
import cn.ljlin233.introduce.entity.Apply;
import cn.ljlin233.util.page.Page;

/**
 * ApplyDaoImpl
 */
public interface ApplyDaoImpl extends ApplyDao {


    @Override
    @Insert("insert into intro_apply (user_id, username, apply_type, department_id, apply_status) values (#{userId}, #{username}, #{applyType}, #{departmentId}, #{applyStatus})")
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
    public List<Apply> getUnhandleApply(@Param("departmentIds") List<Integer> departmentIds, @Param("page") Page<?> page);

    
    class ApplyDaoSQL {

        @SuppressWarnings("unchecked")
        public String selectSQL(Map<?, ?> map) {

            List<Integer> departmentIds = (List<Integer>) map.get("departmentIds");

            StringBuilder sb = new StringBuilder();
            sb.append("select * from intro_apply where apply_status = '待审核' and department_id in ( ");

            MessageFormat mf = new MessageFormat("#'{'departmentIds[{0}]}");

            for (int i=0; i< departmentIds.size(); i++) {
                sb.append(mf.format(new Object[]{i}));
                sb.append(",");
            }

            sb.setCharAt(sb.length()-1, ')');

            

            //System.out.println(sb);

            return sb.toString();
        }

    }

}