package cn.ljlin233.introduce.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ljlin233.introduce.dao.ApplyDao;
import cn.ljlin233.introduce.entity.Apply;
import cn.ljlin233.introduce.entity.Member;
import cn.ljlin233.introduce.service.ApplyService;
import cn.ljlin233.introduce.service.MemberService;
import cn.ljlin233.user.entity.UserInfo;
import cn.ljlin233.user.service.UserInfoService;
import cn.ljlin233.util.email.entity.ActiveEmail;
import cn.ljlin233.util.email.service.ActiveEmailService;
import cn.ljlin233.util.exception.entity.DataCheckedException;
import cn.ljlin233.util.exception.entity.SystemException;

/**
 * ApplyServiceImpl
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ApplyServiceImpl implements ApplyService {


    private ApplyDao applyDao;

    private MemberService memberService;

    private UserInfoService userInfoService;

    private ActiveEmailService activeEmailService;

    public ApplyServiceImpl() {}

    @Autowired
    public ApplyServiceImpl(ApplyDao applyDao, MemberService memberService, UserInfoService userInfoService, ActiveEmailService activeEmailService) {
        this.applyDao = applyDao;
        this.memberService = memberService;
        this.userInfoService = userInfoService;
        this.activeEmailService = activeEmailService;
    }

    @Override
    public void addApply(int userId, String username, String applyType, int departmentId) {
        Apply apply = new Apply();
        apply.setUserId(userId);
        apply.setDepartmentId(departmentId);
        apply.setUsername(username);
        apply.setApplyType(applyType);
        apply.setApplyStatus("待审核");

        try {
            applyDao.addApplys(apply);
        } catch (Exception e) {
            throw new SystemException("提交入部申请失败", e.getMessage());
        }

        List<Member> teachers = memberService.getTeacherMember(departmentId);

        if (teachers == null || teachers.size()==0) {
            throw new SystemException("该部门没有教师，请联系管理员", null);
        } else {

            for (Member teacher : teachers) {
                int teacherId = teacher.getMemberId();
                UserInfo teacherInfo = userInfoService.getUserInfo(teacherId);
                String emailAdress = teacherInfo.getEmail();

                ActiveEmail email = new ActiveEmail();
                email.setSendFrom("杭电实验室");
                email.setSendTo(emailAdress);
                email.setMessage("有人申请加入部门，请处理");
                email.setTitle("实验室成员申请通知");

                try {
                    activeEmailService.sendActiveEamil(email);
                } catch (Exception e) {
                    throw new SystemException("发送部门申请通知邮件失败", e.getMessage());
                }

            }

        }

    }


    @Override
    public Apply getApplyById(int id) {
        Apply apply = null;
        try {
            apply = applyDao.getApplyById(id);
        } catch (Exception e) {
            throw new SystemException("获取入部申请失败", e.getMessage());
        }
        return apply;
    }

    @Override
    public List<Apply> getApplyByUserId(int userId) {
        List<Apply> applys = null;
        try {
            applys = applyDao.getApplyByUserId(userId);
        } catch (Exception e) {
            throw new SystemException("获取入部申请失败", e.getMessage());
        }
        return applys;
    }


    @Override
    public List<Apply> getUnhandleApply(int userId, int page, int pageNum) {
        int start = (page-1)*pageNum;
        List<Apply> applies = null;
        try {
            List<Member> teacher = memberService.getMembersByMemberId(userId);
            List<Integer> departments = new ArrayList<>();
            for(Member department : teacher) {
                departments.add(department.getDepartmentId());
            }

            applies = applyDao.getUnhandleApply(departments, start, pageNum);           
        } catch (Exception e) {
            throw new SystemException("获取未处理入部申请失败", e.getMessage());
        }

        return applies;
    }


    @Override
    public void updateApply(int id, String applyStatus) {
        Apply apply = new Apply();
        apply.setId(id);
        // 数据校验
        if (!(applyStatus.equals("已通过") || applyStatus.equals("已拒绝") )) {
            throw new DataCheckedException("申请表状态错误");
        } else {
           apply.setApplyStatus(applyStatus); 
        }
        // 更新Apply状态
        try {
            applyDao.updateApply(apply);
        } catch (Exception e) {
            throw new SystemException("更新入部申请失败", e.getMessage());
        }
        
        if (applyStatus.equals("已通过")) {
            // 添加部门成员
            Apply applyInfo = applyDao.getApplyById(id);
            memberService.addMember(applyInfo.getUserId(), applyInfo.getApplyType(), applyInfo.getUsername(), applyInfo.getDepartmentId());
        }

    }

}