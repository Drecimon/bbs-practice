package cn.ljlin233.util.verification.service;

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
import cn.ljlin233.util.verification.entity.Verification;

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

        assertNotNull(verification.getVerificationId());
        assertNotNull(verification.getVerificationImage());
        
    }


}