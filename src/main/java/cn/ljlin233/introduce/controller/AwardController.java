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
import cn.ljlin233.introduce.entity.Award;
import cn.ljlin233.introduce.service.AwardService;

/**
 * AwardController
 */
@Controller
@RequestMapping("/api")
public class AwardController {

    private AwardService awardService;

    public AwardController() {}

    @Autowired
    public AwardController(AwardService awardService) {
        this.awardService = awardService;
    }

    // 增加一个奖项
    @TeacherAuth
    @AdminAuth
    @RootAuth
    @RequestMapping(value = "/awards", method = RequestMethod.POST)
    public void addAward(HttpServletRequest request) {

        String title = request.getParameter("title");
        String content = request.getParameter("content");
        Integer userId = Integer.valueOf(request.getParameter("userId"));

        awardService.addAward(title, content, userId);
    }

    // 获取所有奖项
    @RootAuth
    @RequestMapping(value = "/awards", method = RequestMethod.GET )
    @ResponseBody
    public Map<Object, Object> getAllAwards() {
        List<Award> all = awardService.getAllAwards();
        int count = awardService.getAwardCount();

        Map<Object, Object> map = new HashMap<>();
        map.put("totalCount", count);
        map.put("awards", all);

        return map;
    }

    // 按页获取奖项
    @RequestMapping(value = "/awards", params = "page", method = RequestMethod.GET )
    @ResponseBody
    public Map<Object, Object> getAwardsByPage(@RequestParam String page) {
        Integer pageInt = Integer.valueOf(page);

        List<Award> result = awardService.getAwardsPage(pageInt, 10);
        int count = awardService.getAwardCount();

        Map<Object, Object> map = new HashMap<>();
        map.put("totalCount", count);
        map.put("awards", result);

        return map;
    }

    // 按页搜索奖项
    @RequestMapping(value = "/awards", params = {"search", "page"}, method = RequestMethod.GET )
    @ResponseBody
    public Map<Object, Object> searchAwards(@RequestParam String search, @RequestParam String page) {
        Integer pageInt = Integer.valueOf(page);

        List<Award> result = awardService.searchAwards(search, pageInt, 10);
        int count = awardService.getSearchCount(search);

        Map<Object, Object> map = new HashMap<>();
        map.put("totalCount", count);
        map.put("awards", result);

        return map;
    }

    // 获取资源详情
    @RequestMapping(value = "/awards", params = "id", method = RequestMethod.GET)
    @ResponseBody
    public Award getAchievementsById(@RequestParam String id) {
        Integer idInt = Integer.valueOf(id);
        Award result = awardService.getAwardById(idInt);
        return result;
    }

    // 更新资源
    @MyselfAuth(tableName = "intro_award", column = "up_userid")
    @RequestMapping(value = "/awards", params = "id", method = RequestMethod.PUT)
    public void updateAward(@RequestParam String id, HttpServletRequest request) {
        Award award = new Award();
        award.setId(Integer.valueOf(id));
        award.setTitle(request.getParameter("title"));
        award.setContent(request.getParameter("content"));

        awardService.updateAward(award);
    }

    // 删除资源
    @MyselfAuth(tableName = "intro_award", column = "up_userid")
    @AdminAuth
    @RootAuth
    @RequestMapping(value = "/awards", params = "id", method = RequestMethod.DELETE)
    public void deleteAchievement(@RequestParam String id) {
        Integer idInt = Integer.valueOf(id);
        awardService.deleteAward(idInt);
    }
}