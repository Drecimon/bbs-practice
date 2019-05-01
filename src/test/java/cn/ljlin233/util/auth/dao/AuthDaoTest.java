package cn.ljlin233.util.auth.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.ljlin233.config.RootConfig;
import cn.ljlin233.config.WebConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootConfig.class, WebConfig.class })
@WebAppConfiguration
/**
 * AuthDaoTest
 */
public class AuthDaoTest {

    @Autowired
    private AuthDao authDao;


    @Test
    public void testDao() {
        String tableName = "user_info";
        String column = "id";
        Integer id = new Integer(1);
        Integer ownId = authDao.getOwnerId(tableName, column, id);
        assertEquals("1", ownId.toString());
    }
    
}