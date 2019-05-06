package cn.ljlin233.announce.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ljlin233.announce.dao.AnnounceDao;
import cn.ljlin233.announce.entity.Announce;
import cn.ljlin233.announce.service.AnnounceService;
import cn.ljlin233.user.entity.UserInfo;
import cn.ljlin233.user.service.UserInfoService;
import cn.ljlin233.util.exception.entity.SystemException;

/**
 * AnnounceServiceImpl
 */
@Service
public class AnnounceServiceImpl implements AnnounceService {

    private AnnounceDao announceDao;
    
    private SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private UserInfoService userInfoService;

    public AnnounceServiceImpl() {
    }

    @Autowired
    public AnnounceServiceImpl(AnnounceDao announceDao, UserInfoService userInfoService) {
        this.announceDao = announceDao;
        this.userInfoService = userInfoService;
    }


    @Override
    public List<Announce> getAllAnnounces() {
        List<Announce> results = null;

        try {
            results = announceDao.getAllAnnounces();
        } catch (Exception e) {
            throw new SystemException("Get all announces fail", e.getMessage());
        }

        return results;
    }


    @Override
    public List<Announce> getAnnouncesByPage(int page, int pageNum) {
        int start = (page) * pageNum;
        List<Announce> results = null;

        try {
            results = announceDao.getAnnouncesByPage(start, pageNum);
        } catch (Exception e) {
            throw new SystemException("fail to get announces by page", e.getMessage());
        }
        return results;
    }

    @Override
    public Announce getAnnounceById(int id) {
        Announce result = null;
        try {
            result = announceDao.getAnnounceById(id);
        } catch (Exception e) {
            throw new SystemException("failed to get announce by Id", e.getMessage());
        }
        announceDao.addVisitCount(id);
        return result;
    }

    @Override
    public List<Announce> searchAnnounces(String title, int page, int pageNum) {
        int start = (page-1) * pageNum;
        List<Announce> results = null;
        try {
            results = announceDao.searchAnnounce(title, start, pageNum);
        } catch (Exception e) {
            throw new SystemException("failed to search announces", e.getMessage());
        }
    
        return results;
    }

    @Override
    public List<Announce> getAnnouncesByDepartment(int departmentId, int page, int pageNum) {
        int start = (page-1) * pageNum;
        List<Announce> results = null;
        try {
            results = announceDao.getAnnouncesByDepartment(departmentId, start, pageNum);
        } catch (Exception e) {
            throw new SystemException("failed to get announces by department", e.getMessage());
        }
        return results;
    }

    @Override
    public void addAnnounce(String title, String content, int upUserId, String savePath) {
        
        Announce announce = new Announce();
        UserInfo info = userInfoService.getUserInfo(upUserId);

        announce.setTitle(title);
        announce.setContent(content);
        announce.setUpUserId(upUserId);
        announce.setSavePath(savePath);
        announce.setUpUserNickname(info.getNickname());
        announce.setUpDate(dateformat.format(new Date()));
        try {
            announceDao.addAnnounce(null);
        } catch (Exception e) {
            throw new SystemException("failed to add Announce to server", e.getMessage());
        }
    }

    @Override
    public void updateAnnounce(int id, String title, String content, String savePath) {
        Announce announce = new Announce();
        announce.setId(id);
        if (title != null && title.length() != 0) {
            announce.setTitle(title);
        }
        if (content != null && content.length() != 0) {
            announce.setContent(content);
        }
        if (savePath != null && savePath.length() != 0) {
            announce.setSavePath(savePath);
        }
        try {
            announceDao.updateAnnounce(announce);
        } catch (Exception e) {
            throw new SystemException("failed to update announce", e.getMessage());
        }
    }

    @Override
    public void deleteAnnounce(int id) {
        try {
            announceDao.deleteAnnounce(id);
        } catch (Exception e) {
            throw new SystemException("failed to delete announce", e.getMessage());
        }
    }

    @Override
    public Integer getAllAnnouncesCount() {
        int count = 0;
        try {
            count = announceDao.getAllAnnouncesCount();
        } catch (Exception e) {
            throw new SystemException("failed to get all announce count", e.getMessage());
        }
        return count;
    }

    @Override
    public Integer getSearchCount(String keywords) {
        int count = 0;
        try {
            count = announceDao.getSearchCount(keywords);
        } catch (Exception e) {
            throw new SystemException("failed to get search announce count", e.getMessage());
        }
        return count;
    }

    @Override
    public Integer getDepartmentAnnounceCount(int departmentId) {
        int count = 0;
        try {
            count = announceDao.getDepartmentAnnounceCount(departmentId);
        } catch (Exception e) {
            throw new SystemException("failed to get department announce count", e.getMessage());
        }
        return count;
    }
    
}