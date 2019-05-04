package cn.ljlin233.introduce.dao.impl;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.jdbc.SQL;

import cn.ljlin233.introduce.dao.DepartmentDao;
import cn.ljlin233.introduce.entity.Department;
import cn.ljlin233.introduce.entity.Member;

/**
 * DepartmentDaoImpl
 */
public interface DepartmentDaoImpl extends DepartmentDao {

    @Override
    @Insert("insert into intro_department (name, description) values (#{name}, #{description})")
    public void addDepartment(Department department);

    @Override
    @Select("select * from intro_department")
    public List<Department> getAllDepartments();

    @Override
    @Select("select * from intro_department limit ${start}, ${offset}")
    public List<Department> getDepartmentsPage(@Param("start") int start, @Param("offset") int offset);

    @Override
    @Select("select * from intro_department where id = #{id}")
    public Department getDepartmentById(int id);

    @Override
    @Select("select count(id) from intro_department")
    public int getDepartmentCount();

    @Override
    @Select("select * from intro_department where locate(#{keywords}, name) > 0 limit ${start}, ${offset}")
    public List<Department> searchDepartments(@Param("keywords") String keywords, @Param("start") int start, @Param("offset") int offset);

    @Override
    @Select("select count(id) from intro_department where locate(#{keywords}, name) > 0")
    public int getSearchCount(String keywords);

    @Override
    @UpdateProvider(type = DepartmentDaoSQL.class, method = "updateSQL")
    public void updateDepartment(Department department);

    @Override
    @Delete("delete from intro_department where id = #{id}")
    public void deleteDepartment(int id);

    @Override
    @Delete("delete from intro_member where department_id = #{id}")
    public void deleteDepartmentMember(int id);

    @Override
    @Select("select * from intro_member where department_id = {departmentId} limit ${start}, ${offset}")
    public List<Member> getDepartmentMembers(@Param("departmentId") int departmentId, @Param("start") int start, @Param("offset") int offset);

    @Override
    @Select("select count(id) from intro_member where department_id = {departmentId}")
    public int getMembersCount(int departmentId);

    /**
     * DepartmentDaoSQL
     */
    class DepartmentDaoSQL {
    
        public String updateSQL(Department department) {
            return new SQL() {{
                UPDATE("intro_department");
                if (department.getName() != null) {
                    SET("name = #{name}");
                }
                if (department.getDescription() != null) {
                    SET("description = #{description}");
                }
                WHERE("id = #{id}");
            }}.toString();
        }
        
    }



}