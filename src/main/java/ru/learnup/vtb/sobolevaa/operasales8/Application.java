package ru.learnup.vtb.sobolevaa.operasales8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnup.vtb.sobolevaa.operasales8.services.ConsoleLogger;
import ru.learnup.vtb.sobolevaa.operasales8.services.EventService;
import ru.learnup.vtb.sobolevaa.operasales8.services.interfaces.Logger;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		final ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);

		EventService events = ctx.getBean(EventService.class);

		events.addEvent("Test3-1", "проверка №3-1", null,22,18);
		events.addEvent("Test3-2", "проверка №3-2", null,23,16);
		events.deleteEvent("Qqqq");
		events.addEvent("Test1-3", "проверка №3-3", null,5,6);
		events.getEvent("Test3-1").getSeats().buyAny(12);
		System.out.println(events);

		events.editEvent("Test3-2",null, null, null,33);
		System.out.println(events);

		events.getEvent("Test1-3").getSeats().sellAny(6);
		events.editEvent("Test1-3","NEW проверка №3-3", null, 10,14);
		events.getEvent("Test1-3").getSeats().buyAny(8);
		events.getEvent("Test1-3").getSeats().sellAny(6);
		System.out.println(events);

		events.deleteEvent("Test3-2");
		System.out.println(events);
		System.out.println(events.getEvent("Test1-3").getSeats());

	}

}
