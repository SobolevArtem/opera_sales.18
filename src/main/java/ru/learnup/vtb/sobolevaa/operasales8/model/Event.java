package ru.learnup.vtb.sobolevaa.operasales8.model;

import ru.learnup.vtb.sobolevaa.operasales8.services.SeatService;
import ru.learnup.vtb.sobolevaa.operasales8.services.interfaces.Logger;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Event {

    private Integer ageLimit;
    private SeatService seats;
    private final String name;
    private String description;
    private LocalDateTime date;
    private Logger logger;

    public SeatService getSeats() {
        return seats;
    }

    public Event(Logger logger, String name, String description, LocalDateTime date, Integer count, Integer ageLimit){
        this.logger = logger;
        this.name = name;
        this.description = description;
        this.ageLimit = ageLimit;
        this.seats = new SeatService(logger, count);
        this.date = date != null ? date : LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(9,0));
    }

    public void edit(String description, LocalDateTime date, Integer count, Integer ageLimit){
        if (getSeats().occupiedSize() != 0) {
            return;
        }
        if (description != null) this.description = description;
        if (ageLimit != null) this.ageLimit = ageLimit;
        if (count != null) this.seats = new SeatService(logger, count);
        if (date != null) this.date = date;
    }

    @Override
    public String toString() {
        return
            name +
            " " + date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")) + " " +
            " (" + description + "), " +
            ageLimit + "+," +
            " мест: " + seats.freeSize() + "/" + seats.size();
    }
}
