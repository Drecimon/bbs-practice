package cn.ljlin233.introduce.service;

import java.util.List;

import cn.ljlin233.introduce.entity.Member;

/**
 * MemberService
 */
public interface MemberService {

    public List<Member> getAllMembers();

    public List<Member> getAllMembersByPage(int page, int pageNum);

    public int getAllMembersCounts();

    public Member getMemberById(int id);

    public List<Member> searchMembersByName(String name, int page, int pageNum);

    public int getSearchCounts(String name);

    public void addMember(int memberId, String memberType, String memberName, int departmentId);

    public void deleteMember(int id);

}