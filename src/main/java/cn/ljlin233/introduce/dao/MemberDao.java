package cn.ljlin233.introduce.dao;

import java.util.List;

import cn.ljlin233.introduce.entity.Member;

/**
 * MemberDao
 */
public interface MemberDao {

    public List<Member> getAllMembers();

    public List<Member> getMembersByPage(int start, int pageNum);

    public Member getMemberById(int id);

    public Integer getMemberCounts();

    public List<Member> searchMemberByName(String name, int start, int pageNum);

    public Integer getSearchCounts(String name);

    public void AddMember(Member member);

    public void deleteMember(int id);

}