package ru.learnup.vtb.sobolevaa.operasales8.services;

import ru.learnup.vtb.sobolevaa.operasales8.model.Event;
import ru.learnup.vtb.sobolevaa.operasales8.model.Loggable;
import ru.learnup.vtb.sobolevaa.operasales8.services.interfaces.Logger;

import java.time.LocalDateTime;
import java.util.SortedMap;
import java.util.TreeMap;

public class EventService {
    private final SortedMap<String, Event> events = new TreeMap<>();
    private final Logger logger;

    public EventService(Logger logger) {
        this.logger = logger;
    }

    @Loggable
    public void addEvent(String name, String description, LocalDateTime date, Integer count, Integer ageLimit){
        events.put(name, new Event(logger, name, description, date, count, ageLimit));
        logger.print(String.format("Мероприятие %s добавлено!", name));
    }

    @Loggable
    public void editEvent(String name, String description, LocalDateTime date, Integer count, Integer ageLimit){
        final Event event = getEvent(name);
        if (event == null) {
            logger.printError(String.format("Мероприятие %s не найдено!", name));
            return;
        }
        event.edit(description, date, count, ageLimit);
        logger.print(String.format("Мероприятие %s изменено!", name));
    }

    public void deleteEvent(String name){
        final Event event = getEvent(name);
        if (event == null) {
            //throw new RuntimeException("Мероприятие $s не найдено!");
            logger.printError(String.format("Мероприятие %s не найдено!", name));
            return;
        }
        if (event.getSeats().occupiedSize() != 0) {
            logger.printError(String.format("На мероприятие %s уже проданы билеты!", name));
            return;
        }
        events.remove(name);
        logger.print(String.format("Мероприятие %s удалено!", name));
    }

    @Loggable
    public void buy(String name, Integer number){
        getEvent(name).getSeats().buy(number);
    }


    public Event getEvent(String name){
        return events.get(name);
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        for (Event event : events.values()) {
            ret.append("\n" + event.toString());
        }
        return ret.toString().substring(1) + "\n";
    }

}
