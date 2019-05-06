package cn.ljlin233.introduce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ljlin233.introduce.dao.ApplyDao;
import cn.ljlin233.introduce.entity.Apply;
import cn.ljlin233.introduce.service.ApplyService;
import cn.ljlin233.introduce.service.MemberService;
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

    public ApplyServiceImpl() {}

    @Autowired
    public ApplyServiceImpl(ApplyDao applyDao, MemberService memberService) {
        this.applyDao = applyDao;
        this.memberService = memberService;
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