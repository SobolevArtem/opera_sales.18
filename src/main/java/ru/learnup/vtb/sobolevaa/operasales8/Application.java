package ru.learnup.vtb.sobolevaa.operasales8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnup.vtb.sobolevaa.operasales8.services.EventService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		final ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);

		EventService events = ctx.getBean(EventService.class);

		events.addEvent("Травиата", "Джузеппе Верди", null,20,18);
		events.addEvent("Кармен", "Жорж Бизе", null,30,16);
		events.addEvent("Евгений Онегин", "П. И. Чайковский", null,5,6);
		events.getEvent("Травиата").getSeats().buyAny(12);
		System.out.println(events);

		events.editEvent("Кармен",null, null, null,33);
		System.out.println(events);

		events.getEvent("Евгений Онегин").getSeats().sellAny(6);
		events.editEvent("Евгений Онегин","П. И. Чайковский (рок-обработка)", null, 10,14);
		events.getEvent("Евгений Онегин").getSeats().buyAny(8);
		events.getEvent("Евгений Онегин").getSeats().sellAny(6);
		System.out.println(events);

		events.deleteEvent("Богема");
		events.deleteEvent("Кармен");
		System.out.println(events);
		System.out.println(events.getEvent("Евгений Онегин").getSeats());

	}

}
