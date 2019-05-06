package cn.ljlin233.announce.dao.impl;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import cn.ljlin233.announce.dao.ScopeDao;
import cn.ljlin233.announce.entity.Scope;

/**
 * ScopeDaoImpl
 */
public interface ScopeDaoImpl extends ScopeDao {

    @Override
    @Insert("insert into anno_scope (announce_id, department_id) values (#{announceId}, #{departmentId})")
    public void addScope(Scope scope);

    @Override
    @Delete("delete from anno_scope where id = #{id}")
    public void deleteScope(int id);
    
}