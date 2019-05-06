package cn.ljlin233.resource.dao;

import java.util.List;

import cn.ljlin233.resource.entity.Resource;

/**
 * ResourceDao
 */
public interface ResourceDao {

    
    public List<Resource> getAllResources();

    public int getAllResourcesCount();

    public List<Resource> getResourcesByPage(int start, int offset);

    public List<Resource> searchResources(String keywords, int start, int offset);

    public int getSearchCount(String keywords);

    public List<Resource> getResourcesByType(String type, int start, int offset);

    public int getTypeCount(String type);

    public Resource getResourceById(int id);

    public void addVisitCount(int id);

    public void addDownloadCount(int id);

    public void addResource(Resource resource);

    public void updateResource(Resource resource);

    public void deleteResource(int id);

}