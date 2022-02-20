package ru.learnup.vtb.sobolevaa.operasales8.services.interfaces;

public interface Logger {

    void print(Object obj);
    default void printError(Object obj) {
        this.print("ERROR -> " + obj.toString().toUpperCase());
    };
}
