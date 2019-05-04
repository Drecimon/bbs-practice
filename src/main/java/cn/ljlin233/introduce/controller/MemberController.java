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

import cn.ljlin233.introduce.entity.Member;
import cn.ljlin233.introduce.service.MemberService;
import cn.ljlin233.util.auth.AdminAuth;
import cn.ljlin233.util.auth.RootAuth;
import cn.ljlin233.util.auth.TeacherAuth;

/**
 * MemberController
 */
@Controller
@RequestMapping("/api")
public class MemberController {

    
    private MemberService memberService;

    public MemberController() {}

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @RequestMapping(value = "/members", method = RequestMethod.GET)
    @ResponseBody
    public Map<Object, Object> getAllMembers() {
        List<Member> all = memberService.getAllMembers();
        int count = memberService.getAllMembersCounts();

        Map<Object, Object> result = new HashMap<>();

        result.put("totalCount", count);
        result.put("members", all);

        return result;
    }

    @RequestMapping(value = "/members", params = "page", method = RequestMethod.GET)
    @ResponseBody
    public Map<Object, Object> getMembersByPage(@RequestParam int page) {
        List<Member> all = memberService.getAllMembersByPage(page, 10);
        int count = memberService.getAllMembersCounts();

        Map<Object, Object> result = new HashMap<>();

        result.put("totalCount", count);
        result.put("members", all);

        return result;
    }


    @RequestMapping(value = "/members", params = "id", method = RequestMethod.GET)
    @ResponseBody
    public Member getMembersById(@RequestParam int id) {
        Member result = memberService.getMemberById(id);
        return result;
    }


    @RequestMapping(value = "/members", params = {"search", "page"}, method = RequestMethod.GET)
    @ResponseBody
    public Map<Object, Object> searchMembers(@RequestParam String search ,@RequestParam int page) {
        List<Member> all = memberService.searchMembersByName(search, page, 10);
        int count = memberService.getSearchCounts(search);

        Map<Object, Object> result = new HashMap<>();

        result.put("totalCount", count);
        result.put("members", all);

        return result;
    }


    @TeacherAuth @AdminAuth @RootAuth
    @RequestMapping(value = "/members", method = RequestMethod.POST)
    public void addMember(HttpServletRequest request) {

        Integer memberId = Integer.valueOf(request.getParameter("memberId"));
        Integer departmentId = Integer.valueOf(request.getParameter("departmentId"));
        String memberName = request.getParameter("memberName");
        String memberType = request.getParameter("memberType");

        memberService.addMember(memberId, memberType, memberName, departmentId);
    }


    @TeacherAuth @AdminAuth @RootAuth
    @RequestMapping(value = "/members", params = "id", method = RequestMethod.DELETE)
    public void deleteMember(@RequestParam int id) {

        memberService.deleteMember(id);
    }

}