package cn.ljlin233.util.dao;

import static org.junit.Assert.assertEquals;

import javax.xml.crypto.KeySelector.Purpose;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.ljlin233.config.RootConfig;
import cn.ljlin233.config.WebConfig;
/**
 * VerificationDaoTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootConfig.class, WebConfig.class })
@WebAppConfiguration
public class VerificationDaoTest {

    @Autowired
    private VerificationDao verificationDao;


    @Test
    public void testVerficationDao() {

        String verCode = verificationDao.getVerificationCode("123");
        assertEquals(null, verCode);

    }


}