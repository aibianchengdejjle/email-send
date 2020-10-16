package com.jjl;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.security.GeneralSecurityException;
import java.util.Properties;

/*
*   带照片的邮件
*
* */
public class MailDemo02  {
    public static void main(String[] args) throws MessagingException, GeneralSecurityException {
        Properties props = new Properties();
        // 表示SMTP发送邮件，必须进行身份验证
        props.put("mail.smtp.auth", "true");
        //此处填写SMTP服务器
        props.put("mail.host", "smtp.qq.com");
        //邮件发送协议
        props.put("mail.transport.protocol","smtp");
        //设置SSL加密
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.socketFactory", sf);
        //1.创建定义整个应用程序所需的环境信息的Session对象
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("1044839685@qq.com", "dswgabkmopdmbejh");
            }
        });
        //开启debug模式
        session.setDebug(true);
        //2.通过session得到transport对象
        Transport ts=session.getTransport();
        //使用 邮箱的用户名和授权码脸上邮件服务器
        ts.connect("smtp.qq.com","1044839685@qq.com", "dswgabkmopdmbejh");
        //3.创建邮件
        MimeMessage message=new MimeMessage(session);
        message.setFrom(new InternetAddress("1044839685@qq.com"));//指名发送人
        message.setRecipient(Message.RecipientType.TO,new InternetAddress("1044839685@qq.com"));//指名邮件的收件人
        message.setSubject("带照片的文件了");//文件的主题
        //================================================复杂邮件
        MimeBodyPart image=new MimeBodyPart();
        DataHandler dh=new DataHandler(new FileDataSource("E:\\untitled5maven\\功能拓展\\mail-java\\src\\recourse\\DSC_9945.jpg"));
        image.setDataHandler(dh);//将照片放入到prat当中
        image.setContentID("20.jpg");

        //准备正文数据
        MimeBodyPart text=new MimeBodyPart();
        text.setContent("这是一封带照片的邮件<img src='cid:20.jpg'>的邮件","text/html;charset=UTF-8");
        //描述数据关系
        MimeMultipart multipart=new MimeMultipart();
        multipart.addBodyPart(image);
        multipart.addBodyPart(text);
        multipart.setSubType("related");
        //设置到消息当中，保存修改
        message.setContent(multipart);
        message.saveChanges();
        //=================================================
        //4.发送邮件
        ts.sendMessage(message,message.getAllRecipients());
        //关闭链接
        ts.close();
    }
}
