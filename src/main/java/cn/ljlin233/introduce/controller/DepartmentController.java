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

import cn.ljlin233.introduce.entity.Department;
import cn.ljlin233.introduce.entity.Member;
import cn.ljlin233.introduce.service.DepartmentService;
import cn.ljlin233.util.auth.AdminAuth;
import cn.ljlin233.util.auth.MyselfAuth;
import cn.ljlin233.util.auth.RootAuth;
import cn.ljlin233.util.auth.TeacherAuth;

/**
 * DepartmentController
 */
@Controller
@RequestMapping("/api")
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController() {}

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    // 增加一个部门
    @TeacherAuth
    @AdminAuth
    @RootAuth
    @RequestMapping(value = "/departments", method = RequestMethod.POST)
    public void addDepartment(HttpServletRequest request) {

        String name = request.getParameter("name");
        String description = request.getParameter("description");

        departmentService.addDepartment(name, description);

    }

    
    @RootAuth
    @RequestMapping(value = "/departments", method = RequestMethod.GET)
    @ResponseBody
    public Map<Object, Object> getAllDepartments() {
        
        List<Department> all = departmentService.getAllDepartments();
        int count = departmentService.getDepartmentCount();

        Map<Object, Object> result = new HashMap<>();

        result.put("totalCount", count);
        result.put("departments", all);

        return result;
    }

    // 按页获取所有部门
    @RequestMapping(value = "/departments", params = "page", method = RequestMethod.GET)
    @ResponseBody
    public Map<Object, Object> getDepartmentsByPage(@RequestParam int page) {
        
        List<Department> all = departmentService.getDepartmentsPage(page, 10);
        int count = departmentService.getDepartmentCount();

        Map<Object, Object> result = new HashMap<>();

        result.put("totalCount", count);
        result.put("departments", all);

        return result;
    }

    // 获取部门详情
    @RequestMapping(value = "/departments", params = "id", method = RequestMethod.GET)
    @ResponseBody
    public Department getDepartmentsById(@RequestParam int id) {
        
        Department result  = departmentService.getDepartmentById(id);
        return result;
    }

    // 搜索部门
    @RequestMapping(value = "/departments", params = {"search", "page"}, method = RequestMethod.GET)
    @ResponseBody
    public Map<Object, Object> searchDepartments(@RequestParam String search, @RequestParam int page) {
        
        List<Department> all = departmentService.searchDepartments(search, page, 10);
        int count = departmentService.getSearchCount(search);

        Map<Object, Object> result = new HashMap<>();

        result.put("totalCount", count);
        result.put("departments", all);

        return result;
    }

    // 部门成员列表
    @RequestMapping(value = "/members", params = {"departmentId", "page"}, method = RequestMethod.GET)
    @ResponseBody
    public Map<Object, Object> searchDepartments(@RequestParam int departmentId, @RequestParam int page) {
        
        List<Member> all = departmentService.getDepartmentMember(departmentId, page, 10);
        int count = departmentService.getMembersCount(departmentId);

        Map<Object, Object> result = new HashMap<>();

        result.put("totalCount", count);
        result.put("members", all);

        return result;
    }


    // 修改部门信息
    @AdminAuth
    @RootAuth
    @RequestMapping(value = "/departments", params = "id", method = RequestMethod.PUT)
    public void updateDepartments(@RequestParam int id, HttpServletRequest request) {
        
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        Department department = new Department();
        department.setName(name);
        department.setDescription(description);

        departmentService.updateDepartment(department);

    }

    // 删除
    @AdminAuth
    @RootAuth
    @RequestMapping(value = "/departments", params = "id", method = RequestMethod.DELETE)
    public void deleteDepartments(@RequestParam int id) {
        
        departmentService.deleteDepartment(id);
    }
}