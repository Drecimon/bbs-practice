package cn.ljlin233.introduce.dao;

import java.util.List;

import cn.ljlin233.introduce.entity.Department;
import cn.ljlin233.introduce.entity.Member;

/**
 * DepartmentDao
 */
public interface DepartmentDao {

    public void addDepartment(Department department);

    public List<Department> getAllDepartments();
    
    public List<Department> getDepartmentsPage(int start, int offset);

    public Department getDepartmentById(int id);

    public int getDepartmentCount();

    public List<Department> searchDepartments(String keywords, int start, int offset);

    public int getSearchCount(String keywords);

    public void updateDepartment(Department department);

    public void deleteDepartment(int id);

    public void deleteDepartmentMember(int id);

    public List<Member> getDepartmentMembers(int departmentId, int start, int offset);

    public int getMembersCount(int departmentId);

}