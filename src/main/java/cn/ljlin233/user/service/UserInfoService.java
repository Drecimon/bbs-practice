package cn.ljlin233.user.service;

import cn.ljlin233.user.entity.UserInfo;

/**
 * UserInfoService
 */
public interface UserInfoService {

    public UserInfo getUserInfo(int id);

    public void updateNickname(int userId, String newname);

    public void updateUserInfo(UserInfo userInfo);

    public void deleteUser(int id);

}