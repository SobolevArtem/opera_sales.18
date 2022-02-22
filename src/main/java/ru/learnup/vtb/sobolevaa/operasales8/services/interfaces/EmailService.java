package ru.learnup.vtb.sobolevaa.operasales8.services.interfaces;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;

public interface EmailService {

    public default void sendMsg(String message){
        sendMsg(null, "Event Message (" + this.getClass().getName() + ")", message, null);
    }

    void sendMsg(final String toAddress, final String subject, final String message, final String attachment);
//    void sendSimpleEmail(final String toAddress, final String subject, final String message);
//    void sendEmailWithAttachment(final String toAddress, final String subject, final String message, final String attachment) throws MessagingException, FileNotFoundException;
}