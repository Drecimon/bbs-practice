package cn.ljlin233.introduce.service;

import java.util.List;

import cn.ljlin233.introduce.entity.Apply;

/**
 * ApplyService
 */
public interface ApplyService {

    
	public void addApply(int userId, String username, String applyType, int departmentId);

    public Apply getApplyById(int id);

    public List<Apply> getApplyByUserId(int userId);

    public void updateApply(int id, String applyStatus);

    public List<Apply> getUnhandleApply(int userId, int page, int pageNum);

}