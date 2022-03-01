package ru.learnup.vtb.sobolevaa.operasales8.services;

import org.springframework.stereotype.Component;
import ru.learnup.vtb.sobolevaa.operasales8.model.Loggable;
import ru.learnup.vtb.sobolevaa.operasales8.model.Seat;
import ru.learnup.vtb.sobolevaa.operasales8.services.interfaces.Logger;

import java.util.SortedMap;
import java.util.TreeMap;

public class SeatService {

    private final SortedMap<Integer, Seat> occupied = new TreeMap<>();
    private final SortedMap<Integer, Seat> free = new TreeMap<>();
    private final Logger logger;

    public SeatService(Logger logger, Integer count) {
        for (Integer i = 0; i < count; i++) {
            free.put(i + 1, new Seat(i + 1, 1.0F));
        }
        this.logger = logger;
    }

    public void buy(Integer number){
        if (free.containsKey(number)) {
            occupied.put(number, free.get(number));
            free.remove(number);
            logger.print(String.format("Билет № %s продан!", number));
        } else {
            logger.printError(String.format("Билет № %s отсутствует в продаже!", number));
        }
    }

    public void sell(Integer number){
        if (occupied.containsKey(number)) {
            free.put(number, occupied.get(number));
            occupied.remove(number);
            logger.print(String.format("Билет № %s сдан!", number));
        } else {
            logger.printError(String.format("Билет № %s отсутствует среди купленных!", number));
        }
    }

    public void buyAny(Integer count){
        if (freeSize()>=count) {
            for (int i = 0; i < count; i++){
                buy(free.firstKey());
            }
        } else {
            logger.printError(String.format("Нет столько (%s) билетов в продаже!", count));
        }
    }

    @Loggable
    public void sellAny(Integer count){
        if (occupiedSize()>=count) {
            for (int i = 0; i < count; i++){
                sell(occupied.lastKey());
            }
        } else {
            logger.printError(String.format("Нет столько (%s) купленных билетов!", count));
        }
    }

    public int size(){
        return occupiedSize() + freeSize();
    }

    public int freeSize(){
        return free.size();
    }

    public int occupiedSize(){
        return occupied.size();
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("Свободные:");
        for (Seat seat : free.values()) {
            ret.append(" " + seat.toString());
        }
        ret.append("; Занятые:");
        for (Seat seat : occupied.values()) {
            ret.append(" " + seat.toString());
        }
        return ret.toString();
    }
}
