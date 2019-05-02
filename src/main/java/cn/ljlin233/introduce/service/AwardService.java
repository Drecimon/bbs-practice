package cn.ljlin233.introduce.service;

import java.util.List;

import cn.ljlin233.introduce.entity.Award;

/**
 * AwardService
 */
public interface AwardService {

    public void addAward(String title, String content, Integer userId);

    public List<Award> getAllAwards();

    public List<Award> getAwardsPage(int page, int pageNum);

    public Award getAwardById(int id);

    public void addVisitCount(int id);

    public int getAwardCount();

    public List<Award> searchAwards(String keywords, int page, int pageNum);

    public int getSearchCount(String keywords);

    public void updateAward(Award award);

    public void deleteAward(int id);

}