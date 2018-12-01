package com.cdl.demo.utils;

import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

@Component
public class MyMailer {

    private Session session;
    private MimeMessage mimeMessage;

    public void createServer() {
        Properties properties = new Properties();
        properties.setProperty("mail.host", "smtp.qq.com");
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.port", "465");
        session = Session.getDefaultInstance(properties);
        session.setDebug(true);
    }

    public int addMessage(String toEmail) {
        mimeMessage = new MimeMessage(session);
        try {
            mimeMessage.addRecipients(Message.RecipientType.TO, toEmail);
            mimeMessage.setFrom(new InternetAddress("951045989@qq.com", "家校通", "UTF-8"));
            mimeMessage.setSubject("[家校通]邮箱验证码");
            int code = (int)((Math.random()*9+1)*100000);
            mimeMessage.setContent("欢迎注册家校通您的验证码是：" + code, "text/html;charset=utf-8");
            return code;
        } catch (MessagingException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void sendMessage() {
        try {
            Transport transport = session.getTransport();
            transport.connect("smtp.qq.com", "951045989@qq.com", "kbaezhyusojwbgai");
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            transport.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
