package ru.learnup.vtb.sobolevaa.operasales8.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import ru.learnup.vtb.sobolevaa.operasales8.services.*;
import ru.learnup.vtb.sobolevaa.operasales8.services.interfaces.EmailService;
import ru.learnup.vtb.sobolevaa.operasales8.services.interfaces.Logger;

public class LoggerConfig {

//    @Bean
//    @Profile("console")
//    public Logger emailLogger(){
//        return new EmailLogger();
//    }
//
//    @Bean
//    @Profile("email")
//    public Logger consoleLogger(){
//        return new ConsoleLogger();
//    }

    @Value("${init-parameters.logger.type:default}")
    private String typeLogger = null;

    @Bean
    public Logger appLogger(){
        if (typeLogger.equals("console")) return new ConsoleLogger();
        if (typeLogger.equals("email")) return new EmailLogger();
        return new EmptyLogger();
    }

    @Bean
    public LoggerAspect appAspect(EmailService emailService) {
        return new LoggerAspect(emailService);
    }

}
