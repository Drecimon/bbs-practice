package cn.ljlin233.user.dao.impl;

import cn.ljlin233.user.dao.UserAuthsDao;

/**
 * UserAuthsDaoMapper
 */
public interface UserAuthsDaoMapper extends UserAuthsDao {


    @Override
    public void deleteAuths();

    @Override
    public void addUserAuths(int user_id, String identity_type, String identifier, String credential);
    
}