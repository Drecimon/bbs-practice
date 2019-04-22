package cn.ljlin233.util.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.ljlin233.config.RootConfig;
import cn.ljlin233.config.WebConfig;
import cn.ljlin233.util.entity.Verification;

/**
 * VerifiationServiceTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootConfig.class, WebConfig.class })
@WebAppConfiguration
public class VerifiationServiceTest {

    @Autowired
    private VerificationService verificationService;

    @Test
    public void testVerficationService() {
        Verification verification = verificationService.getVerification();
        String verId = verification.getVerificationId();
        String verCode = verificationService.getVerificationCode(verId);
        boolean result = verificationService.checkVerification(verId, verCode);
        
        assertEquals(true, result);
        
    }


}