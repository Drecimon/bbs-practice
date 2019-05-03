package cn.ljlin233.introduce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ljlin233.introduce.dao.MemberDao;
import cn.ljlin233.introduce.entity.Member;
import cn.ljlin233.introduce.service.MemberService;
import cn.ljlin233.util.exception.entity.SystemException;

/**
 * MemberServiceImpl
 */
@Service
public class MemberServiceImpl implements MemberService {

    private MemberDao memberDao;

    public MemberServiceImpl() {};

    @Autowired
    public MemberServiceImpl(MemberDao memberDao) {
        this.memberDao = memberDao;
    }


    @Override
    public List<Member> getAllMembers() {
        List<Member> all = null;
        try {
            all = memberDao.getAllMembers();
        } catch (Exception e) {
            throw new SystemException("获取成员介绍失败", e.getMessage());
        }
        return all;
    }

    @Override
    public List<Member> getAllMembersByPage(int page, int pageNum) {
        int start = (page-1)*pageNum;
        List<Member> result = null;
        try {
            result = memberDao.getMembersByPage(start, pageNum);
        } catch (Exception e) {
            throw new SystemException("按页获取成员介绍失败", e.getMessage());
        }
        return result;
    }

    @Override
    public int getAllMembersCounts() {
        int count = 0;
        try {
            count = memberDao.getMemberCounts();
        } catch (Exception e) {
            throw new SystemException("获取成员数量失败", e.getMessage());
        }
        return count;
    }

    @Override
    public Member getMemberById(int id) {
        Member result = null;
        try {
            result = memberDao.getMemberById(id);
        } catch (Exception e) {
            throw new SystemException("获取成员信息失败", e.getMessage());
        }

        return result;
    }

    @Override
    public List<Member> searchMembersByName(String name, int page, int pageNum) {
        int start = (page-1)*pageNum;
        List<Member> result = null;

        try {
            result = memberDao.searchMemberByName(name, start, pageNum);
        } catch (Exception e) {
            throw new SystemException("搜索成员失败", e.getMessage());
        }

        return result;
    }

    @Override
    public int getSearchCounts(String name) {
        int count = 0;
        try {
            count = memberDao.getSearchCounts(name);
        } catch (Exception e) {
            throw new SystemException("获取搜索成员数量失败", e.getMessage());
        }
        return count;
    }

}