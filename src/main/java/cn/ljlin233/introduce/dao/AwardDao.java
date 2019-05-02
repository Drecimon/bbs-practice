package cn.ljlin233.introduce.dao;

import java.util.List;

import cn.ljlin233.introduce.entity.Award;

/**
 * AwardDao
 */
public interface AwardDao {

    public void addAward(Award award);

    public List<Award> getAllAwards();
    
    public List<Award> getAwardsPage(int start, int offset);

    public Award getAwardById(int id);

    public void addVisitCount(int id);

    public int getAwardCount();

    public List<Award> searchAwards(String keywords, int start, int offset);

    public int getSearchCount(String keywords);

    public void updateAward(Award award);

    public void deleteAward(int id);
}