package cn.ljlin233.user.dao.impl;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.jdbc.SQL;

import cn.ljlin233.user.dao.UserInfoDao;
import cn.ljlin233.user.entity.UserInfo;

/**
 * UserInfoDaoMapper
 */
public interface UserInfoDaoMapper extends UserInfoDao {

    @Override
    @Insert("insert into user_info (account, email, register_time, active_id) values (#{account}, #{email}, #{registerTime}, #{activeId})")
    public void addUserInfo(@Param("account") String account, @Param("email") String email, 
        @Param("registerTime") String registerTime, @Param("activeId") String activeId );
        

    @Override
    @Delete("delete from user_info where id = #{id}")
    public void deleteUserInfo(int id);


    @Override
    @UpdateProvider(type = InnerUserInfoDaoSQL.class, method = "updateUserInfo")
    public void updateUserInfo(UserInfo userInfo);


    @Override
    public List<UserInfo> getAllUserInfo();


    @Override
    @Select("select * from user_info where id = #{id}")
    @Results({
        @Result(column = "register_time", property = "registerTime"),
        @Result(column = "profile_picture", property = "profilePicture"),
        @Result(column = "active_id", property = "activeId"),
    })
    public UserInfo getUserInfoById(int id);
    

    @Override
    @Select("select id from user_info where account = #{account}")
    public int getUserIdByAccount(String account);


    @Override
    @SelectProvider(type = InnerUserInfoDaoSQL.class, method = "getUserIdByActiveId")
    public int getUserIdByActiveId(String activeId);

    @Override
    @Select("select count(1) from user_info where account = #{account}")
    public int existsAccount(String account);


    @Override
    @Select("select count(1) from user_info where email = #{email}")
    public int existsEmail(String email);


    @Override
    @Select("select count(1) from user_info where phone = #{phone}")
    public int existsPhone(String phone);


    @Override
    @Select("select active from user_info where account = #{account}")
    public int isActive(String account);

    @Override
    @Update("update ${tableName} set ${colname} = #{newname} where ${idCol} = #{userId}" )
    public void updateUsername(@Param("tableName") String tableName, @Param("nameCol") String nameCol,
         @Param("newName") String newName, @Param("idCol") String idCol, @Param("userId") int userId);

    /**
     * InnerUserInfoDaoMapper
     */
    class InnerUserInfoDaoSQL {
    
        public String updateUserInfo(UserInfo userInfo) {
            return new SQL() {{
                UPDATE("user_info");
                if (userInfo.getAccount() != null ) {
                    SET("account = #{account}");
                }
                if (userInfo.getEmail() != null) {
                    SET("email = #{email}");
                }
                if (userInfo.getPhone() != null ) {
                    SET("phone = #{phone}");
                }
                if (userInfo.getNickname() != null) {
                    SET("nickname = #{nickname}");
                }
                if (userInfo.getIntroduction() != null) {
                    SET("introduction = #{introduction}");
                }
                if (userInfo.getRegisterTime() != null) {
                    SET("register_time = #{registerTime}");
                }
                if (userInfo.getProfilePicture() != null) {
                    SET("profile_picture = #{profilePicture}");
                }
                if (userInfo.getActive() != null) {
                    SET("active = #{active}");
                }
                if (userInfo.getActiveId() != null) {
                    SET("active_id = #{activeId}");
                }
                if (userInfo.getIsban() != null) {
                    SET("isban = #{isban}");
                }
                WHERE("id = #{id}");
            }}.toString();
        }
        
        public String getUserIdByActiveId(String activeId) {
            return new SQL() {{
                SELECT("id");
                FROM("user_info");
                if (activeId != null) {
                    WHERE("active_id = #{activeId}");
                }
            }}.toString();
        }
    }
}