package cn.ljlin233.introduce.dao.impl;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import cn.ljlin233.introduce.dao.MemberDao;
import cn.ljlin233.introduce.entity.Member;

/**
 * MemberDaoImpl
 * @author lvjinlin
 */
public interface MemberDaoImpl extends MemberDao {

    @Override
    @Select("select * from intro_member")
    @Results(id = "memberMap", value = {
        @Result(column = "member_id", property = "memberId"),
        @Result(column = "member_type", property = "memberType"),
        @Result(column = "member_name", property = "memberName"),
        @Result(column = "department_id", property = "departmentId"),
    })
    public List<Member> getAllMembers();

    @Override
    @Select("select * from intro_member where id = #{id}")
    @ResultMap(value = "memberMap")
    public Member getMemberById(int id);

    @Override
    @Select("select count(id) from intro_member")
    public Integer getMemberCounts();

    @Override
    @Select("select * from intro_member limit ${start}, ${pageNum}")
    @ResultMap(value = "memberMap")
    public List<Member> getMembersByPage(@Param("start") int start, @Param("pageNum") int pageNum);

    @Override
    @Select("select count(id) from intro_member where locate(#{name}, member_name) > 0")
    public Integer getSearchCounts(String name);

    @Override
    @Select("select * from intro_member where locate(#{name}, member_name) > 0 limit ${start}, ${pageNum}")
    @ResultMap(value = "memberMap")
    public List<Member> searchMemberByName(@Param("name") String name, @Param("start") int start, @Param("pageNum") int pageNum);

    
    @Override
    @Insert("insert into intro_member (member_id, member_type, member_name, department_id) values (#{memberId}, #{memberType}, #{memberName}, #{departmentId})")
    public void AddMember(Member member);

    @Override
    @Delete("delete from intro_member where id = #{id}")
    public void deleteMember(int id);


    @Override
    @Select("select * from intro_member where department_id=#{id} and member_type='teacher'")
    @ResultMap(value = "memberMap")
    public List<Member> getTeacherMember(int departmentId);

    @Override
    @Select("select * from intro_member where member_id = #{memberId}")
    @ResultMap(value = "memberMap")
    public List<Member> getMembersByMemberId(int memberId);
}