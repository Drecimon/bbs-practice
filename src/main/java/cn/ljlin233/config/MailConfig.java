package cn.ljlin233.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
/**
 * MailConfig
 */
@Configuration
public class MailConfig {

    public static final String username = "lvjinlin42@foxmail.com";
    
    private static final String password = "thhyflnuwgzpigaa";

    @Bean
    public JavaMailSender mailSender() {
        // 创建邮件发送服务器
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.qq.com");
        mailSender.setUsername(username);
        mailSender.setPassword(password);
        // 加认证机制
        Properties javaMailProperties = new Properties();
    	javaMailProperties.put("mail.smtp.auth", "true");
    	javaMailProperties.put("mail.smtp.starttls.enable", "true");
        javaMailProperties.put("mail.smtp.timeout", "5000");
        javaMailProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        javaMailProperties.put("mail.smtp.port", "465");
        javaMailProperties.put("mail.smtp.socketFactory.port", "465");

        mailSender.setJavaMailProperties(javaMailProperties);

        return mailSender;
    }
    
}