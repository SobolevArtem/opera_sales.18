package ru.learnup.vtb.sobolevaa.operasales8.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.util.ResourceUtils;
import ru.learnup.vtb.sobolevaa.operasales8.services.interfaces.EmailService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.FileNotFoundException;

public class EmptyNotifier implements EmailService {

    @Override
    public void sendMsg(String toAddress, String subject, String message, String attachment){}

}