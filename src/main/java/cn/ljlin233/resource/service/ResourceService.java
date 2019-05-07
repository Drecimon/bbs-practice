package cn.ljlin233.resource.service;

import java.util.List;

import cn.ljlin233.resource.entity.Resource;

/**
 * ResourceService
 */
public interface ResourceService {

    public List<Resource> getAllResources();

    public int getAllResourcesCount();

    public List<Resource> getResourcesByPage(int page, int pageNum);

    public List<Resource> searchResources(String keywords, int page, int pageNum);

    public int getSearchCount(String keywords);

    public List<Resource> getResourcesByType(String type, int page, int pageNum);

    public int getTypeCount(String type);

    public Resource getResourceById(int id);

    public void addVisitCount(int id);

    public void addDownloadCount(int id);

    public void addResource(String title, String content, String category, int upUserId, String url);

    public void updateResource(int id, String title, String content);

    public void deleteResource(int id);

}