package com.ke.lisijia.spring_boot_demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailTest {

    @Autowired
    JavaMailSender javaMailSender ;

    static final String MY_MAIL = "1419268805@qq.com";

    @Test
    public void testSendMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(MY_MAIL);
        message.setTo(MY_MAIL);
        message.setSubject("testMail");
        message.setText("测试邮件");

        javaMailSender.send(message);
    }

    /**
     * 发送附件
     */
    @Test
    public void sendAttachmentsMail() throws Exception {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(MY_MAIL);
        helper.setTo(MY_MAIL);
        helper.setSubject("带附件邮件");
        helper.setText("附件");

        File file = new File("C:\\Users\\Administrator\\Desktop\\发票\\031001900111_65252829.pdf");
        helper.addAttachment("附件1.pdf", file);

        javaMailSender.send(mimeMessage);
    }

    /**
     * 嵌入静态资源
     */
    @Test
    public void sendInlineMail() throws Exception {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(MY_MAIL);
        helper.setTo(MY_MAIL);
        helper.setSubject("静态资源");
        helper.setText("<html><body><img src=\"cid:pic\" ></body></html>", true);

        File file = new File("C:\\Users\\Administrator\\Desktop\\工作文件\\下载.jpg");
        helper.addInline("pic", file);

        javaMailSender.send(mimeMessage);
    }
}
