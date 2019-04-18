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
    private UserInfo userInfo;

    public UserInfoController() {}


    @Autowired
    public UserInfoController(UserInfoService userInfoService, UserInfo userInfo) {
        this.userInfoService = userInfoService;
        this.userInfo = userInfo;
    }

    @RequestMapping(value = {"/user", "/user/"} , method = RequestMethod.GET)
    public String getAllUserInfo() {
        return "ALL";
    }


    @RequestMapping(value = {"/user"}, params = {"id"}, method = RequestMethod.GET)
    @ResponseBody
    public UserInfo getUserInfo(@RequestParam int id) {
        userInfo = userInfoService.getUserInfo(id);
        //return Integer.toString(id);
        return userInfo;
    }

}