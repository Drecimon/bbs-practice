package cn.ljlin233.introduce.dao;

import java.util.List;

import cn.ljlin233.introduce.entity.Job;

/**
 * JobDao
 */
public interface JobDao {

    public void addJob(Job job);

    public List<Job> getAllJobs();
    
    public List<Job> getJobsPage(int start, int offset);

    public Job getJobById(int id);

    public void addVisitCount(int id);

    public int getJobCount();

    public List<Job> searchJobs(String keywords, int start, int offset);

    public int getSearchCount(String keywords);

    public void updateJob(Job job);

    public void deleteJob(int id);

}