package cn.ljlin233.user.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.ljlin233.config.RootConfig;
import cn.ljlin233.config.WebConfig;
import cn.ljlin233.util.verification.dao.VerificationDao;
import cn.ljlin233.util.verification.entity.Verification;
import cn.ljlin233.util.verification.service.VerificationService;
/**
 * UserRegisterServiceTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, WebConfig.class})
@WebAppConfiguration
public class UserRegisterServiceTest {


    @Autowired
    private UserRegisterService userRegisterService;

    @Autowired
    private VerificationService verificationService;

    @Autowired
    private VerificationDao verificationDao;

    @Test
    public void testRegister() {

        Verification verification = verificationService.getVerification();
        String verId = verification.getVerificationId();
        String verCode = verificationDao.getVerificationCode(verId);

        //userRegisterService.registerUser("5", "123", "student", "email@123.com", verId, verCode);
    }
    
}