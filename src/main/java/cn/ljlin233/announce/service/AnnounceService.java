package cn.ljlin233.announce.service;

import java.util.List;

import cn.ljlin233.announce.entity.Announce;

/**
 * AnnounceService
 */
public interface AnnounceService {

    public List<Announce> getAllAnnounces();

    public List<Announce> getAnnouncesByPage(int page, int pageNum); 

    public Announce getAnnounceById(int id);

    public List<Announce> searchAnnounces(String title, int page, int pageNum);

    public List<Announce> getAnnouncesByDepartment(int departmentId, int page, int pageNum);

    public void addAnnounce(String title, String content, int upUserId, String savePath);

    public void updateAnnounce(int id, String title, String content, String savePath);

    public void deleteAnnounce(int id);

    public Integer getAllAnnouncesCount();

    public Integer getSearchCount(String keywords);

    public Integer getDepartmentAnnounceCount(int departmentId);
}