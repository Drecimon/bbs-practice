package cn.ljlin233.user.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.ljlin233.config.RootConfig;
import cn.ljlin233.config.WebConfig;
import cn.ljlin233.user.entity.UserInfo;
import cn.ljlin233.util.page.Page;


/**
 * UserInfoDaoTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, WebConfig.class})
@WebAppConfiguration
public class UserInfoDaoTest {


    @Autowired
    private UserInfoDao userInfoDao;

    @Test
    public void testDao() {

        Page<UserInfo> page = new Page<>();
        page.setPageNo(1);
        page.setPageSize(1);

        List<UserInfo> result = userInfoDao.getAllUserInfo(page);

        assertNotNull(result);

    }
    
}