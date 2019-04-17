package cn.ljlin233.user.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.ljlin233.config.RootConfig;
//import cn.ljlin233.user.dao.UserInfoDao;
import cn.ljlin233.user.service.UserInfoService;

/**
 * UserInfoDaoTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class UserInfoDaoTest {


    @Autowired
    private UserInfoService userInfo;
    

    @Test
    public void testUserInfoDaoMapper() {
        assertNotNull(userInfo);
    }

    @Test
    public void getUserInfo() {
        assertEquals("id=1 account=1 email=123@qq.com",  userInfo.getUserInfo(1).toString());
        System.out.println(1);
    }
    
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext2 = new AnnotationConfigApplicationContext(RootConfig.class);
        String[] definitionNames = applicationContext2.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
    }


}

