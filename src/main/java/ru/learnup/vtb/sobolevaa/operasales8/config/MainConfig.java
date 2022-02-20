package ru.learnup.vtb.sobolevaa.operasales8.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.learnup.vtb.sobolevaa.operasales8.services.ConsoleLogger;
import ru.learnup.vtb.sobolevaa.operasales8.services.EventService;
import ru.learnup.vtb.sobolevaa.operasales8.services.interfaces.Logger;

@Configuration
@Getter
@Import({LoggerConfig.class})
public class MainConfig {

    @Bean
    public EventService eventService(Logger logger){
//    public EventService eventService(@Qualifier("emailLogger") Logger logger){
        return new EventService(logger);
    }
}
