package cn.ljlin233.introduce.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * AchievementController
 */
@Controller
@RequestMapping("/api")
public class AchievementController {


    @RequestMapping(value = "/achievements", method = RequestMethod.POST)
    public void addAchievement(HttpServletRequest request) {
        
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String userId = request.getParameter("userId");
        String nickname = request.getParameter("nickname");


    }
    
}