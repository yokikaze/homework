package com.ke.lisijia.spring_boot_demo.web.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.slf4j.Logger;

@Controller
@RequestMapping("/mail")
public class MailController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JavaMailSender javaMailSender;

    @GetMapping("/test")
    public void sendTest() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("1419268805@qq.com");
        message.setTo("1419268805@qq.com");
        message.setSubject("test mail from Spring boot");
        message.setText("测试邮件");
        javaMailSender.send(message);
    }
}
