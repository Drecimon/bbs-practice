package cn.ljlin233.introduce.service;

import java.util.List;

import cn.ljlin233.introduce.entity.Department;
import cn.ljlin233.introduce.entity.Member;

/**
 * DepartmentService
 */
public interface DepartmentService {

    
    public void addDepartment(String name, String description);

    public List<Department> getAllDepartments();

    public List<Department> getDepartmentsPage(int page, int pageNum);

    public Department getDepartmentById(int id);

    public int getDepartmentCount();

    public List<Department> searchDepartments(String keywords, int page, int pageNum);

    public int getSearchCount(String keywords);

    public void updateDepartment(Department department);

    public void deleteDepartment(int id);

    public List<Member> getDepartmentMember(int id, int page, int pageNum);

    public int getMembersCount(int departmentId);
}