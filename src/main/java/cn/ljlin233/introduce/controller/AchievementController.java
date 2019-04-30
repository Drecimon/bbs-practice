package cn.ljlin233.introduce.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ljlin233.config.interceptor.AdminAuth;
import cn.ljlin233.config.interceptor.RootAuth;
import cn.ljlin233.config.interceptor.TeacherAuth;
import cn.ljlin233.introduce.entity.Achievement;
import cn.ljlin233.introduce.service.AchievementService;

/**
 * AchievementController
 */
@Controller
@RequestMapping("/api")
public class AchievementController {

    private AchievementService achievementService;

    public AchievementController() {}

    @Autowired
    public AchievementController(AchievementService achievementService) {
        this.achievementService = achievementService;
    }


    @TeacherAuth
    @AdminAuth
    @RootAuth
    @RequestMapping(value = "/achievements", method = RequestMethod.POST)
    public void addAchievement(HttpServletRequest request) {
        
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        Integer userId = Integer.valueOf(request.getParameter("userId"));

        achievementService.addAchievement(title, content, userId);

    }

    
    @RequestMapping(value = "/achievements", method = RequestMethod.GET)
    @ResponseBody
    public List<Achievement> getAllAchievements() {

        List<Achievement> all = achievementService.getAllAchievements();

        return all;
    }
    
}