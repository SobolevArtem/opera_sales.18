package ru.learnup.vtb.sobolevaa.operasales8.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.util.ResourceUtils;
import ru.learnup.vtb.sobolevaa.operasales8.services.interfaces.EmailService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.FileNotFoundException;
import java.io.IOException;

public class EmailNotifier implements EmailService {

    @Value("${init-parameters.notifier.address:default}")
    private String emailTo;

    @Autowired
    private JavaMailSender emailSender;

    public EmailNotifier(JavaMailSender mailSender){
        this.emailSender = mailSender;
    }

    @Override
    public void sendMsg(String message){
        sendMsg(emailTo, "Event Message (" + this.getClass().getName() + ")", message, null);
    }

    public void sendMsg(String toAddress, String subject, String message, String attachment){
        try {
            if (attachment == null) {
                sendSimpleEmail(toAddress, subject, message);
            } else {
                sendEmailWithAttachment(toAddress, subject, message, attachment);
            }
        } catch (Exception e) {
            System.out.println("Error while sending out email..{}" + e.getStackTrace());
        }

    }

    private void sendSimpleEmail(String toAddress, String subject, String message) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(toAddress);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
        emailSender.send(simpleMailMessage);
    }

    private void sendEmailWithAttachment(String toAddress, String subject, String message, String attachment) throws MessagingException, FileNotFoundException {

        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
        messageHelper.setTo(toAddress);
        messageHelper.setSubject(subject);
        messageHelper.setText(message);
        FileSystemResource file = new FileSystemResource(ResourceUtils.getFile(attachment));
        messageHelper.addAttachment(attachment.substring(attachment.lastIndexOf("\\") + 1), file);
        emailSender.send(mimeMessage);
    }
}