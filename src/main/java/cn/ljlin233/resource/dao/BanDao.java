package cn.ljlin233.resource.dao;

import java.util.List;

import cn.ljlin233.resource.entity.Ban;

/**
 * BanDao
 */
public interface BanDao {

    public List<Ban> getAllBanUser();

    public int getAllBanUserCount();

    public List<Ban> getBanUserByPage(int start, int offset);

    public void addBanUser(Ban ban);

    public void deleteBanUser(int id);

}