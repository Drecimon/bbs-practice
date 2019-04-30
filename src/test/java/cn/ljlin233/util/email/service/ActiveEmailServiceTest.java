// package cn.ljlin233.util.email.service;

// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.test.context.ContextConfiguration;
// import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
// import org.springframework.test.context.web.WebAppConfiguration;

// import cn.ljlin233.config.RootConfig;
// import cn.ljlin233.config.WebConfig;

// import cn.ljlin233.util.email.entity.ActiveEmail;

// /**
//  * ActiveEmailServiceTest
//  */
// @RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration(classes = { RootConfig.class, WebConfig.class })
// @WebAppConfiguration
// public class ActiveEmailServiceTest {

//     @Autowired
//     private ActiveEmailService activeEmailService;

//     @Test
//     public void sendEmail() {
//         ActiveEmail activeEmail = new ActiveEmail();
//         activeEmail.setSendFrom("lvjinlin42@foxmail.com");
//         activeEmail.setSendTo("ljlin0120@qq.com");
//         activeEmail.setTitle("实验室账号激活链接");
//         activeEmail.setMessage("127.0.0.1/lab/user?activeId=" + "1234456");

//         //activeEmailService.sendActiveEamil(activeEmail);
//     }
// }