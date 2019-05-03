package cn.ljlin233.introduce.service;

import java.util.List;

import cn.ljlin233.introduce.entity.Job;

/**
 * JobService
 */
public interface JobService {

    public void addJob(String title, String content, Integer userId);

    public List<Job> getAllJobs();

    public List<Job> getJobsPage(int page, int pageNum);

    public Job getJobById(int id);

    public void addVisitCount(int id);

    public int getJobCount();

    public List<Job> searchJobs(String keywords, int page, int pageNum);

    public int getSearchCount(String keywords);

    public void updateJob(Job job);

    public void deleteJob(int id);
}