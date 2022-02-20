package ru.learnup.vtb.sobolevaa.operasales8.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Seat {
    private final Integer number;
    private final Float price;

/*
    public Seat(Integer number, Float price) {
        this.number = number;
        this.price = price;
    }
*/

    @Override
    public String toString() {
        return number + "(" + price + "$)";
    }
}
