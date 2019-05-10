package cn.ljlin233.introduce.dao;

import java.util.List;

import cn.ljlin233.introduce.entity.Apply;

/**
 * ApplyDao
 */
public interface ApplyDao {

    public void addApplys(Apply apply);

    public Apply getApplyById(int id);

    public void updateApply(Apply apply);

    public List<Apply> getApplyByUserId(int userId);

    public List<Apply> getUnhandleApply(List<Integer> departmentIds, int start, int offset);

    
}