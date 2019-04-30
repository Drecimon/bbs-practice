package cn.ljlin233.user.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.ljlin233.config.RootConfig;
import cn.ljlin233.config.WebConfig;


/**
 * UserRoleDaoTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, WebConfig.class})
@WebAppConfiguration
public class UserRoleDaoTest {

    @Autowired
    private UserRoleDao userRoleDao;

    @Test
    public void testDao() {
        List<String> result = userRoleDao.getUserRoleByUserId(2);
        assertEquals("[student, teacher]", result.toString());
    }
    
}