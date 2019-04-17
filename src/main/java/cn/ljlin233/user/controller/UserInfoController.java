package cn.ljlin233.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ljlin233.user.entity.UserInfo;
import cn.ljlin233.user.service.UserInfoService;

/**
 * UserInfoController
 */
@Controller
@RequestMapping("/api")
public class UserInfoController {

    private UserInfoService userInfoService;

    public UserInfoController() {}


    @Autowired
    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @RequestMapping(value = {"/user", "/user/"} , method = RequestMethod.GET)
    public String getAllUserInfo() {
        return "ALL";
    }


    @RequestMapping(value = {"/user"}, params = {"id"}, method = RequestMethod.GET)
    public String getUserInfo(@RequestParam int id) {
        //UserInfo userInfo = userInfoService.getUserInfo(id);
        //return Integer.toString(id);
        return "index";
    }

}