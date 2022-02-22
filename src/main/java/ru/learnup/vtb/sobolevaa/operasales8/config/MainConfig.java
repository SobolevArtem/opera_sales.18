package ru.learnup.vtb.sobolevaa.operasales8.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import ru.learnup.vtb.sobolevaa.operasales8.services.*;
import ru.learnup.vtb.sobolevaa.operasales8.services.interfaces.EmailService;
import ru.learnup.vtb.sobolevaa.operasales8.services.interfaces.Logger;

import java.util.Properties;

@Configuration
@Getter
@Import({LoggerConfig.class})
public class MainConfig {

    @Value("${init-parameters.notifier.type:default}")
    private String typeNotifier = null;

    @Bean
    public EventService eventService(Logger logger){
        return new EventService(logger);
    }

    @Bean
    public EmailService appNotifier(){
        if (typeNotifier.equals("email")) {
            JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
            return new EmailNotifier(mailSenderImpl);
        }
        return new EmptyNotifier();
    }

}
