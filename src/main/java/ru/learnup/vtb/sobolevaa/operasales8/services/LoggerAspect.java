package ru.learnup.vtb.sobolevaa.operasales8.services;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import ru.learnup.vtb.sobolevaa.operasales8.services.interfaces.EmailService;

@Aspect
public class LoggerAspect {

    private final EmailService emailService;

    public LoggerAspect(EmailService emailService) {
        this.emailService = emailService;
    }

    @Pointcut("@annotation(ru.learnup.vtb.sobolevaa.operasales8.model.Loggable)")
    public void eventServiceLog() {}

    @Around("eventServiceLog()")
    public void aspectAround(ProceedingJoinPoint point) {
        String method = point.getSignature().getName();

        //send("Begin " + method);

        try {
            point.proceed();
            send("Finish " + method);
       } catch (Throwable e) {
            //send("Crash " + method);
        }

    }

    public void send(String message) {
        emailService.sendMsg(message);
    }
}
