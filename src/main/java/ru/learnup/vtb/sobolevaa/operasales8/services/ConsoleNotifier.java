package ru.learnup.vtb.sobolevaa.operasales8.services;

import org.springframework.beans.factory.annotation.Value;
import ru.learnup.vtb.sobolevaa.operasales8.services.interfaces.EmailService;

public class ConsoleNotifier implements EmailService {

    @Value("${init-parameters.notifier.address:default}")
    private String emailTo;

    @Override
    public void sendMsg(String message){
        sendMsg(emailTo, "Event Message (" + this.getClass().getSimpleName() + ")", message, null);
    }

    public void sendMsg(String toAddress, String subject, String message, String attachment){
            System.out.println(String.format("SEND to:%s, subject:%s, message:%s", toAddress, subject, message));
    }

}