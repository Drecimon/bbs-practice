package cn.ljlin233.resource.service;

import java.util.List;

import cn.ljlin233.resource.entity.Ban;

/**
 * BanService
 */
public interface BanService {

    
    public List<Ban> getAllBanUser();

    public int getAllBanUserCount();

    public List<Ban> getBanUserByPage(int page, int pageNum);

    public void addBanUser(int banId, int addId);

    public void deleteBanUser(int id);

}