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

    // 增加一个资源
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

    // 获取所有资源
    @RootAuth
    @RequestMapping(value = "/achievements", method = RequestMethod.GET)
    @ResponseBody
    public Map<Object, Object> getAllAchievements() {
        List<Achievement> all = achievementService.getAllAchievements();
        int count = achievementService.getAchievementCount();

        Map<Object, Object> map = new HashMap<>();
        map.put("totalCount", count);
        map.put("achievements", all);

        return map;
    }

    // 按页获取所有资源
    @RequestMapping(value = "/achievements", params = "page", method = RequestMethod.GET)
    @ResponseBody
    public Map<Object, Object> getAchievementsPage(@RequestParam String page) {
        Integer pageInt = Integer.valueOf(page);
        List<Achievement> result = achievementService.getAchievementsPage(pageInt, 10);
        int count = achievementService.getAchievementCount();
        Map<Object, Object> map = new HashMap<>();
        map.put("totalCount", count);
        map.put("achievements", result);

        return map;
    }

    // 按页搜索资源
    @RequestMapping(value = "/achievements", params = {"search", "page" }, method = RequestMethod.GET)
    @ResponseBody
    public Map<Object, Object> searchAchievements(@RequestParam String search, @RequestParam String page) {
        Integer pageInt = Integer.valueOf(page);
        List<Achievement> result = achievementService.searchAchievements(search, pageInt, 10);
        int count = achievementService.getSearchCount(search);
        Map<Object, Object> map = new HashMap<>();
        map.put("totalCount", count);
        map.put("achievements", result);

        return map;
    }

    // 获取资源详情
    @RequestMapping(value = "/achievements", params = "id", method = RequestMethod.GET)
    @ResponseBody
    public Achievement getAchievementsById(@RequestParam String id) {
        Integer idInt = Integer.valueOf(id);
        Achievement result = achievementService.getAchievementById(idInt);
        return result;
    }

    // 更新资源
    @MyselfAuth(tableName = "intro_achievement", column = "up_userid")
    @RequestMapping(value = "/achievements", params = "id", method = RequestMethod.PUT)
    public void updateAchievement(@RequestParam String id, HttpServletRequest request) {
        Achievement achievement = new Achievement();
        achievement.setId(Integer.valueOf(id));
        achievement.setTitle(request.getParameter("title"));
        achievement.setContent(request.getParameter("content"));

        achievementService.updateAchievement(achievement);
    }


    // 删除资源
    @MyselfAuth(tableName = "intro_achievement", column = "up_userid")
    @AdminAuth
    @RootAuth
    @RequestMapping(value = "/achievements", params = "id", method = RequestMethod.DELETE)
    public void deleteAchievement(@RequestParam String id) {
        Integer idInt = Integer.valueOf(id);
        achievementService.deleteAchievement(idInt);
    }

}