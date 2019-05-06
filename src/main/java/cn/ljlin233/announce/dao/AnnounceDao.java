package cn.ljlin233.announce.dao;

import java.util.List;

import cn.ljlin233.announce.entity.Announce;

/**
 * AnnounceDao
 */
public interface AnnounceDao {

    
    public List<Announce> getAllAnnounces();

    public List<Announce> getAnnouncesByPage(int start, int offset);

    public Announce getAnnounceById(int id);

    public List<Announce> searchAnnounce(String keywords, int start, int offset);

    public List<Announce> getAnnouncesByDepartment(int departmentId, int start, int offset);

    public Integer getAllAnnouncesCount();

    public Integer getSearchCount(String keywords);

    public Integer getDepartmentAnnounceCount(int departmentId);

    public void addAnnounce(Announce announce);

    public void updateAnnounce(Announce announce);

    public void deleteAnnounce(int id);

    public void addVisitCount(int id);

}