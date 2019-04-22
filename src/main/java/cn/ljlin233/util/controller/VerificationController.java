package cn.ljlin233.util.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ljlin233.util.entity.Verification;
import cn.ljlin233.util.service.VerificationService;

/**
 * VerificationController
 */
@Controller
@RequestMapping("/api/verification")
public class VerificationController {

    private VerificationService verificationService;

    public VerificationController() {};

    @Autowired
    public VerificationController(VerificationService verificationService) {
        this.verificationService = verificationService;
    }
    

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Verification getVerification() {
        return verificationService.getVerification();
    }
    
}