package cn.ljlin233.introduce.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ljlin233.util.auth.*;

import cn.ljlin233.introduce.entity.Job;
import cn.ljlin233.introduce.service.JobService;


/**
 * JobController
 */
@Controller
@RequestMapping("/api")
public class JobController {

    private JobService jobService;

    public JobController() {}

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    // 增加一个招聘信息
    @TeacherAuth
    @AdminAuth
    @RootAuth
    @RequestMapping(value = "/jobs", method = RequestMethod.POST)
    public void addJob(HttpServletRequest request) {
        
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        Integer userId = Integer.valueOf(request.getParameter("userId"));

        jobService.addJob(title, content, userId);

    }

    // 获取所有招聘信息
    @RootAuth
    @RequestMapping(value = "/jobs", method = RequestMethod.GET)
    @ResponseBody
    public Map<Object, Object> getAllJobs() {
        List<Job> all = jobService.getAllJobs();
        int count = jobService.getJobCount();

        Map<Object, Object> map = new HashMap<>();
        map.put("totalCount", count);
        map.put("jobs", all);

        return map;
    }

    // 按页获取所有招聘信息
    @RequestMapping(value = "/jobs", params = "page", method = RequestMethod.GET)
    @ResponseBody
    public Map<Object, Object> getJobsPage(@RequestParam int page) {

        List<Job> result = jobService.getJobsPage(page, 10);
        int count = jobService.getJobCount();
        Map<Object, Object> map = new HashMap<>();
        map.put("totalCount", count);
        map.put("jobs", result);

        return map;
    }

    // 按页搜索招聘信息
    @RequestMapping(value = "/jobs", params = {"search", "page" }, method = RequestMethod.GET)
    @ResponseBody
    public Map<Object, Object> searchJobs(@RequestParam String search, @RequestParam int page) {
        
        List<Job> result = jobService.searchJobs(search, page, 10);
        int count = jobService.getSearchCount(search);
        Map<Object, Object> map = new HashMap<>();
        map.put("totalCount", count);
        map.put("jobs", result);

        return map;
    }

    // 获取招聘信息详情
    @RequestMapping(value = "/jobs", params = "id", method = RequestMethod.GET)
    @ResponseBody
    public Job getJobsById(@RequestParam int id) {

        Job result = jobService.getJobById(id);
        return result;
    }

    // 更新招聘信息
    @MyselfAuth(tableName = "intro_job", column = "up_userid")
    @RequestMapping(value = "/jobs", params = "id", method = RequestMethod.PUT)
    public void updateJob(@RequestParam int id, HttpServletRequest request) {
        Job job = new Job();
        job.setId(id);
        job.setTitle(request.getParameter("title"));
        job.setContent(request.getParameter("content"));

        jobService.updateJob(job);
    }


    // 删除招聘信息
    @MyselfAuth(tableName = "intro_job", column = "up_userid")
    @AdminAuth
    @RootAuth
    @RequestMapping(value = "/jobs", params = "id", method = RequestMethod.DELETE)
    public void deleteJob(@RequestParam int id) {
        jobService.deleteJob(id);
    }

}